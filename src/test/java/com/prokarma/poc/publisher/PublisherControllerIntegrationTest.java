package com.prokarma.poc.publisher;

import com.prokarma.poc.publisher.model.CustomerDetails;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.kafka.test.context.EmbeddedKafka;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.PostConstruct;

import static io.restassured.RestAssured.given;

@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
@TestPropertySource(
        locations = "classpath:application.properties")
@EmbeddedKafka(partitions = 1, brokerProperties = {"listeners=PLAINTEXT://localhost:9092", "port=9092"})
class PublisherControllerIntegrationTest {

    private static final String AUTH_TOKEN_URI = "/oauth/token";
    private static final String RESOURCE_URL = "/publisher/v1/customerDetails";
    @LocalServerPort
    private int port;
    private String uri;

    @PostConstruct
    public void init() {
        uri = "http://localhost:" + port;
    }

    @Test
    public void givenMovie_whenMakingPostRequestToMovieEndpoint_thenCorrect() {

        CustomerDetails customerDetails = Utility.createCustomerDetails();


        String accessToken =
                given()
                        .auth().preemptive().basic("acme", "acmesecret")
                        .contentType("application/x-www-form-urlencoded")
                        .formParam("grant_type", "client_credentials")
                        .formParam("scope", "all")
                        .when()
                        .post(uri + AUTH_TOKEN_URI)
                        .then()
                        .assertThat()
                        .statusCode(HttpStatus.OK.value())
                        .extract()
                        .path("access_token");
        given().auth()
                .oauth2(accessToken)
                .header("Activity-Id", "12355")
                .header("Application-Id", "12355-455")
                .contentType(ContentType.JSON)
                .body(customerDetails)
                .post(uri + RESOURCE_URL)
                .then()
                .assertThat()
                .statusCode(HttpStatus.OK.value());

    }


}
