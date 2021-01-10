package org.kaelbastos.Domain.entities.Worker;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.kaelbastos.Domain.entities.utils.Address;
import org.kaelbastos.Domain.entities.utils.Notification;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class WorkerValidatorTest {
    String cpf = "00000000000";
    String name = "Person Test";
    String telephone = "00000000000";
    String secondaryTelephone = "11111111111";
    String email = "test@test.com";
    Address address = new Address(
            "street",
            "neighborhood",
            "city",
            "State",
            "00",
            "0",
            null);

    Worker worker = new Worker(cpf, name, telephone, secondaryTelephone, email, address);
    WorkerValidator workerValidator = new WorkerValidator();

    @Test
    void validateNullWorkerWithError() {
        Notification notification = workerValidator.validate(null);
        assertTrue(notification.hasErrors());
    }

    @Test
    void validateWithoutErrors() {
        Notification notification = workerValidator.validate(worker);
        assertTrue(notification.isCorrect());
    }

    @ParameterizedTest
    @MethodSource("provideStringsForMultipleErrorsTest")
    public void validateWithMultipleErrors(
            String cpf,
            String name,
            String telephone,
            String secondaryTelephone,
            String email,
            Address address) {
        Worker worker = new Worker(cpf, name, telephone, secondaryTelephone, email, address);
        Notification notification = workerValidator.validate(worker);
        assertTrue(notification.hasErrors());
        assertTrue(notification.getMessage().split(";").length > 1);
    }

    private static Stream<Arguments> provideStringsForMultipleErrorsTest() {
        return Stream.of(
                Arguments.of("00000000000", "Mario Almeida", "0", "0", "test@test.com", new Address("street", "neighborhood", "city", "State", null, "0", null)),
                Arguments.of("", "", "", "", "@test.com", new Address("", "neighborhood", "city", "State", null, "0", null)),
                Arguments.of(null, "name", "0000000000", "0000000000", "@test.com", new Address("", "neighborhood", "city", "State", null, "0", null)),
                Arguments.of("000-000-000/00", "name", "00000000000", "00000000000","test@test.com", null),
                Arguments.of("00000000000", "name", "00000000000", "00000000000", "test@test.com", new Address("", null, "", "State", null, "0", null)),
                Arguments.of("000.000.000/00", "name", "(00)00000-0000", "(00)00000-0000", "test@test.com", new Address("street", "neighborhood", "city", "State", null, "0", null)),
                Arguments.of("", "", "", "", "", new Address("", "", "", "", "", "", "")),
                Arguments.of(" ", " ", " ", " ", " ", new Address(" ", " ", " ", " ", " ", " ", " ")),
                Arguments.of(null, null, null, null, null, null)
        );
    }
}