package com.prokarma.poc.publisher.service;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.prokarma.poc.publisher.constants.PublisherConstant;
import com.prokarma.poc.publisher.kafka.KafkaPublisher;
import com.prokarma.poc.publisher.model.CustomerDetailsResponse;
import com.prokarma.poc.publisher.services.PublisherServiceImpl;
import com.prokarma.poc.publisher.util.TestUtil;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class PublisherServiceImplTests {

    @InjectMocks
    PublisherServiceImpl publisherService;

    @Mock
    KafkaPublisher kafkaPublisher;

    @Test
    public void testPostMessageWhenValidCustomerDetailsPassed() {
        CustomerDetailsResponse customerDetailsResponse = publisherService.postMessage(TestUtil.createCustomerDetails());
        Mockito.verify(kafkaPublisher, Mockito.times(1)).publish(ArgumentMatchers.any(ObjectNode.class));
        Assert.assertNotNull(customerDetailsResponse);
        Assert.assertEquals(PublisherConstant.SUCCESS, customerDetailsResponse.getStatus());
    }

}
