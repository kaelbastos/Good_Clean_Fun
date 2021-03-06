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
    private float servicePrice;
    private int workerPercentage;
    private ServiceStatus status;
    private ServiceCategory category;
    private ServiceEvaluation serviceEvaluation;
    private boolean payed = false;
    private final Client client;
    private final ArrayList<Worker> workers = new ArrayList<>();
    private final ArrayList<Product> products = new ArrayList<>();

    public Service(
            int id,
            LocalDateTime start,
            float servicePrice,
            int workerPercentage,
            ServiceStatus status,
            ServiceCategory category,
            Client client,
            ArrayList<Product> products,
            ArrayList<Worker> workers) {
        this.id = id;
        this.start = start;
        this.servicePrice = servicePrice;
        this.workerPercentage = workerPercentage;
        this.status = status;
        this.category = category;
        this.client = client;
        this.products.addAll(products);
        this.workers.addAll(workers);
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

    public float getProfit(){
        float profit = (getTotalPrice() * workerPercentage)/10;
        Optional<Float> productsCost = products.stream()
                .map(Product::getPurchasePrice)
                .reduce(Float::sum);
        if(productsCost.isPresent())
            profit -= productsCost.get();
        return profit;
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

    public boolean isPayed() {
        return payed;
    }

    public void setPayed(boolean payed) {
        this.payed = payed;
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

    @Override
    public String toString() {
        return "Service{" +
                "\nid=" + id +
                ", \nstart=" + start +
                ", \nservicePrice=" + servicePrice +
                ", \nworkerPercentage=" + workerPercentage +
                ", \nstatus=" + status +
                ",\n" + category +
                ", \nserviceEvaluation=" + serviceEvaluation +
                ", \npayed=" + payed +
                ", \nclient=" + client +
                ", \nworkers=" + workers +
                ", \nproducts=" + products +
                '}';
    }
}