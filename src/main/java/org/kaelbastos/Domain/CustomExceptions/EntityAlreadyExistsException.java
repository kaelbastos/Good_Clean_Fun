package org.kaelbastos.Domain.CustomExceptions;

public class EntityAlreadyExistsException extends RuntimeException {
    public EntityAlreadyExistsException(String entityName) {
        super(entityName + " Already Exists");
    }
}
