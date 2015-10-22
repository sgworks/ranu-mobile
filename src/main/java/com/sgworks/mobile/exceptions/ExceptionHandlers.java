package com.sgworks.mobile.exceptions;

import org.hibernate.exception.ConstraintViolationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.CONFLICT;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@ControllerAdvice
public class ExceptionHandlers {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private MessageSourceAccessor messageSourceAccessor;

    @ResponseBody
    @ResponseStatus(NOT_FOUND)
    @ExceptionHandler(EntityNotFoundException.class)
    public String handleEntityNotFoundException(EntityNotFoundException ex) {
        logger.info("Could not find entity: ", ex);
        return ex.getMessage();
    }

    @ResponseBody
    @ResponseStatus(CONFLICT)
    @ExceptionHandler(ConstraintViolationException.class)
    public String handleConstraintViolationException(ConstraintViolationException ex) {
        return ex.getMessage();
    }

    @ResponseBody
    @ResponseStatus(CONFLICT)
    @ExceptionHandler(JpaSystemException.class)
    public String handleJpaSystemException(JpaSystemException ex) {
        logger.warn("Database constraint violated: ", ex);
        return ex.getMostSpecificCause().getMessage();
    }

    @ResponseBody
    @ResponseStatus(BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ConstraintViolationExceptionMessage handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        logger.info("MethodArgumentNotValidException: ", ex);
        return new ConstraintViolationExceptionMessage(ex, messageSourceAccessor);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handle(HttpMessageNotReadableException ex) {
        logger.info("Returning HTTP 400 Bad Request", ex);
        return ex.getMostSpecificCause().getMessage();
    }

    @ResponseBody
    @ResponseStatus(BAD_REQUEST)
    @ExceptionHandler(BindException.class)
    public ConstraintViolationExceptionMessage handleBindException(BindException ex) {
        logger.info("BindException: ", ex);
        return new ConstraintViolationExceptionMessage(ex, messageSourceAccessor);
    }

    @ResponseBody
    @ResponseStatus(BAD_REQUEST)
    @ExceptionHandler(javax.validation.ConstraintViolationException.class)
    public String handleBeanValidationConstraintViolationException(javax.validation.ConstraintViolationException ex) {
        logger.info("ConstraintViolationException: ", ex);
        return ex.getMessage();
    }

    /*@ResponseBody
    @ResponseStatus(BAD_REQUEST)
    @ExceptionHandler(BusinessRuleViolationException.class)
    public String handleBusinessRuleViolationException(BusinessRuleViolationException ex) {
        logger.info("BusinessRuleViolationException: ", ex);
        return ex.getMessage();
    }*/
}
