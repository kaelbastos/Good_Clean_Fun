package org.kaelbastos.Domain.entities.utils;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class AddressValidatorTest {
    String street = "street";
    String neighborhood = "neighborhood";
    String city = "city";
    String state = "State";
    String number = "00";
    String postalCode = "0";
    String complement = null;

    Address address = new Address(
            street,
            neighborhood,
            city,
            state,
            number,
            postalCode,
            complement);
    AddressValidator addressValidator = new AddressValidator();


    @Test
    void validateWithoutErrors() {
        Address address = new Address(
                street,
                neighborhood,
                city,
                state,
                number,
                postalCode,
                complement);
        assertTrue(addressValidator.validate(address).isCorrect());
    }

    @Test
    void validateNullAddress() {
        Notification notification = addressValidator.validate(null);
        assertTrue(notification.hasErrors());
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {
            "    ",
            " ",
            ""})
    void validateStreetWithError(String streetTest) {
        Address address = new Address(
                streetTest,
                neighborhood,
                city,
                state,
                number,
                postalCode,
                complement);
        Notification notification = addressValidator.validate(address);
        assertTrue(notification.hasErrors());
        assertTrue(notification.getMessage().contains("Street"));
    }
    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {
            "    ",
            " ",
            ""})
    void validateNeighborhoodWithError(String neighborhoodTest) {
        Address address = new Address(
                street,
                neighborhoodTest,
                city,
                state,
                number,
                postalCode,
                complement);
        Notification notification = addressValidator.validate(address);
        assertTrue(notification.hasErrors());
        assertTrue(notification.getMessage().contains("Neighborhood"));
    }
    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {
            "    ",
            " ",
            ""})
    void validateCityWithError(String cityTest) {
        Address address = new Address(
                street,
                neighborhood,
                cityTest,
                state,
                number,
                postalCode,
                complement);
        Notification notification = addressValidator.validate(address);
        assertTrue(notification.hasErrors());
        assertTrue(notification.getMessage().contains("City"));
    }
    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {
            "    ",
            " ",
            ""})
    void validateStateWithError(String stateTest) {
        Address address = new Address(
                street,
                neighborhood,
                city,
                stateTest,
                number,
                postalCode,
                complement);
        Notification notification = addressValidator.validate(address);
        assertTrue(notification.hasErrors());
        assertTrue(notification.getMessage().contains("State"));
    }
    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {
            "    ",
            " ",
            ""})
    void validateNumberWithError(String numberTest) {
        Address address = new Address(
                street,
                neighborhood,
                city,
                state,
                numberTest,
                postalCode,
                complement);
        Notification notification = addressValidator.validate(address);
        assertTrue(notification.hasErrors());
        assertTrue(notification.getMessage().contains("Number"));
    }
    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {
            "    ",
            " ",
            ""})
    void validatePostalCodeWithError(String postalCodeTest) {
        Address address = new Address(
                street,
                neighborhood,
                city,
                state,
                number,
                postalCodeTest,
                complement);
        Notification notification = addressValidator.validate(address);
        assertTrue(notification.hasErrors());
        assertTrue(notification.getMessage().contains("PostalCode"));
    }

    @ParameterizedTest
    @MethodSource("provideStringsForMultipleErrorsTest")
    public void validateWithMultipleErrors(
            String street,
            String neighborhood,
            String city,
            String state,
            String number,
            String postalCode,
            String complement) {
        Address address = new Address(
                street,
                neighborhood,
                city,
                state,
                number,
                postalCode,
                complement);
        Notification notification = addressValidator.validate(address);
        assertTrue(notification.hasErrors());
        assertTrue(notification.getMessage().split(";").length > 1);
    }
    private static Stream<Arguments> provideStringsForMultipleErrorsTest() {
        return Stream.of(
                Arguments.of("street", "neighborhood", " ", "State", null, "0", null),
                Arguments.of("street", "neighborhood", " ", "State", null, "", null),
                Arguments.of("       ", "", " ", "State", "00", "0", null),
                Arguments.of(null, "neighborhood", " ", "State", "00", "", null),
                Arguments.of("street", "", " ", "State", "00", "", null),
                Arguments.of("street", "neighborhood", " ", "State", "00", "", "complement"),
                Arguments.of("", "", "", "", "", "", ""),
                Arguments.of(" ", " ", " ", " ", " ", " ", " "),
                Arguments.of(null, null, null, null, null, null, null)
        );
    }
}