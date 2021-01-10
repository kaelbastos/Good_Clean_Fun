package org.kaelbastos.Domain.Entities.Client;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.kaelbastos.Domain.Entities.utils.Address;
import org.kaelbastos.Domain.Entities.utils.Observation;
import org.kaelbastos.Domain.Entities.utils.ObservationType;

import static org.junit.jupiter.api.Assertions.*;

class ClientTest {
    String cpf = "00000000000";
    String name = "Person Test";
    String telephone = "00000000000";
    String email = "test@test.com";
    Address address = new Address(
            "street",
            "neighborhood",
            "city",
            "State",
            "00",
            "0",
            null);
    ResidenceType residenceType = ResidenceType.House;

    Client client = new Client(cpf, name, telephone, email, address, residenceType);

    @Order(1)
    @Test
    void getResidenceType() {
        assertEquals(residenceType, client.getResidenceType());
    }

    @Order(2)
    @Test
    void setResidenceType() {
        ResidenceType newResidenceType = ResidenceType.Apartment;
        client.setResidenceType(newResidenceType);
        assertEquals(newResidenceType, client.getResidenceType());
    }

    @Order(3)
    @Test
    void getObservations() {
        assertNotNull(client.getObservations());
    }

    @Order(4)
    @Test
    void addObservation() {
        Observation observation = new Observation(ObservationType.Other, "A comment", null);
        client.addObservation(observation);
        assertTrue(client.getObservations().contains(observation));
    }
}