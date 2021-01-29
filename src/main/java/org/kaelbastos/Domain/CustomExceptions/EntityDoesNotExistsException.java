package org.kaelbastos.Domain.CustomExceptions;

public class EntityDoesNotExistsException extends RuntimeException{
    public EntityDoesNotExistsException(String entityName) {
        super(entityName + " Does Not Exists");
    }
}
