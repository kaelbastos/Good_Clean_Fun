package org.kaelbastos.view.CLI;

import org.kaelbastos.Domain.Entities.Client.Client;
import org.kaelbastos.Domain.Entities.Client.ResidenceType;
import org.kaelbastos.Domain.Entities.utils.Address;
import org.kaelbastos.Domain.UseCases.ClientUseCases.AlterClient;
import org.kaelbastos.Domain.UseCases.ClientUseCases.InsertClient;
import org.kaelbastos.Persistance.PersistenceFacade;

public class ClientCLI {
    public static void run() {
        System.out.println("Client\n\n");

        PersistenceFacade persistenceFacade = PersistenceFacade.getInstance();

        System.out.println("\nInsert Client");
        Client client = new Client("72952145333", "Ana Julia", "35789988889", "email@email.com", new Address("Bomfim Paulista", "Centro", "Ribeirão Preto", "SP", "100", "14110222",""), ResidenceType.House);
        System.out.println(client.toString());
        insertClient(client);

        System.out.println("\nAlter Client");
        Client client1 = new Client("72952145333", "Ana Julia", "35789988889", "email@email.com", new Address("Bomfim Paulista", "Centro", "Ribeirão Preto", "SP", "100", "14110222","Casa"), ResidenceType.House);
        System.out.println(client1.toString());
        alterClient(client1);

    }

    public static void insertClient(Client client){
        InsertClient insertClient = new InsertClient();
        try {
            System.out.println(insertClient.insert(client));
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static void alterClient(Client client){
        AlterClient alterClient = new AlterClient();
        try {
            System.out.println(alterClient.alter(client));
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
} 