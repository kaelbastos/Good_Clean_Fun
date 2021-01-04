package org.kaelbastos.Domain.entities.Client;

import org.kaelbastos.Domain.entities.utils.Notification;
import org.kaelbastos.Domain.entities.utils.PersonValidator;
import org.kaelbastos.Domain.entities.utils.Validator;

public class ClientValidator extends Validator<Client> {
    @Override
    public Notification validate(Client client) {
        Notification notification = new Notification();

        if(client != null){
            PersonValidator superValidator = new PersonValidator();
            Notification superValidatorNotification = superValidator.validate(client);
            if(superValidatorNotification.hasErrors())
                notification.addError(superValidatorNotification.getMessage());

            ResidenceType clientResidenceType = client.getResidenceType();
            if(isNull(clientResidenceType))
                notification.addError("Residence Type is null.");
        } else {
            notification.addError("Client is null.");
        }

        return notification;
    }
}
