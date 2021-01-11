package org.kaelbastos.view.CLI;

import org.kaelbastos.Domain.Entities.Worker.Worker;
import org.kaelbastos.Domain.Entities.utils.Address;
import org.kaelbastos.Domain.UseCases.AlterWorker;
import org.kaelbastos.Domain.UseCases.DeactivateWorker;
import org.kaelbastos.Domain.UseCases.InsertWorker;
import org.kaelbastos.Persistance.PersistenceFacade;

public class WorkerCLI {

    public static void run(){
        System.out.println("Worker");

        PersistenceFacade persistenceFacade = PersistenceFacade.getInstance();

        System.out.println("\nInsert Worker");
        Worker worker = new Worker("72952145008", "Mariah Simone", "35789988889", "36365512340", "maria.simone@gmail.com", new Address("Travessa Barão de Itararé", "Santo André", "São Leopoldo", "RS", "484", "93044045",""));
        WorkerCLI.insertWorker(worker);
        System.out.println(worker);

        System.out.println("\nAlter Worker");
        Worker workerAlter =new Worker("72952145008", "Mariah Simone", "35789988889", "36365512340", "maria.simone@gmail.com", new Address("Bomfim Paulista", "Centro", "Ribeirão Preto", "SP", "100", "14110222","Casa"));
        WorkerCLI.alterWorker(workerAlter);
        System.out.println(workerAlter);

        System.out.println("\nDeactivate Worker");
        WorkerCLI.deactivateWorker("72952145008");
        System.out.println(worker);
    }

    public static void insertWorker(Worker worker){
        InsertWorker insertWorker = new InsertWorker();
        try {
            System.out.println(insertWorker.insert(worker));
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static void alterWorker(Worker worker){
        AlterWorker alterWorker = new AlterWorker();
        try {
            System.out.println(alterWorker.alter(worker));
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static void deactivateWorker(String workerId){
        DeactivateWorker deactivateWorker = new DeactivateWorker();
        try {
            System.out.println(deactivateWorker.deactivate(workerId));
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

}
