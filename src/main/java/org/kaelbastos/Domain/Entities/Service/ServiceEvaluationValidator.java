package org.kaelbastos.Domain.Entities.Service;

import org.kaelbastos.Domain.Entities.utils.Notification;
import org.kaelbastos.Domain.Entities.utils.Person;
import org.kaelbastos.Domain.Entities.utils.PersonValidator;
import org.kaelbastos.Domain.Entities.utils.Validator;

public class ServiceEvaluationValidator extends Validator<ServiceEvaluation> {
    @Override
    public Notification validate(ServiceEvaluation serviceEvaluation) {
        Notification notification = new Notification();

        if(isNotNull(serviceEvaluation)){
            int serviceRating = serviceEvaluation.getRating();
            if(serviceRating < 0 || serviceRating > 10)
                notification.addError("Rating is invalid.");

            Person author = serviceEvaluation.getAuthor();
            Notification authorValidatorNotification = new PersonValidator().validate(author);
            if(authorValidatorNotification.hasErrors())
                notification.addError(authorValidatorNotification.getMessage());
        } else {
            notification.addError("Service Evaluation is null.");
        }

        return notification;
    }
}
