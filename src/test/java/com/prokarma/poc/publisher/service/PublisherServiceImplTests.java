package com.prokarma.poc.publisher.service;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.prokarma.poc.publisher.Utility;
import com.prokarma.poc.publisher.constants.PublisherConstant;
import com.prokarma.poc.publisher.kafka.KafkaPublisher;
import com.prokarma.poc.publisher.model.CustomerDetailsResponse;
import com.prokarma.poc.publisher.services.PublisherServiceImpl;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class PublisherServiceImplTests {

    @InjectMocks
    PublisherServiceImpl publisherService;

    @Mock
    KafkaPublisher kafkaPublisher;

    @Test
    public void testPostMessageWhenValidCustomerDetailsPassed() {
        CustomerDetailsResponse customerDetailsResponse = publisherService.postMessage(Utility.createCustomerDetails());
        Mockito.verify(kafkaPublisher, Mockito.times(1)).publish(ArgumentMatchers.any(ObjectNode.class));
        Assert.assertNotNull(customerDetailsResponse);
        Assert.assertEquals(PublisherConstant.SUCCESS, customerDetailsResponse.getStatus());
    }

}
