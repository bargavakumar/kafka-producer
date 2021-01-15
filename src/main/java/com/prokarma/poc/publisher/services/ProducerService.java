package com.prokarma.poc.publisher.services;

import com.prokarma.poc.publisher.model.CustomerDetails;
import com.prokarma.poc.publisher.model.CustomerDetailsResponse;

public interface ProducerService {

    CustomerDetailsResponse postMessage(CustomerDetails customerDetails);
}
