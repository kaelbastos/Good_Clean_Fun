package org.kaelbastos.Domain.entities.Service;

import org.kaelbastos.Domain.entities.Client.Client;
import org.kaelbastos.Domain.entities.Worker.Worker;

import java.time.LocalDate;
import java.util.ArrayList;

public class Service{
    private int id;
    private LocalDate date;
    private float totalValue;
    private int workerPercentage;
    private ServiceStatus status;
    private final Client client;
    private final ArrayList<Worker> workers = new ArrayList<>();

    public Service(int id, LocalDate date, float totalValue, int workerPercentage, ServiceStatus status, Client client, Worker worker) {
        this.id = id;
        this.date = date;
        this.totalValue = totalValue;
        this.workerPercentage = workerPercentage;
        this.status = status;
        this.client = client;
        this.workers.add(worker);
    }

    public Service(int id, LocalDate date, float totalValue, int workerPercentage, ServiceStatus status, Client client, ArrayList<Worker> workers) {
        this.id = id;
        this.date = date;
        this.totalValue = totalValue;
        this.workerPercentage = workerPercentage;
        this.status = status;
        this.client = client;
        this.workers.addAll(workers);
    }

    public Client getClient() {
        return client;
    }

    public ArrayList<Worker> getWorkers() {
        return workers;
    }

    public void addWorker(Worker worker){
        workers.add(worker);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public float getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(float totalValue) {
        this.totalValue = totalValue;
    }

    public int getWorkerPercentage() {
        return workerPercentage;
    }

    public void setWorkerPercentage(int workerPercentage) {
        this.workerPercentage = workerPercentage;
    }

    public ServiceStatus getStatus() {
        return status;
    }

    public void setStatus(ServiceStatus status) {
        this.status = status;
    }
}