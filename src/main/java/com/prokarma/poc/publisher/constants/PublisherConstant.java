package com.prokarma.poc.publisher.constants;

public class PublisherConstant {

    public static final String MASK_CUSTOMER_NUMBER = "customerNumber";
    public static final String MASK_EMAIL = "email";
    public static final String MASK_BIRTHDATE = "birthDate";
    public static final int MASK_EMAIL_DIGITS = 4;
    public static final int MASK_CUSTOMER_NUMBER_LAST_DIGITS = 4;
    public static final int MASK_EMAIL_DIGITS_LAST_DIGITS = 4;
    public static final String SUCCESS = "Success";
    public static final String Error = "Error";
    public static final String PUBLISH_SUCCESSFUL = "Message sent to Kafka successfully";
    public static final String CUSTOMER_DETAILS_CUSTOMER_STATUS = "customerStatus";
    public static final String CUSTOMER_DETAILS_BIRTH_DATE = "birthDate";
    public static final String CUSTOMER_DETAILS_CUSTOMER_NUMBER = "customerNumber";
    public static final String CUSTOMER_DETAILS_EMAIL = "email";

    private PublisherConstant() {

    }
}
