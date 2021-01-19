package com.prokarma.poc.publisher.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.prokarma.poc.publisher.constants.PublisherConstant;
import com.prokarma.poc.publisher.model.CustomerDetails;

public class PublisherUtil {
    private static ObjectMapper objectMapper = new ObjectMapper();

    private PublisherUtil() {

    }

    public static ObjectNode customerDetailsMasker(CustomerDetails customerDetails) {
        ObjectNode objectNode = objectMapper.convertValue(customerDetails, ObjectNode.class);
        objectNode.put(PublisherConstant.CUSTOMER_DETAILS_EMAIL, objectNode.get(PublisherConstant.CUSTOMER_DETAILS_EMAIL).textValue().replaceAll("(\\w{4})(\\w+)(@.*)", "****$2$3"));
        objectNode.put(PublisherConstant.CUSTOMER_DETAILS_BIRTH_DATE, objectNode.get(PublisherConstant.CUSTOMER_DETAILS_BIRTH_DATE).textValue().replaceAll("^[0-3][0-9]-[0-3][0-9]", "**-**"));
        String customerNumber = objectNode.get(PublisherConstant.CUSTOMER_DETAILS_CUSTOMER_NUMBER).textValue();
        String last4chars = customerNumber.substring((customerNumber.length() - PublisherConstant.MASK_CUSTOMER_NUMBER_LAST_DIGITS)).replaceAll("\\w", "*");
        String first6chars = customerNumber.substring(0, (customerNumber.length() - PublisherConstant.MASK_CUSTOMER_NUMBER_LAST_DIGITS));
        objectNode.put(PublisherConstant.CUSTOMER_DETAILS_CUSTOMER_NUMBER, first6chars.concat(last4chars));
        return objectNode;
    }
}
