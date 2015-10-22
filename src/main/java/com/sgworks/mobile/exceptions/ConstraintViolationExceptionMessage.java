package com.sgworks.mobile.exceptions;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;

public class ConstraintViolationExceptionMessage {

    private final List<ValidationError> errors = new ArrayList<>();

    public ConstraintViolationExceptionMessage(MethodArgumentNotValidException violationException, MessageSourceAccessor accessor) {
        this(violationException.getBindingResult(), accessor);
    }

    public ConstraintViolationExceptionMessage(BindException bindException, MessageSourceAccessor accessor) {
        this(bindException.getBindingResult(), accessor);
    }

    public ConstraintViolationExceptionMessage(BindingResult bindingResult, MessageSourceAccessor accessor) {
        for (FieldError fieldError : bindingResult.getFieldErrors()) {
            List<Object> args = new ArrayList<>();
            args.add(fieldError.getObjectName());
            args.add(fieldError.getField());
            args.add(fieldError.getRejectedValue());
            if (null != fieldError.getArguments()) {
                Collections.addAll(args, fieldError.getArguments());
            }

            String message = accessor.getMessage(fieldError.getCode(), args.toArray(), fieldError.getDefaultMessage());
            this.errors.add(new ValidationError(fieldError.getObjectName(), message,
                    String.format("%s", fieldError.getRejectedValue()), fieldError.getField()));
        }

        for (ObjectError objectError : bindingResult.getGlobalErrors()) {
            String message = accessor.getMessage(objectError.getCode(), objectError.getArguments(), objectError.getDefaultMessage());
            this.errors.add(new ValidationError(objectError.getObjectName(), message, StringUtils.EMPTY, StringUtils.EMPTY));
        }
    }

    @JsonProperty("errors")
    public List<ValidationError> getErrors() {
        return errors;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("errors", errors)
                .toString();
    }

    public static class ValidationError {

        private final String entity;
        private final String message;
        private final String invalidValue;
        private final String property;

        public ValidationError(String entity, String message, String invalidValue, String property) {
            this.entity = entity;
            this.message = message;
            this.invalidValue = invalidValue;
            this.property = property;
        }

        public String getEntity() {
            return entity;
        }

        public String getMessage() {
            return message;
        }

        public String getInvalidValue() {
            return invalidValue;
        }

        public String getProperty() {
            return property;
        }

        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add("entity", entity)
                    .add("message", message)
                    .add("invalidValue", invalidValue)
                    .add("property", property)
                    .toString();
        }
    }

}
