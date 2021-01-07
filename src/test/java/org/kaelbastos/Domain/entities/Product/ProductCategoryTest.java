package org.kaelbastos.Domain.entities.Product;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.Objects;

class ProductCategoryTest {
    private final int NUM_OBSERVATIONS = 6;

    @Test
    void testIntegrity() {
        assertEquals(NUM_OBSERVATIONS, ProductCategory.values().length);
        assertTrue(Arrays.stream(ProductCategory.values())
                .noneMatch(Objects::isNull));
    }

}