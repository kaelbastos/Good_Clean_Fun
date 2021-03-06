package org.kaelbastos.Domain.Entities.Service;

import org.junit.jupiter.api.Test;
import org.kaelbastos.Domain.Entities.Client.Client;
import org.kaelbastos.Domain.Entities.Client.ResidenceType;
import org.kaelbastos.Domain.Entities.Product.Product;
import org.kaelbastos.Domain.Entities.Product.ProductCategory;
import org.kaelbastos.Domain.Entities.Worker.Worker;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ServiceTest {
    int id = 0;
    LocalDateTime start = LocalDateTime.of(2021, 1, 6, 22 , 14);
    float servicePrice = 100F;
    int workerPercentage = 50;
    ServiceStatus status = ServiceStatus.Scheduled;
    ServiceCategory category = new ServiceCategory(0, "name", 2.0);
    Client client = new Client("00000000000", "Name", "00000000000", "client@client.com", null, ResidenceType.House);
    Product product = new Product(1, "broom", 10F,ProductCategory.Utensil);
    ArrayList<Product> products = new ArrayList<>(List.of(product));
    Worker worker = new Worker("00000000000", "Name", "00000000000", "11111111111","client@client.com", null);
    ArrayList<Worker> workers = new ArrayList<>(List.of(worker));

    Service service = new Service(id, start, servicePrice, workerPercentage, status , category, client, products, workers);
    ServiceEvaluation serviceEvaluation = new ServiceEvaluation("comment", 5, client);

    @Test
    void getId() {
        assertEquals(id, service.getId());
    }

    @Test
    void getStart() {
        assertEquals(start, service.getStart());
    }

    @Test
    void setStart() {
        LocalDateTime newStart = LocalDateTime.of(2021, 1, 6, 23 , 14);
        service.setStart(newStart);
        assertEquals(newStart, service.getStart());
    }


    @Test
    void getServicePrice() {
        assertEquals(servicePrice, service.getServicePrice());
    }

    @Test
    void setServicePrice() {
        float newServicePrice = 150F;
        service.setServicePrice(newServicePrice);
        assertEquals(newServicePrice, service.getServicePrice());
    }

    @Test
    void getTotalPriceWithNoProduct() {
        assertEquals(110, service.getTotalPrice());
    }

    @Test
    void getWorkerPercentage() {
        assertEquals(workerPercentage, service.getWorkerPercentage());
    }

    @Test
    void setWorkerPercentage() {
        int newWorkerPercentage = 100;
        service.setWorkerPercentage(newWorkerPercentage);
        assertEquals(newWorkerPercentage, service.getWorkerPercentage());
    }

    @Test
    void getStatus() {
        assertEquals(status, service.getStatus());
    }

    @Test
    void setStatus() {
        ServiceStatus newStatus = ServiceStatus.Done;
        service.setStatus(newStatus);
        assertEquals(newStatus, service.getStatus());
    }

    @Test
    void getCategory() {
        assertEquals(category, service.getCategory());
    }

    @Test
    void setCategory() {
        ServiceCategory newCategory = new ServiceCategory(2, "new category", 3.5);
        service.setCategory(newCategory);
        assertEquals(newCategory, service.getCategory());
    }

    @Test
    void isHasFeedback() {
        assertFalse(service.hasFeedback());
    }

    @Test
    void setServiceEvaluation() {
        service.setServiceEvaluation(serviceEvaluation);
        assertTrue(service.hasFeedback());
    }

    @Test
    void getServiceEvaluation() {
        service.setServiceEvaluation(serviceEvaluation);
        assertEquals(serviceEvaluation, service.getServiceEvaluation());
    }

    @Test
    void getClient() {
        assertEquals(client, service.getClient());
    }

    @Test
    void getWorkers() {
        assertTrue(service.getWorkers().contains(worker));
    }

    @Test
    void getProducts() {
        assertTrue(service.getProducts().contains(product));
    }
}