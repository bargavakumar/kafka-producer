package com.prokarma.poc.publisher.exceptions;

import com.prokarma.poc.publisher.constants.PublisherConstant;
import com.prokarma.poc.publisher.model.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class PublisherControllerAdvice {

    @ExceptionHandler(PublisherException.class)
    public final ResponseEntity<ErrorResponse> handleException(PublisherException publisherException) {
        ErrorResponse errorResponse = new ErrorResponse(PublisherConstant.Error, publisherException.getMessage(), PublisherException.class.getSimpleName());
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public final ResponseEntity<ErrorResponse> handleException(MethodArgumentNotValidException exception) {
        ErrorResponse errorResponse = new ErrorResponse(PublisherConstant.Error, exception.getMessage(), MethodArgumentNotValidException.class.getSimpleName());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    public final ResponseEntity<ErrorResponse> handleException(NoHandlerFoundException noHandlerFoundException) {
        ErrorResponse errorResponse = new ErrorResponse(PublisherConstant.Error, noHandlerFoundException.getMessage(), NoHandlerFoundException.class.getSimpleName());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public final ResponseEntity<ErrorResponse> handleException(IllegalArgumentException illegalArgumentException) {
        ErrorResponse errorResponse = new ErrorResponse(PublisherConstant.Error, illegalArgumentException.getMessage(), NoHandlerFoundException.class.getSimpleName());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }


}
