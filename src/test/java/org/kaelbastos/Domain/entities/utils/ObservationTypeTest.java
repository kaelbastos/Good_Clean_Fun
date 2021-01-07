package org.kaelbastos.Domain.entities.utils;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.Objects;

class ObservationTypeTest {

    private final int NUM_OBSERVATIONS = 6;

    @Test
    void testIntegrity() {
        assertEquals(NUM_OBSERVATIONS, ObservationType.values().length);
        assertTrue(Arrays.stream(ObservationType.values())
                .noneMatch(Objects::isNull));
    }
}