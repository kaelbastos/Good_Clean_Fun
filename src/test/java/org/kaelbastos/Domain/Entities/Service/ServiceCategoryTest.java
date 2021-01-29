package org.kaelbastos.Domain.Entities.Service;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ServiceCategoryTest {
    int expectedId = 1;
    String expectedName = "name";
    double expectedDuration = 2.0;

    ServiceCategory serviceCategory = new ServiceCategory(expectedId, expectedName, expectedDuration);


    @Test
    void getId() {
        int actualId = serviceCategory.getId();
        assertEquals(actualId, expectedId);
    }

    @Test
    void setId() {
        int expectedId = 2;

        serviceCategory.setId(expectedId);
        int actualId = serviceCategory.getId();

        assertEquals(actualId, expectedId);
    }

    @Test
    void getName() {
        String actualName = serviceCategory.getName();
        assertEquals(actualName, expectedName);
    }

    @Test
    void setName() {
        String expectedName = "new name";

        serviceCategory.setName(expectedName);
        String actualName = serviceCategory.getName();

        assertEquals(actualName, expectedName);
    }

    @Test
    void getDuration() {
        double actualDuration = serviceCategory.getDuration();
        assertEquals(actualDuration, expectedDuration);
    }

    @Test
    void setDuration() {
        double expectedDuration = 1.5;

        serviceCategory.setDuration(expectedDuration);
        double actualDuration = serviceCategory.getDuration();

        assertEquals(actualDuration, expectedDuration);
    }
}