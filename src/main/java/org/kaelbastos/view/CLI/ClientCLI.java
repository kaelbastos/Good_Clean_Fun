package org.kaelbastos.view.CLI;

import org.kaelbastos.Domain.Entities.Client.Client;
import org.kaelbastos.Domain.Entities.Client.ResidenceType;
import org.kaelbastos.Domain.Entities.utils.Address;
import org.kaelbastos.Domain.UseCases.AlterClient;
import org.kaelbastos.Domain.UseCases.InsertClient;
import org.kaelbastos.Persistance.PersistenceFacade;

public class ClientCLI {
    public static void run() {
        System.out.println("Client\n\n");

        PersistenceFacade persistenceFacade = PersistenceFacade.getInstance();

        System.out.println("\nInsert Client");
        Client client = new Client("72952145333", "Ana Julia", "35789988889", "36365512340", new Address("Bomfim Paulista", "Centro", "Ribeirão Preto", "SP", "100", "14110222","Casa"), ResidenceType.House);
        ClientCLI.insertClient(client);
        System.out.println(persistenceFacade.getOneClient("72952145333").toString());

        System.out.println("\nAlter Client");
        Client client1 = new Client("72952145333", "Ana Julia", "35789988889", "36365512340", new Address("Bomfim Paulista", "Centro", "Ribeirão Preto", "SP", "100", "14110222","Casa"), ResidenceType.House);
        System.out.println(persistenceFacade.getOneClient("72952145333").toString());

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