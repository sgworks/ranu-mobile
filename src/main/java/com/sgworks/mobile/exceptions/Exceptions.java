package com.sgworks.mobile.exceptions;


import com.sgworks.mobile.model.Customer;

public final class Exceptions {

    // Utility class
    private Exceptions() {
    }

    public static EntityNotFoundException entityNotFound(Class<?> entityClass, Long id) {
        return new com.sgworks.mobile.exceptions.EntityNotFoundException(entityClass, id);
    }

    public static EntityNotFoundException entityNotFound(Class<?> entityClass, Object... params) {
        return new com.sgworks.mobile.exceptions.EntityNotFoundException(entityClass, params);
    }

    public static EntityAlreadyExistsException alreadyExists(Class<Customer> customerClass, Long id) {
        return null;
    }

}
