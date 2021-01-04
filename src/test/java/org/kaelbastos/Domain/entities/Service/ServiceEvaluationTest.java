package org.kaelbastos.Domain.entities.Service;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;
import org.kaelbastos.Domain.entities.utils.Address;
import org.kaelbastos.Domain.entities.utils.ObservationType;
import org.kaelbastos.Domain.entities.utils.Person;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class ServiceEvaluationTest {
    String comment = "An comment";
    float rating = 5F;
    Person author = new Person("00000000000", "Person",
            "00000000000", "person@person.com",
            new Address("rua dos bobos", "neighborhood",
                    "city", "state", "0", "0", null));
    ServiceEvaluation serviceEvaluation = new ServiceEvaluation(comment, rating, author);

    private static Stream<Arguments> provideServiceEvaluationTypeForSetServiceEvaluationType(){
        return Arrays.stream(ObservationType.values()).map(Arguments::of);
    }

    @Order(3)
    @Test
    void getObservation() {
        assertEquals(comment, serviceEvaluation.getComment());
    }

    @Order(4)
    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"an Observation", "A different observation", "    "})
    void setObservation(String newObservation) {
        serviceEvaluation.setComment(newObservation);
        assertEquals(newObservation, serviceEvaluation.getComment());
    }

    @Order(5)
    @Test
    void getRating() {
        assertEquals(rating, serviceEvaluation.getRating());
    }

    @Order(6)
    @ParameterizedTest
    @ValueSource(floats = {1F, 2F,2.5F, 5F})
    void setValidRating(Float validRating) {
        serviceEvaluation.setRating(validRating);
        assertEquals(validRating, serviceEvaluation.getRating());
    }

    @Order(7)
    @ParameterizedTest
    @NullSource
    @ValueSource(floats = {0F, 6F, 10F})
    void setInvalidRating(Float invalidRating) {
        serviceEvaluation.setRating(invalidRating);
        assertNotEquals(invalidRating, serviceEvaluation.getRating());
    }

    @Test
    void getAuthor() {
        assertEquals(author, serviceEvaluation.getAuthor());
    }
}