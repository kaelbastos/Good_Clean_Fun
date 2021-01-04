package org.kaelbastos.Domain.entities.utils;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class ObservationTest {
    ObservationType observationType = ObservationType.Comment;
    String comment = "An comment";
    float rating = 5F;
    Person author = new Person("00000000000", "Person",
            "00000000000", "person@person.com",
            new Address("rua dos bobos", "neighborhood",
                    "city", "state", "0", "0", null));
    Observation observation = new Observation(observationType, comment, rating, author);

    private static Stream<Arguments> provideServiceEvaluationTypeForSetServiceEvaluationType(){
        return Arrays.stream(ObservationType.values()).map(Arguments::of);
    }

    @Order(1)
    @Test
    void getObservationType() {
        assertEquals(observationType, observation.getObservationType());
    }

    @Order(2)
    @ParameterizedTest
    @NullSource
    @MethodSource("provideObservationTypesArgs")
    void setObservationType(ObservationType observationType) {
        observation.setObservationType(observationType);
        assertEquals(observationType, observation.getObservationType());
    }

    private static Stream<Arguments> provideObservationTypesArgs(){
        return Arrays.stream(ObservationType.values()).map(Arguments::of);
    }

    @Order(3)
    @Test
    void getObservation() {
        assertEquals(comment, observation.getComment());
    }

    @Order(4)
    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"an Observation", "A different observation", "    "})
    void setObservation(String newObservation) {
        observation.setComment(newObservation);
        assertEquals(newObservation, observation.getComment());
    }

    @Order(5)
    @Test
    void getRating() {
        assertEquals(rating, observation.getRating());
    }

    @Order(6)
    @ParameterizedTest
    @ValueSource(floats = {1F, 2F,2.5F, 5F})
    void setValidRating(Float validRating) {
        observation.setRating(validRating);
        assertEquals(validRating, observation.getRating());
    }

    @Order(7)
    @ParameterizedTest
    @NullSource
    @ValueSource(floats = {0F, 6F, 10F})
    void setInvalidRating(Float invalidRating) {
        observation.setRating(invalidRating);
        assertNotEquals(invalidRating, observation.getRating());
    }

    @Test
    void getAuthor() {
        assertEquals(author, observation.getAuthor());
    }

}