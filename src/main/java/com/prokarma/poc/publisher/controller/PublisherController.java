package com.prokarma.poc.publisher.controller;

import com.prokarma.poc.publisher.model.CustomerDetails;
import com.prokarma.poc.publisher.model.CustomerDetailsResponse;
import com.prokarma.poc.publisher.services.PublisherService;
import com.prokarma.poc.publisher.util.PublisherUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/publisher/v1")
public class PublisherController {

    private static final Logger logger = LoggerFactory.getLogger(PublisherController.class);

    private PublisherService producerService;

    @Autowired
    PublisherController(PublisherService producerService) {
        this.producerService = producerService;
    }

    @PostMapping(path = "/customerDetails", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<CustomerDetailsResponse> customerDetails(@RequestHeader(value = "Authorization", required = true) String authorization,
                                                            @RequestHeader(value = "Activity-Id", required = true) String activityId,
                                                            @RequestHeader(value = "Application-Id", required = true) String applicationId,
                                                            @Valid @RequestBody CustomerDetails customerDetails) {
        long startTime = System.currentTimeMillis();
        logger.info("applicationName=Publisher|Incoming customer details request={}", PublisherUtil.customerDetailsMasker(customerDetails));
        CustomerDetailsResponse customerDetailsResponse = producerService.postMessage(customerDetails);
        ResponseEntity<CustomerDetailsResponse> responseEntity = new ResponseEntity<>(customerDetailsResponse, HttpStatus.OK);
        logger.info("applicationName=Publisher|customerDetails service response=" + responseEntity + "|timetook=" + (System.currentTimeMillis() - startTime));
        return responseEntity;


    }
}
