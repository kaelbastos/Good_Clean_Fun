package org.kaelbastos.Domain.entities.utils;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.kaelbastos.Domain.entities.Service.Service;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class ObservationValidatorTest {

    ObservationType observationType = ObservationType.Comment;
    String comment = "An comment";
    Person author = new Person("00000000000", "Person",
            "00000000000", "person@person.com",
            new Address("rua dos bobos", "neighborhood",
                    "city", "state", "0", "0", null));

    ObservationValidator observationValidator = new ObservationValidator();

    @ParameterizedTest
    @MethodSource("provideStringsForMultipleErrorsTest")
    public void validateWithMultipleErrors(
            ObservationType observationType,
            String comment,
            Person author){
        Observation observation = new Observation(observationType, comment, author);
        Notification notification = observationValidator.validate(observation);
        assertTrue(notification.hasErrors());
        assertTrue(notification.getMessage().split(Notification.getDelimiter()).length > 1);
    }

    private static Stream<Arguments> provideStringsForMultipleErrorsTest() {
        return Stream.of(
                Arguments.of(ObservationType.Comment, null, new Person("00000000000", "Person", "00000000000", "person@person.com", new Address("rua dos bobos", "neighborhood", "city", "state", "0", " ", null))),
                Arguments.of(ObservationType.Comment, "An comment", new Person("00000000000", "Person", "000000000", "person@test", new Address("rua dos bobos", "neighborhood", "city", "state", "0", "0", null))),
                Arguments.of(ObservationType.Comment, "", new Person("00000000000", "Person", "00000000000", "@person.com", new Address("rua dos bobos", "neighborhood", "city", "state", "0", "0", null))),
                Arguments.of(ObservationType.Comment, "", new Person("000000000", "Person", "0000000", "person@", new Address("rua dos bobos", "neighborhood", "city", "state", "0", "0", null))),
                Arguments.of(null, " ", new Person(" ", " ", " ", " ", new Address(" ", " ", " ", " ", " ", " ", null))),
                Arguments.of(null, "", new Person("", "", "", "", new Address("", "", "", "", "", "", null))),
                Arguments.of(ObservationType.Comment, "An comment", new Person("00000000000", "Person", "00000000000", "person@perso", null)),
                Arguments.of(ObservationType.Comment, " ", null),
                Arguments.of(ObservationType.Comment, "", null)
        );
    }

}