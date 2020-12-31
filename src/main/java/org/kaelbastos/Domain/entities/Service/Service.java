package org.kaelbastos.Domain.entities.Service;

import java.time.LocalDate;

public class Service{
    private int id;
    private LocalDate date;
    private float totalValue;
    private int workerPercentage;
    private ServiceStatus status;

    public Service(int id, LocalDate date, float totalValue, int workerPercentage, ServiceStatus status) {
        this.id = id;
        this.date = date;
        this.totalValue = totalValue;
        this.workerPercentage = workerPercentage;
        this.status = status;
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