package org.kaelbastos.Domain.UseCases;

import org.kaelbastos.Domain.Entities.Client.Client;
import org.kaelbastos.Domain.Entities.Client.ClientValidator;
import org.kaelbastos.Domain.Entities.utils.Notification;
import org.kaelbastos.Persistance.PersistenceFacade;

public class InsertClient {
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