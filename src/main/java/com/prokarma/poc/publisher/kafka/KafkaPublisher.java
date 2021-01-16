package com.prokarma.poc.publisher.kafka;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.prokarma.poc.publisher.exceptions.PublisherException;
import com.prokarma.poc.publisher.services.ProducerServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Component
public class KafkaPublisher {
    private static final Logger logger = LoggerFactory.getLogger(ProducerServiceImpl.class);

    @Value("${kafka-topic}")
    private String topic;

    private KafkaTemplate<String, ObjectNode> kafkaTemplate;

    @Autowired
    KafkaPublisher(KafkaTemplate<String, ObjectNode> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void publish(ObjectNode objectNode) {
        ListenableFuture<SendResult<String, ObjectNode>> listenableFuture = kafkaTemplate.send(topic, objectNode);
        listenableFuture.addCallback(new ListenableFutureCallback<SendResult<String, ObjectNode>>() {
            @Override
            public void onFailure(Throwable ex) {
                logger.error("Telemetry Events: Type = METRIC | Message failed to send to Kafka");
                throw new PublisherException(ex.getMessage());
            }

            @Override
            public void onSuccess(SendResult<String, ObjectNode> result) {
                logger.info("Telemetry Events: Type = METRIC | Message Sent SuccessFully to Kafka");
            }
        });


    }
}
