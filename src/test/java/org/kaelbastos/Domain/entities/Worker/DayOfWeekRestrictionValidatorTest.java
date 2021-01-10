package org.kaelbastos.Domain.entities.Worker;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullSource;
import org.kaelbastos.Domain.entities.utils.Notification;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class DayOfWeekRestrictionValidatorTest {
    DayOfWeekRestrictionValidator dayOfWeekRestrictionValidator = new DayOfWeekRestrictionValidator();

    @ParameterizedTest
    @NullSource
    @MethodSource("provideStringsForMultipleErrorsTest")
    public void validateWithMultipleErrors(DayOfWeekRestriction dayOfWeekRestriction){
        Notification notification = dayOfWeekRestrictionValidator.validate(dayOfWeekRestriction);
        assertTrue(notification.hasErrors());
    }

    private static Stream<Arguments> provideStringsForMultipleErrorsTest() {
        return Stream.of(
                Arguments.of(new DayOfWeekRestriction(LocalDateTime.of(LocalDate.ofYearDay(2021, 200), LocalTime.NOON), LocalDateTime.of(LocalDate.ofYearDay(2021, 200), LocalTime.NOON), null)),
                Arguments.of(new DayOfWeekRestriction(LocalDateTime.of(LocalDate.ofYearDay(2021, 201), LocalTime.NOON), LocalDateTime.of(LocalDate.ofYearDay(2021, 200), LocalTime.NOON),"")),
                Arguments.of(new DayOfWeekRestriction(null, null,""))
        );
    }


}