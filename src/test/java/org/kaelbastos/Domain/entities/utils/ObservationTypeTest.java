package org.kaelbastos.Domain.entities.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class ObservationTypeTest {

    private final int NUM_OBSERVATIONS = 6;

    @Test
    void testIntegrity() {
        Assertions.assertEquals(NUM_OBSERVATIONS, ObservationType.values().length);
        assertTrue(Arrays.stream(ObservationType.values())
                .noneMatch(Objects::isNull));
    }
}