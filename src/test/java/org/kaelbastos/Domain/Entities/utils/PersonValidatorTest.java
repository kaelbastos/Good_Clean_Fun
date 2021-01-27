package org.kaelbastos.Domain.Entities.utils;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.*;

class PersonValidatorTest {
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

    Person person = new Person(cpf, name, telephone, email, address);
    PersonValidator personValidator = new PersonValidator();

    @Test
    void validateNullPerson() {
        Notification notification = personValidator.validate(null);
        assertTrue(notification.hasErrors());
    }

    @Test
    void validateWithoutErrors() {
        Notification notification = personValidator.validate(person);
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
        Person person1 = new Person(cpfTest, name, telephone, email, address);
        Notification notification = personValidator.validate(person1);
        assertTrue(notification.hasErrors());
        assertTrue(notification.getMessage().contains("CPF"));
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {
            "",
            " "})
    void validateWithNameError(String nameTest) {
        Person person1 = new Person(cpf, nameTest, telephone, email, address);
        Notification notification = personValidator.validate(person1);
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
        person.setEmail(emailTest);
        Notification notification = personValidator.validate(person);
        assertTrue(notification.hasErrors());
        assertTrue(notification.getMessage().contains("Email"));
    }

    @ParameterizedTest
    @MethodSource("provideStringsForMultipleErrorsTest")
    public void validateWithMultipleErrors(
            String cpf,
            String name,
            String telephone,
            String email,
            Address address) {
        Person person = new Person(cpf, name, telephone, email, address);
        Notification notification = personValidator.validate(person);
        assertTrue(notification.hasErrors());
        assertTrue(notification.getMessage().split(Notification.getDelimiter()).length > 1);
    }
    private static Stream<Arguments> provideStringsForMultipleErrorsTest() {
        return Stream.of(
                Arguments.of("000000000000", "name", "0", "test@test.com", new Address("street", "neighborhood", "city", "State", null, "0", null)),
                Arguments.of("", "", "", "@test.com", new Address("", "neighborhood", "city", "State", null, "0", null)),
                Arguments.of(null, "name", "0000000000", "test@test", new Address("street", "neighborhood", "city", "State", null, "0", null)),
                Arguments.of("000-000-000/00", "name", "00000000000", "test@test.com", null),
                Arguments.of("00000000000", "name", "00000000000", "test@test.com", new Address("", null, "", "State", null, "0", null)),
                Arguments.of("000.000.000/00", "name", "(00)00000-0000", "test@test.com", new Address("street", "neighborhood", "city", "State", null, "0", null)),
                Arguments.of("", "", "", "", new Address("", "", "", "", "", "", "")),
                Arguments.of(" ", " ", " ", " ", new Address(" ", " ", " ", " ", " ", " ", " ")),
                Arguments.of(null, null, null, null, null)
        );
    }

    @Test
    void CheckPhoneFormat() {
        assertTrue(personValidator.checkPhoneFormat("00000000000"));
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {
            "1111111111",
            "(11)11111-1111",
            "a1111111111",
            " ",
            ""})
    public void checkUnformattedPhones(String string) {
        assertFalse(personValidator.checkPhoneFormat(string));
    }

    @Test
    void checkEmailFormat() {
        assertTrue(personValidator.checkEmailFormat("test@test.com"));
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
    public void checkUnformattedEmails(String string) {
        assertFalse(personValidator.checkEmailFormat(string));
    }

    @Test
    void CheckCPFFormat() {
        assertTrue(personValidator.checkCPFFormat("00000000000"));
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
    public void checkUnformattedCPFs(String string) {
        assertFalse(personValidator.checkCPFFormat(string));
    }
}