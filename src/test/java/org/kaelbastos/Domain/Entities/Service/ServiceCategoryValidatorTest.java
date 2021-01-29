package org.kaelbastos.Domain.Entities.Service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.kaelbastos.Domain.Entities.utils.Notification;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class ServiceCategoryValidatorTest {
    ServiceCategoryValidator validator = new ServiceCategoryValidator();

    @ParameterizedTest
    @MethodSource("provideArgsForSingleErrorTest")
    void singleErrorTest(ServiceCategory serviceCategory) {
        Notification notification = validator.validate(serviceCategory);
        assertTrue(notification.hasErrors());
    }
    private static Stream<Arguments> provideArgsForSingleErrorTest() {
        return Stream.of(
                Arguments.of(new ServiceCategory(0, "name", 0)),
                Arguments.of(new ServiceCategory(-1, "name", 1.5)),
                Arguments.of(new ServiceCategory(-3, "name", 1.5)),
                Arguments.of(new ServiceCategory(0, "", 1.5)),
                Arguments.of(new ServiceCategory(0, "  ", 1.5)),
                Arguments.of(new ServiceCategory(0, null, 1.5)),
                Arguments.of(new ServiceCategory(0, "name", -1.5)),
                Arguments.of(new ServiceCategory(0, "name", 0.4))

        );
    }
}