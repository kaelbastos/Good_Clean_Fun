package org.kaelbastos.Domain.entities.Service;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.Objects;

class ServiceCategoryTest {
    private final int NUM_OBSERVATIONS = 10;

    @Test
    void testIntegrity() {
        assertEquals(NUM_OBSERVATIONS, ServiceCategory.values().length);
        assertTrue(Arrays.stream(ServiceCategory.values())
                .noneMatch(Objects::isNull));
    }

}