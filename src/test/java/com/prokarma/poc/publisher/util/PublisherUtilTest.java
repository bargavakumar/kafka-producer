package com.prokarma.poc.publisher.util;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.prokarma.poc.publisher.Utility;
import com.prokarma.poc.publisher.constants.PublisherConstant;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class PublisherUtilTest {

    @Test
    public void testCustomerDetailsMasker() {
        ObjectNode newNode = PublisherUtil.customerDetailsMasker(Utility.createCustomerDetails());
        Assert.assertNotNull(newNode);
        Assert.assertEquals("****bhargav@gmail.com", newNode.get(PublisherConstant.CUSTOMER_DETAILS_EMAIL).textValue());
        Assert.assertEquals("**-**-1991", newNode.get(PublisherConstant.CUSTOMER_DETAILS_BIRTH_DATE).textValue());
        Assert.assertEquals("C00000****", newNode.get(PublisherConstant.CUSTOMER_DETAILS_CUSTOMER_NUMBER).textValue());

    }
}
