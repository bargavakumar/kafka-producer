package com.prokarma.poc.publisher.util;

import com.prokarma.poc.publisher.model.Address;
import com.prokarma.poc.publisher.model.CustomerDetails;
import org.apache.tomcat.jni.Local;

import java.time.LocalDate;

public class TestUtil {

    public static CustomerDetails createCustomerDetails() {
        CustomerDetails customerDetails = new CustomerDetails();
        customerDetails.setCustomerNumber("C000000002");
        customerDetails.setFirstName("bargavakumar");
        customerDetails.setLastName("akavarammm");
        LocalDate localDate = LocalDate.of(1991, 9, 25);
        customerDetails.setBirthDate(localDate);
        customerDetails.setCountry("INDIA");
        customerDetails.setCountryCode("IN");
        customerDetails.setMobileNumber("9989922802");
        customerDetails.setEmail("adotbhargav@gmail.com");
        customerDetails.setCustomerStatus(CustomerDetails.CustomerStatusEnum.OPEN);
        Address address = new Address();
        address.setAddressLine1("Plot no 28");
        address.setAddressLine2("Lalitha nagar");
        address.setStreet("Sai nagar");
        address.setPostalCode("50068");
        customerDetails.setAddress(address);
        return customerDetails;
    }
}
