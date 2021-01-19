package com.prokarma.poc.publisher.controller;

import com.prokarma.poc.publisher.model.CustomerDetailsResponse;
import com.prokarma.poc.publisher.services.PublisherService;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(value = PublisherController.class)
public class PublisherControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PublisherService producerService;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Before()
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void testCustomerDetails() throws Exception {
        CustomerDetailsResponse customerDetailsResponse = new CustomerDetailsResponse("Success", "Message sent to kafka successfully");
        Mockito.when(producerService.postMessage(ArgumentMatchers.any())).thenReturn(customerDetailsResponse);
        String json = "{\"customerNumber\":\"C000000002\",\"firstName\":\"bargavakumar\",\"lastName\":\"akavarammm\",\"birthDate\":\"18-05-1991\",\"country\":\"INDIA\",\"countryCode\":\"IN\",\"mobileNumber\":\"9989922802\",\"email\":\"adotbhargav@gmail.com\",\"customerStatus\":\"OPEN\",\"address\":{\"addressLine1\":\"Plot no 28\",\"addressLine2\":\"Lalitha nagar\",\"street\":\"Sai nagar\",\"postalCode\":\"50068\"}}";
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Authorization", "68d002f3-4370-40f7-a92d-dead52d96cb8");
        httpHeaders.add("Activity-Id", "12345");
        httpHeaders.add("Application-Id", "12345");
        mockMvc.perform(post("/publisher/v1/customerDetails")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("utf-8")
                .headers(httpHeaders)
                .content(json)
                .accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk()).andExpect(jsonPath("$.status", Matchers.equalTo("Success")));
    }

}
