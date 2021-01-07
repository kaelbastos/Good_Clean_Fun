package org.kaelbastos.Domain.entities.Worker;

import org.kaelbastos.Domain.entities.Client.ResidenceType;
import org.kaelbastos.Domain.entities.utils.Notification;
import org.kaelbastos.Domain.entities.utils.PersonValidator;
import org.kaelbastos.Domain.entities.utils.Validator;

public class WorkerValidator extends Validator<Worker> {
    @Override
    public Notification validate(Worker worker) {
        Notification notification = new Notification();

        if(worker != null){
            PersonValidator superValidator = new PersonValidator();
            Notification superValidatorNotification = superValidator.validate(worker);
            if(superValidatorNotification.hasErrors())
                notification.addError(superValidatorNotification.getMessage());

            String workerSecondaryPhone = worker.getSecondaryPhone();
            if(isNullOrEmpty(workerSecondaryPhone))
                notification.addError("Secondary telephone is null or empty.");

        } else {
            notification.addError("Worker is null.");
        }
        return null;
    }
}
