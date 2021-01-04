package org.kaelbastos.Domain.entities.Client;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class ResidenceTypeTest {
    private final int NUM_RESIDENCE_TYPES = 4;

    @Test
    void testIntegrity() {
        Assertions.assertEquals(NUM_RESIDENCE_TYPES, ResidenceType.values().length);
        assertTrue(Arrays.stream(ResidenceType.values())
                .noneMatch(Objects::isNull));
    }

}