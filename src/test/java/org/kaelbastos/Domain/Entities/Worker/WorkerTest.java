package org.kaelbastos.Domain.Entities.Worker;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import org.kaelbastos.Domain.Entities.utils.Address;
import org.kaelbastos.Domain.Entities.utils.Observation;
import org.kaelbastos.Domain.Entities.utils.ObservationType;

import static org.junit.jupiter.api.Assertions.*;

class WorkerTest {
    String cpf = "00000000000";
    String name = "Person Test";
    String telephone = "00000000000";
    String secondaryTelephone = "11111111111";
    String email = "test@test.com";
    Address address = new Address(
            "street",
            "neighborhood",
            "city",
            "State",
            "00",
            "0",
            null);

    Worker worker = new Worker(cpf, name, telephone, secondaryTelephone, email, address);

    @Order(1)
    @Test
    void getSecondaryPhone() {
        assertEquals(secondaryTelephone, worker.getSecondaryPhone());
    }

    @Order(2)
    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"22222222222"})
    void setSecondaryPhone(String telephone) {
        worker.setSecondaryPhone(telephone);
        assertEquals(telephone, worker.getSecondaryPhone());
    }

    @Order(3)
    @Test
    void isActive() {
        assertTrue(worker.isActive());
    }

    @Order(4)
    @ParameterizedTest
    @ValueSource(booleans = {true, false})
    void setActive(boolean active) {
        worker.setActive(active);
        assertEquals(active, worker.isActive());
    }

    @Order(5)
    @Test
    void getDayOfWeekRestrictions() {
        assertNotNull(worker.getDayOfWeekRestrictions());
    }

    @Order(6)
    @Test
    void addDayOfWeekRestrictions() {
        DayOfWeekRestriction dayOfWeekRestriction = new DayOfWeekRestriction(null, null, " ");
        worker.addDayOfWeekRestrictions(dayOfWeekRestriction);
        assertTrue(worker.getDayOfWeekRestrictions().contains(dayOfWeekRestriction));
    }

    @Order(7)
    @Test
    void removeDayOfWeekRestriction() {
        DayOfWeekRestriction dayOfWeekRestriction = new DayOfWeekRestriction(null, null, " ");
        worker.addDayOfWeekRestrictions(dayOfWeekRestriction);
        assertTrue(worker.removeDayOfWeekRestriction(dayOfWeekRestriction));
        assertFalse(worker.getDayOfWeekRestrictions().contains(dayOfWeekRestriction));
    }

    @Order(8)
    @Test
    void getObservations() {
        assertNotNull(worker.getObservations());
    }

    @Order(9)
    @Test
    void addObservation() {
        Observation observation = new Observation(ObservationType.Comment, "A comment",  null);
        worker.addObservation(observation);
        assertTrue(worker.getObservations().contains(observation));
    }

    @Order(10)
    @Test
    void removeObservation() {
        Observation observation = new Observation(ObservationType.Comment, "A comment", null);
        worker.addObservation(observation);
        assertTrue(worker.removeObservation(observation));
        assertFalse(worker.getObservations().contains(observation));
    }
}