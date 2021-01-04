package org.kaelbastos.Domain.entities.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Notification {
    private List<Error> errors = new ArrayList<>();

    public void addError(String message){
        addError(message, null);
    }

    public void addError(String message, Exception exception){
        errors.add(new Error(message, exception));
    }

    public String getMessage(){
        return errors.stream()
                .map(error -> error.message)
                .collect(Collectors.joining(";"));
    }

    public boolean isCorrect(){
        return errors.isEmpty();
    }

    public boolean hasErrors(){
        return errors.size() > 0;
    }

    private class Error{
        public String message;
        public Exception cause;

        public Error(String message, Exception cause) {
            this.message = message;
            this.cause = cause;
        }
    }
}
