package org.kaelbastos.view.CLI;

import org.kaelbastos.Domain.Entities.Client.Client;
import org.kaelbastos.Domain.Entities.Client.ResidenceType;
import org.kaelbastos.Domain.Entities.Product.Product;
import org.kaelbastos.Domain.Entities.Product.ProductCategory;
import org.kaelbastos.Domain.Entities.Service.Service;
import org.kaelbastos.Domain.Entities.Service.ServiceCategory;
import org.kaelbastos.Domain.Entities.Service.ServiceStatus;
import org.kaelbastos.Domain.Entities.Worker.Worker;
import org.kaelbastos.Domain.Entities.utils.Address;
import org.kaelbastos.Domain.UseCases.ServiceUseCases.CancelScheduledService;
import org.kaelbastos.Domain.UseCases.ServiceUseCases.FinishService;
import org.kaelbastos.Domain.UseCases.ServiceUseCases.ScheduleService;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ServiceCLI {
    public static void run(){
        int id = 0;
        LocalDateTime start = LocalDateTime.of(2021, 1, 6, 22 , 14);
        float servicePrice = 100F;
        int workerPercentage = 50;
        ServiceStatus status = ServiceStatus.Scheduled;
        ServiceCategory category = new ServiceCategory(0, "name", 1.5);
        Client client = new Client("00000000000", "Name", "00000000000", "client@client.com", new Address("rua dos bobos", "neighborhood", "city", "state", "0", "2", null), ResidenceType.House);
        Product product = new Product(1, "broom", 10F,ProductCategory.Utensil);
        ArrayList<Product> products = new ArrayList<>(List.of(product));
        Worker worker = new Worker("00000000000", "Name", "00000000000", "11111111111","client@client.com", null);
        ArrayList<Worker> workers = new ArrayList<>(List.of(worker));

        Service service = new Service(id, start, servicePrice, workerPercentage, status , category, client, products, workers);


        System.out.println("\nSchedule Service\n");

        scheduleService(service);
        System.out.println(service.toString());


        System.out.println("\nCancel Service\n");

        cancelSchedule(service.getId());
        System.out.println(service.toString());


        System.out.println("\nFinish Service\n");

        finishService(service.getId());
        System.out.println(service.toString() + "\n\n");

    }

    public static void scheduleService(Service service) {
        ScheduleService scheduleService = new ScheduleService();
        try{
            System.out.println(scheduleService.schedule(service));
        } catch(Exception e){
            System.out.println(e.getMessage());
        }

    }

    public static void cancelSchedule(int serviceId){
        CancelScheduledService cancelScheduledService = new CancelScheduledService();
        try{
            System.out.println(cancelScheduledService.cancel(serviceId));
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static void finishService(int serviceId){
        FinishService finishService = new FinishService();
        try{
            System.out.println(finishService.finish(serviceId));
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
    }



}
