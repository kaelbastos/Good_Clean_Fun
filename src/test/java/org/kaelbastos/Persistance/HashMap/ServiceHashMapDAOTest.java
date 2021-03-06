package org.kaelbastos.Persistance.HashMap;

import org.junit.jupiter.api.Test;
import org.kaelbastos.Domain.Entities.Client.Client;
import org.kaelbastos.Domain.Entities.Client.ResidenceType;
import org.kaelbastos.Domain.Entities.Product.Product;
import org.kaelbastos.Domain.Entities.Product.ProductCategory;
import org.kaelbastos.Domain.Entities.Service.Service;
import org.kaelbastos.Domain.Entities.Service.ServiceCategory;
import org.kaelbastos.Domain.Entities.Service.ServiceStatus;
import org.kaelbastos.Domain.Entities.Worker.Worker;
import org.kaelbastos.Domain.Entities.utils.Address;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ServiceHashMapDAOTest {
    Service service = new Service(1,
            LocalDateTime.of(2020,1,5,8,30),
            80.00F,
            30,
            ServiceStatus.Done,
            new ServiceCategory(0, "name", 1.5),
            new Client(
                    "45649283842",
                    "Antonio Souza",
                    "33744378",
                    "antonio@gmail.com",
                    new Address(
                            "Rua Ds Margaridas",
                            "Das Camélias",
                            "Osasco",
                            "SP",
                            "125",
                            "13568420",
                            "Perto do Bar do Luiz"),
                            ResidenceType.House),
            new ArrayList<Product>(List.of(new Product(
                            1,
                            "Detergente",
                            8.00F,
                            ProductCategory.Chemical))),
            new ArrayList<Worker>(List.of(new Worker("12345678910",
                                    "Julia Rodrigues",
                                    "12345678910",
                                    "12345678910",
                                    "julia@gmail.com",
                                    new Address("Street",
                                            "Neighborhood",
                                            "City", "State",
                                            "10",
                                            "12",
                                            "")))));

        ServiceHashMapDAO serviceHashMapDAO = new ServiceHashMapDAO();

    @Test
    void saveService() {
        assertTrue(serviceHashMapDAO.save(service));
    }

    @Test
    void saveSameServiceTwice() {
        assertTrue(serviceHashMapDAO.save(service));
        assertFalse(serviceHashMapDAO.save(service));
    }

    @Test
    void saveNullService() {
        assertFalse(serviceHashMapDAO.save(null));
    }

    @Test
    void updateService() {
        assertTrue(serviceHashMapDAO.save(service));
        service.setStatus(ServiceStatus.Canceled);
        assertTrue(serviceHashMapDAO.update(service));
    }

    @Test
    void updateServiceWithNullArg() {
        assertFalse(serviceHashMapDAO.update(null));
    }

    @Test
    void updateNotExistService() {
        assertFalse(serviceHashMapDAO.update(new Service(0,
                LocalDateTime.of(2020,1,5,8,30),
                80.00F,
                30,
                ServiceStatus.Done,
                new ServiceCategory(1, "name", 2.5),
                new Client(
                        "45649283842",
                        "Antonio Souza",
                        "33744378",
                        "antonio@gmail.com",
                        new Address(
                                "Rua Ds Margaridas",
                                "Das Camélias",
                                "Osasco",
                                "SP",
                                "125",
                                "13568420",
                                "Perto do Bar do Luiz"),
                        ResidenceType.House),
                new ArrayList<Product>(List.of(new Product(
                        1,
                        "Detergente",
                        8.00F,
                        ProductCategory.Chemical))),
                new ArrayList<Worker>(List.of(new Worker("12345678910",
                        "Julia Rodrigues",
                        "12345678910",
                        "12345678910",
                        "julia@gmail.com",
                        new Address("Street",
                                "Neighborhood",
                                "City", "State",
                                "10",
                                "12",
                                "")))))));
    }

    @Test
    void deleteServiceWithNotExists() {
        assertFalse(serviceHashMapDAO.delete(16));
    }

    @Test
    void deleteSameWorkerTwice() {
        assertTrue(serviceHashMapDAO.save(service));
        assertTrue(serviceHashMapDAO.delete(service.getId()));
        assertFalse(serviceHashMapDAO.delete(service.getId()));
    }

    @Test
    void getOneServiceWithNullKey() {
        assertFalse(serviceHashMapDAO.getOne(null).isPresent());
    }

    @Test
    void getNonExistingService() {
        assertFalse(serviceHashMapDAO.getOne(-1).isPresent());
    }

    @Test
    void getAllServicesWithoutServicesSaved() {
        assertTrue(serviceHashMapDAO.getAll().get().isEmpty());
    }

    @Test
    void getNoServicesFromAllServices() {
        assertFalse(serviceHashMapDAO.getAll().isEmpty());
    }

    @Test
    void getProductsFromNotExistService() {
        assertFalse(serviceHashMapDAO.getAll().isEmpty());
    }
}