package org.kaelbastos.Domain.UseCases.ClientUseCases;

import org.kaelbastos.Domain.CustomExceptions.EntityAlreadyExistsException;
import org.kaelbastos.Domain.Entities.Client.Client;
import org.kaelbastos.Domain.Entities.Client.ClientValidator;
import org.kaelbastos.Domain.Entities.utils.Notification;
import org.kaelbastos.Persistance.PersistenceFacade;

public class InsertClient {
    public boolean insert(Client client) throws Exception{
        ClientValidator clientValidator = new ClientValidator();
        Notification notification = clientValidator.validate(client);

        PersistenceFacade persistenceFacade = PersistenceFacade.getInstance();
        if(notification.hasErrors())
            throw new IllegalArgumentException(notification.getMessage());
        else if(persistenceFacade.getOneClient(client.getCpf()).isPresent() ||
                persistenceFacade.getOneWorker(client.getCpf()).isPresent())
            throw new EntityAlreadyExistsException("Person");

        return persistenceFacade.saveClient(client);
    }
}