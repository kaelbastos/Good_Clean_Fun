package org.kaelbastos.Domain.useCases;

import org.kaelbastos.Domain.entities.Client.Client;
import org.kaelbastos.Domain.entities.Client.ClientValidator;
import org.kaelbastos.Domain.entities.utils.Notification;
import org.kaelbastos.Domain.entities.utils.Validator;
import org.kaelbastos.persistance.PersistenceFacade;
import org.kaelbastos.persistance.Utils.CLientDAO;

public class CreateClient {

    private CLientDAO clientDAO;

    public boolean insert(Client client){
        Validator<Client> validator = new ClientValidator();
        Notification notification = validator.validate(client);

        if(notification.hasErrors())
            throw new IllegalArgumentException(notification.getMessage());

        String cpf = client.getCpf();

        return true;
    }

}
