package com.prokarma.poc.publisher.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.prokarma.poc.publisher.constants.PublisherConstant;
import com.prokarma.poc.publisher.kafka.KafkaPublisher;
import com.prokarma.poc.publisher.model.CustomerDetails;
import com.prokarma.poc.publisher.model.CustomerDetailsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class PublisherServiceImpl implements PublisherService {

    private ObjectMapper objectMapper = new ObjectMapper();

    private KafkaPublisher kafkaPublisher;

    @Autowired
    PublisherServiceImpl(KafkaPublisher kafkaPublisher) {
        this.kafkaPublisher = kafkaPublisher;
    }

    @PostConstruct
    void setDefaultValues() {
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
    }

    @Override
    public CustomerDetailsResponse postMessage(CustomerDetails customerDetails) {

        ObjectNode objectNode = objectMapper.convertValue(customerDetails, ObjectNode.class);
        objectNode.put(PublisherConstant.CUSTOMER_DETAILS_CUSTOMER_STATUS, CustomerDetails.CustomerStatusEnum.valueOf(objectNode.get(PublisherConstant.CUSTOMER_DETAILS_CUSTOMER_STATUS).textValue()).getValue());
        kafkaPublisher.publish(objectNode);
        return new CustomerDetailsResponse(PublisherConstant.SUCCESS, PublisherConstant.PUBLISH_SUCCESSFUL);
    }
}
