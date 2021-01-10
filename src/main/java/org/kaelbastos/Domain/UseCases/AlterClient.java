package org.kaelbastos.Domain.UseCases;

import org.kaelbastos.Domain.Entities.Client.Client;
import org.kaelbastos.Domain.Entities.Client.ClientValidator;
import org.kaelbastos.Domain.Entities.utils.Notification;
import org.kaelbastos.Persistance.PersistenceFacade;

public class AlterClient {
    public boolean alter(Client client){
        ClientValidator clientValidator = new ClientValidator();
        Notification notification = clientValidator.validate(client);

        PersistenceFacade persistenceFacade = PersistenceFacade.getInstance();
        if(notification.hasErrors())
            throw new IllegalArgumentException(notification.getMessage());
        else if(persistenceFacade.getOneClient(client.getCpf()).isPresent() ||
                persistenceFacade.getOneWorker(client.getCpf()).isPresent())
            throw new IllegalArgumentException("Client does not exists");

        return persistenceFacade.updateClient(client);
    }
}
