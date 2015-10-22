package com.sgworks.mobile.exceptions;

import java.util.Arrays;
import java.util.stream.Collectors;

public class EntityAlreadyExistsException extends RuntimeException {

    public EntityAlreadyExistsException(Class<?> entityClass, Long id) {
        super(entityClass.getSimpleName() + " with ID: " + id + " not found!");
    }

    public EntityAlreadyExistsException(Class<?> entityClass, Object[] params) {
        super("Entity of type: " + entityClass.getSimpleName() + " with : " + Arrays.stream(params).map(Object::toString).collect(Collectors.joining()) + " already exists!");
    }
}
