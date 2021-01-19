/*
package com.prokarma.poc.publisher;

import com.prokarma.poc.publisher.model.CustomerDetails;
import com.prokarma.poc.publisher.util.TestUtil;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = PublisherApplication.class,
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PublisherControllerIntegrationTest {

    @LocalServerPort
    private int port;

    TestRestTemplate restTemplate = new TestRestTemplate();

    @Test
    void contextLoads() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Authorization", "68d002f3-4370-40f7-a92d-dead52d96cb8");
        httpHeaders.add("Activity-Id", "12345");
        httpHeaders.add("Application-Id", "12345");

        HttpEntity<String> entity = new HttpEntity<String>(null, httpHeaders);

        restTemplate.exchange(
                createURLWithPort("/publisher/v1/customerDetails"),
                HttpMethod.POST, entity, String.class);
    }

    private String createURLWithPort(String uri) {
        return "http://localhost:" + port + uri;
    }
}
*/
