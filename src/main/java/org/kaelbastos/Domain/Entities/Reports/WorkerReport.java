package org.kaelbastos.Domain.Entities.Reports;

import org.kaelbastos.Domain.Entities.Service.Service;
import org.kaelbastos.Domain.Entities.Worker.Worker;

import java.util.ArrayList;

public class WorkerReport {
    private Worker worker;
    private ArrayList<Service> payedServices;
    private ArrayList<Service> openServices;

    public WorkerReport(Worker worker) {
        this.worker = worker;
    }

    public Worker getWorker() {
        return worker;
    }

    public void setWorker(Worker worker) {
        this.worker = worker;
    }

    public ArrayList<Service> getPayedServices() {
        return payedServices;
    }

    public void addPayedService(Service payedService) {
        this.payedServices.add(payedService);
    }

    public ArrayList<Service> getOpenServices() {
        return openServices;
    }

    public void addOpenService(Service openService) {
        this.openServices.add(openService);
    }
}
