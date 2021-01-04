package org.kaelbastos.Domain.entities.Client;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import org.kaelbastos.Domain.entities.utils.Address;
import org.kaelbastos.Domain.entities.utils.Notification;
import org.kaelbastos.Domain.entities.utils.Person;
import org.kaelbastos.Domain.entities.utils.PersonValidator;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class ClientValidatorTest {
    String cpf = "00000000000";
    String name = "Person Test";
    String telephone = "00000000000";
    String email = "test@test.com";
    Address address = new Address(
            "street",
            "neighborhood",
            "city",
            "State",
            "00",
            "0",
            null);
    ResidenceType residenceType = ResidenceType.House;

    Client client = new Client(cpf, name, telephone, email, address, residenceType);
    ClientValidator clientValidator = new ClientValidator();

    @Test
    void validateNullPerson() {
        Notification notification = clientValidator.validate(null);
        assertTrue(notification.hasErrors());
    }

    @Test
    void validateWithoutErrors() {
        Notification notification = clientValidator.validate(client);
        assertTrue(notification.isCorrect());
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {
            "000.000.000/00",
            "000000000000",
            "000-000-000/00",
            "a0000000000",
            "0000000000",
            "",
            " "})
    void validateWithCPFError(String cpfTest) {
        Client client = new Client(cpfTest, name, telephone, email, address, residenceType);
        Notification notification = clientValidator.validate(client);
        assertTrue(notification.hasErrors());
        assertTrue(notification.getMessage().contains("CPF"));
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {
            "",
            " "})
    void validateWithNameError(String nameTest) {
        Client client = new Client(cpf, nameTest, telephone, email, address, residenceType);
        Notification notification = clientValidator.validate(client);
        assertTrue(notification.hasErrors());
        assertTrue(notification.getMessage().contains("Name"));
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {
            "test",
            "test@test",
            "test@test",
            "@test.com",
            "test@.com",
            "@.",
            "",
            " "})
    void validateWithEmailError(String emailTest) {
        client.setEmail(emailTest);
        Notification notification = clientValidator.validate(client);
        assertTrue(notification.hasErrors());
        assertTrue(notification.getMessage().contains("Email"));
    }

    @Test
    void validateNullResidenceType() {
        client.setResidenceType(null);
        Notification notification = clientValidator.validate(client);
        assertTrue(notification.hasErrors());
        assertTrue(notification.getMessage().contains("Residence"));
    }

    @ParameterizedTest
    @MethodSource("provideStringsForMultipleErrorsTest")
    public void validateWithMultipleErrors(
            String cpf,
            String name,
            String telephone,
            String email,
            Address address,
            ResidenceType residenceType) {
        Client client = new Client(cpf, name, telephone, email, address, residenceType);
        Notification notification = clientValidator.validate(client);
        assertTrue(notification.hasErrors());
        assertTrue(notification.getMessage().split(";").length > 1);
    }

    private static Stream<Arguments> provideStringsForMultipleErrorsTest() {
        return Stream.of(
                Arguments.of("000000000000", "name", "0", "test@test.com", new Address("street", "neighborhood", "city", "State", null, "0", null), ResidenceType.House),
                Arguments.of("", "", "", "@test.com", new Address("", "neighborhood", "city", "State", null, "0", null), ResidenceType.House),
                Arguments.of(null, "name", "0000000000", "test@test", new Address("street", "neighborhood", "city", "State", null, "0", null), ResidenceType.Rural),
                Arguments.of("000-000-000/00", "name", "00000000000", "test@test.com", null, null),
                Arguments.of("00000000000", "name", "00000000000", "test@test.com", new Address("", null, "", "State", null, "0", null), ResidenceType.Loft),
                Arguments.of("000.000.000/00", "name", "(00)00000-0000", "test@test.com", new Address("street", "neighborhood", "city", "State", null, "0", null), ResidenceType.Apartment),
                Arguments.of("", "", "", "", new Address("", "", "", "", "", "", ""), null),
                Arguments.of(" ", " ", " ", " ", new Address(" ", " ", " ", " ", " ", " ", " "), null),
                Arguments.of(null, null, null, null, null, null)

        );
    }
}