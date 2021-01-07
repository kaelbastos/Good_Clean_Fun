package org.kaelbastos.Domain.entities.utils;

public class ObservationValidator extends Validator<Observation>{
    @Override
    public Notification validate(Observation observation) {
        Notification notification = new Notification();

        if(isNotNull(observation)){
            ObservationType observationType = observation.getObservationType();
            if(isNull(observationType))
                notification.addError("Observation Type is null.");

            String observationComment = observation.getComment();
            if(isNullOrEmpty(observationComment))
                notification.addError("Comment is null or empty.");

            Person author = observation.getAuthor();
            Notification authorValidatorNotification = new PersonValidator().validate(author);
            if(authorValidatorNotification.hasErrors())
                notification.addError(authorValidatorNotification.getMessage());

        } else {
            notification.addError("Observation is null.");
        }

        return notification;
    }
}
