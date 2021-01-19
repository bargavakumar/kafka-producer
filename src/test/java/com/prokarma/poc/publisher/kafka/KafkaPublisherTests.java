package com.prokarma.poc.publisher.kafka;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.prokarma.poc.publisher.exceptions.PublisherException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.mock;

@RunWith(MockitoJUnitRunner.class)
public class KafkaPublisherTests {

    @InjectMocks
    KafkaPublisher kafkaPublisher;

    @Mock
    KafkaTemplate<String, ObjectNode> kafkaTemplate;

    private ObjectMapper objectMapper = new ObjectMapper();

    @Before
    public void setUp() {
        ReflectionTestUtils.setField(kafkaPublisher, "topic", "test-topic");
    }

    @Test
    public void testPublish() {
        ListenableFuture<SendResult<String, ObjectNode>> responseFuture = mock(ListenableFuture.class);
        ObjectNode objectNode = objectMapper.createObjectNode();
        SendResult<String, ObjectNode> sendResult = mock(SendResult.class);
        Mockito.when(kafkaTemplate.send("test-topic", objectNode)).thenReturn(responseFuture);
        doAnswer(invocationOnMock -> {
            ListenableFutureCallback listenableFutureCallback = invocationOnMock.getArgument(0);
            listenableFutureCallback.onSuccess(sendResult);
            return null;
        }).when(responseFuture).addCallback(ArgumentMatchers.any(ListenableFutureCallback.class));
        kafkaPublisher.publish(objectNode);
        Mockito.verify(kafkaTemplate, Mockito.times(1)).send("test-topic", objectNode);
    }

    @Test(expected = PublisherException.class)
    public void test_failure_when_publish() {
        ListenableFuture<SendResult<String, ObjectNode>> responseFuture = mock(ListenableFuture.class);
        ObjectNode objectNode = objectMapper.createObjectNode();
        Throwable throwable = mock(Throwable.class);
        Mockito.when(kafkaTemplate.send("test-topic", objectNode)).thenReturn(responseFuture);
        doAnswer(invocationOnMock -> {
            ListenableFutureCallback listenableFutureCallback = invocationOnMock.getArgument(0);
            listenableFutureCallback.onFailure(throwable);
            return null;
        }).when(responseFuture).addCallback(ArgumentMatchers.any(ListenableFutureCallback.class));
        kafkaPublisher.publish(objectNode);
        Mockito.verify(kafkaTemplate, Mockito.times(1)).send("test-topic", objectNode);
    }


}
