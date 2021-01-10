package org.kaelbastos.Domain.useCases;

import org.kaelbastos.Domain.entities.Client.Client;
import org.kaelbastos.Domain.entities.Client.ClientValidator;
import org.kaelbastos.Domain.entities.utils.Notification;
import org.kaelbastos.persistance.PersistenceFacade;

public class CreateClient {
    public boolean insert(Client client){
        ClientValidator clientValidator = new ClientValidator();
        Notification notification = clientValidator.validate(client);

        PersistenceFacade persistenceFacade = PersistenceFacade.getInstance();
        if(notification.hasErrors())
            throw new IllegalArgumentException(notification.getMessage());
        else if(persistenceFacade.getOneClient(client.getCpf()).isPresent() ||
                persistenceFacade.getOneWorker(client.getCpf()).isPresent())
            throw new IllegalArgumentException("CPF already exists");

        return persistenceFacade.saveClient(client);
    }
}
