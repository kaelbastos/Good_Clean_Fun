package org.kaelbastos.Domain.Entities.Service;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;
import org.kaelbastos.Domain.Entities.utils.Address;
import org.kaelbastos.Domain.Entities.utils.ObservationType;
import org.kaelbastos.Domain.Entities.utils.Person;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class ServiceEvaluationTest {
    String comment = "An comment";
    int rating = 5;
    Person author = new Person("00000000000", "Person",
            "00000000000", "person@person.com",
            new Address("rua dos bobos", "neighborhood",
                    "city", "state", "0", "0", null));
    ServiceEvaluation serviceEvaluation = new ServiceEvaluation(comment, rating, author);

    private static Stream<Arguments> provideServiceEvaluationTypeForSetServiceEvaluationType(){
        return Arrays.stream(ObservationType.values()).map(Arguments::of);
    }

    @Order(1)
    @Test
    void getObservation() {
        assertEquals(comment, serviceEvaluation.getComment());
    }

    @Order(2)
    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"an Observation", "A different observation", "    "})
    void setObservation(String newObservation) {
        serviceEvaluation.setComment(newObservation);
        assertEquals(newObservation, serviceEvaluation.getComment());
    }

    @Order(3)
    @Test
    void getRating() {
        assertEquals(rating, serviceEvaluation.getRating());
    }

    @Order(4)
    @ParameterizedTest
    @ValueSource(ints = {-1, 0,1,2,3,4,5,6,7,8,9,10,11, 100})
    void setRating(int validRating) {
        serviceEvaluation.setRating(validRating);
        assertEquals(validRating, serviceEvaluation.getRating());
    }

    @Order(5)
    @Test
    void getAuthor() {
        assertEquals(author, serviceEvaluation.getAuthor());
    }
}