package org.kaelbastos.Domain.Entities.Service;

import org.kaelbastos.Domain.Entities.Client.Client;
import org.kaelbastos.Domain.Entities.Product.Product;
import org.kaelbastos.Domain.Entities.Worker.Worker;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Optional;

public class Service {
    private final int id;
    private LocalDateTime start;
    private LocalDateTime end;
    private float servicePrice;
    private int workerPercentage;
    private ServiceStatus status;
    private ServiceCategory category;
    private ServiceEvaluation serviceEvaluation;
    private final Client client;
    private final ArrayList<Worker> workers = new ArrayList<>();
    private final ArrayList<Product> products = new ArrayList<>();

    public Service(
            int id,
            LocalDateTime start,
            LocalDateTime end,
            float servicePrice,
            int workerPercentage,
            ServiceStatus status,
            ServiceCategory category,
            Client client,
            ArrayList<Product> products,
            ArrayList<Worker> workers) {
        this.id = id;
        this.start = start;
        this.end = end;
        this.servicePrice = servicePrice;
        this.workerPercentage = workerPercentage;
        this.status = status;
        this.category = category;
        this.client = client;
        this.products.addAll(products);
        this.workers.addAll(workers);
    }

    public Service(
            int id,
            LocalDateTime start,
            LocalDateTime end,
            float servicePrice,
            int workerPercentage,
            ServiceStatus status,
            ServiceCategory category,
            Client client,
            Product product,
            Worker worker) {
        this.id = id;
        this.start = start;
        this.end = end;
        this.servicePrice = servicePrice;
        this.workerPercentage = workerPercentage;
        this.status = status;
        this.category = category;
        this.client = client;
        this.products.add(product);
        this.workers.add(worker);
    }

    public Service(
            int id,
            LocalDateTime start,
            LocalDateTime end,
            float servicePrice,
            int workerPercentage,
            ServiceStatus status,
            ServiceCategory category,
            Client client,
            ArrayList<Product> products,
            Worker worker) {
        this.id = id;
        this.start = start;
        this.end = end;
        this.servicePrice = servicePrice;
        this.workerPercentage = workerPercentage;
        this.status = status;
        this.category = category;
        this.client = client;
        this.products.addAll(products);
        this.workers.add(worker);
    }

    public Integer getId() {
        return id;
    }

    public LocalDateTime getStart() {
        return start;
    }

    public void setStart(LocalDateTime start) {
        this.start = start;
    }

    public LocalDateTime getEnd() {
        return end;
    }

    public void setEnd(LocalDateTime end) {
        this.end = end;
    }

    public float getServicePrice() {
        return servicePrice;
    }

    public void setServicePrice(float servicePrice) {
        this.servicePrice = servicePrice;
    }

    public float getTotalPrice(){
        Optional<Float> productsPrice = products.stream()
                .map(Product::getSalePrice)
                .reduce(Float::sum);
        if(productsPrice.isEmpty())
            return servicePrice;
        return productsPrice.get() + servicePrice;
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

    public ServiceCategory getCategory() {
        return category;
    }

    public void setCategory(ServiceCategory category) {
        this.category = category;
    }

    public boolean hasFeedback() {
        return serviceEvaluation != null;
    }

    public void setServiceEvaluation(ServiceEvaluation serviceEvaluation){
        if(!this.hasFeedback()){
            this.serviceEvaluation = serviceEvaluation;
        }
    }

    public ServiceEvaluation getServiceEvaluation(){
        return serviceEvaluation;
    }

    public Client getClient() {
        return client;
    }

    public ArrayList<Worker> getWorkers() {
        return workers;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }
}