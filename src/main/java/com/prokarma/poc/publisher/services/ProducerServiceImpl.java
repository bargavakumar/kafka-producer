package com.prokarma.poc.publisher.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.prokarma.poc.publisher.constants.PublisherConstant;
import com.prokarma.poc.publisher.exceptions.PublisherException;
import com.prokarma.poc.publisher.kafka.KafkaPublisher;
import com.prokarma.poc.publisher.model.CustomerDetails;
import com.prokarma.poc.publisher.model.CustomerDetailsResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProducerServiceImpl implements ProducerService {

    private static Logger logger = LoggerFactory.getLogger(ProducerServiceImpl.class);
    private ObjectMapper objectMapper;

    private KafkaPublisher kafkaPublisher;

    @Autowired
    ProducerServiceImpl(KafkaPublisher kafkaPublisher, ObjectMapper objectMapper) {
        this.kafkaPublisher = kafkaPublisher;
        this.objectMapper = objectMapper;
    }

    @Override
    public CustomerDetailsResponse postMessage(CustomerDetails customerDetails) {

        try {
            ObjectNode objectNode = objectMapper.convertValue(customerDetails, ObjectNode.class);
            objectNode.put(PublisherConstant.CUSTOMER_STATUS, CustomerDetails.CustomerStatusEnum.valueOf(objectNode.get(PublisherConstant.CUSTOMER_STATUS).textValue()).getValue());
            kafkaPublisher.publish(objectNode);
        } catch (IllegalArgumentException ex) {
            logger.error("Exception thrown while converting to Object node {}", ex.getMessage());
            throw new PublisherException(ex.getMessage());
        }

        return new CustomerDetailsResponse(PublisherConstant.SUCCESS, PublisherConstant.PUBLISH_SUCCESSFUL);
    }
}
