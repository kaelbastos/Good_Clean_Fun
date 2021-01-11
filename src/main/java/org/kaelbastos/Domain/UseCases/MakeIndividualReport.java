package org.kaelbastos.Domain.UseCases;

import org.kaelbastos.Domain.Entities.Client.Client;
import org.kaelbastos.Domain.Entities.Service.Service;
import org.kaelbastos.Persistance.PersistenceFacade;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class MakeIndividualReport {
    public boolean execute() {
        Optional<List<Client>> allClients = PersistenceFacade.getInstance().getAllClient();
        if (allClients.isEmpty())
            throw new RuntimeException("No Clients saved.");
        else
            allClients.get().stream().map(this::assembleReport).forEach(System.out::print);
        return true;
    }

    private String assembleReport(Client client) {
        Optional<List<Service>> allServices = PersistenceFacade.getInstance().getAllServices();
        String payed = "";
        String notPayed = "";
        allServices.ifPresent(services -> services.stream()
                .filter(service -> {
                    String serviceClientCPF = service.getClient().getCpf();
                    return serviceClientCPF.equals(client.getCpf());
                }).forEach(service -> {
                    String report = "Id : " +
                            service.getId() +
                            "\nStatus: " +
                            service.getStatus().value +
                            "\nPrice: " +
                            service.getTotalPrice();
                    if (service.isPayed()) {
                        payed.concat(report);
                    } else {
                        notPayed.concat(report);
                    }
                }));
        return "\n\n\nClient: " + client.getName() +"\n\nPayed {\n" + payed + "}\n\nNot Payed {" + notPayed + "}\n";
    }
}
