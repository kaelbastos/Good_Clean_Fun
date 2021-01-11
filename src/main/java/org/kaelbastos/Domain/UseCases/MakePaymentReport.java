package org.kaelbastos.Domain.UseCases;

import org.kaelbastos.Domain.Entities.Client.Client;
import org.kaelbastos.Domain.Entities.Service.Service;
import org.kaelbastos.Persistance.PersistenceFacade;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class MakePaymentReport {
    public boolean execute(){
        Optional<List<Client>> allClients = PersistenceFacade.getInstance().getAllClient();
        if(allClients.isEmpty())
            throw new RuntimeException("No Clients saved.");
        else
            allClients.get().stream().map(this::assembleReport).forEach(System.out::print);
        return true;
    }

    private String assembleReport(Client client){
        Optional<List<Service>> allServices = PersistenceFacade.getInstance().getAllServices();
        String notPayed = "";
        allServices.ifPresent(services -> services.stream()
                .filter(service -> {
                    String serviceClientCPF = service.getClient().getCpf();
                    return serviceClientCPF.equals(client.getCpf());
                }).filter(Predicate.not(Service::isPayed))
                .forEach(service -> {
                    String report = "Id: " +
                            service.getId() +
                            "\nStatus: " +
                            service.getStatus().value +
                            "\nPrice: " +
                            service.getTotalPrice();
                            notPayed.concat(report);
                }));
        return "\n\n\nClient: " + client.getName() +"\n\nNot Payed {"+ notPayed + "}\n";
    }
}
