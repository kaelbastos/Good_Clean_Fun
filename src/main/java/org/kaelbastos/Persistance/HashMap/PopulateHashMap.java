package org.kaelbastos.Persistance.HashMap;

import org.kaelbastos.Domain.Entities.Client.Client;
import org.kaelbastos.Domain.Entities.Client.ResidenceType;
import org.kaelbastos.Domain.Entities.Worker.Worker;
import org.kaelbastos.Domain.Entities.utils.Address;
import org.kaelbastos.Domain.UseCases.ClientUseCases.InsertClient;
import org.kaelbastos.Domain.UseCases.WorkerUseCases.InsertWorker;

public class PopulateHashMap {
    public void populate(){
        InsertClient insertClient = new InsertClient();
        Client client = new Client("00000000000", "name", "00000000000", "test@test.com", new Address("street", "neighborhood", "city", "State", "00", "0", null), ResidenceType.House);
        Client client1 = new Client("00000000001", "name1", "00000000000", "test@test.com", new Address("street", "neighborhood", "city", "State", "00", "0", null), ResidenceType.House);
        Client client2 = new Client("00000000002", "name2", "00000000000", "test@test.com", new Address("street", "neighborhood", "city", "State", "00", "0", null), ResidenceType.House);
        try {
            insertClient.insert(client);
            insertClient.insert(client1);
            insertClient.insert(client2);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }

        InsertWorker insertWorker = new InsertWorker();
        Worker worker = new Worker("00000000000", "name", "00000000000", "00000000000", "test@test.com", new Address("street", "neighborhood", "city", "State", "00", "0", null));
        Worker worker1 = new Worker("00000000010", "name", "00000000000", "00000000000", "test@test.com", new Address("street", "neighborhood", "city", "State", "00", "0", null));
        Worker worker2 = new Worker("00000000020", "name", "00000000000", "00000000000", "test@test.com", new Address("street", "neighborhood", "city", "State", "00", "0", null));

        try {
            insertWorker.insert(worker);
            insertWorker.insert(worker1);
            insertWorker.insert(worker2);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }


    }
}
