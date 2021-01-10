package org.kaelbastos.Domain.entities.Service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullSource;
import org.kaelbastos.Domain.entities.Client.Client;
import org.kaelbastos.Domain.entities.Client.ResidenceType;
import org.kaelbastos.Domain.entities.Product.Product;
import org.kaelbastos.Domain.entities.Product.ProductCategory;
import org.kaelbastos.Domain.entities.Worker.Worker;
import org.kaelbastos.Domain.entities.utils.Address;
import org.kaelbastos.Domain.entities.utils.Notification;

import java.time.LocalDateTime;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class ServiceValidatorTest {

    ServiceValidator serviceValidator = new ServiceValidator();

    @ParameterizedTest
    @NullSource
    @MethodSource("provideArgsForSingleErrorTest")
    public void singleErrorTest(Service service) {
        Notification notification = serviceValidator.validate(service);
        assertTrue(notification.hasErrors());
        assertTrue(notification.getMessage().split(";").length == 1);
    }

    private static Stream<Arguments> provideArgsForSingleErrorTest() {
        return Stream.of(
                Arguments.of(new Service(
                        -1,
                        LocalDateTime.of(2021, 1, 6, 22 , 14),
                        LocalDateTime.of(2021, 1, 6, 22 , 24),
                        100F,
                        50,
                        ServiceStatus.Scheduled ,
                        ServiceCategory.kitchenCleansing,
                        new Client("00000000000", "Name", "00000000000", "client@client.com", new Address("rua dos bobos", "neighborhood", "city", "state", "0", "2", null), ResidenceType.House),
                        new Product(1, "broom", 10F, ProductCategory.Utensil),
                        new Worker("00000000000", "Name", "00000000000", "11111111111","client@client.com", new Address("rua dos bobos", "neighborhood", "city", "state", "0", "2", null)))),
                Arguments.of(new Service(
                        0,
                        LocalDateTime.of(2021, 1, 6, 22 , 14),
                        LocalDateTime.of(2020, 1, 6, 22 , 24),
                        100F,
                        50,
                        ServiceStatus.Scheduled ,
                        ServiceCategory.kitchenCleansing,
                        new Client("00000000000", "Name", "00000000000", "client@client.com", new Address("rua dos bobos", "neighborhood", "city", "state", "0", "2", null), ResidenceType.House),
                        new Product(1, "broom", 10F, ProductCategory.Utensil),
                        new Worker("00000000000", "Name", "00000000000", "11111111111","client@client.com", new Address("rua dos bobos", "neighborhood", "city", "state", "0", "2", null)))),
                Arguments.of(new Service(
                        0,
                        LocalDateTime.of(2021, 1, 6, 22 , 14),
                        LocalDateTime.of(2021, 1, 6, 22 , 14),
                        100F,
                        50,
                        ServiceStatus.Scheduled ,
                        ServiceCategory.kitchenCleansing,
                        new Client("00000000000", "Name", "00000000000", "client@client.com", new Address("rua dos bobos", "neighborhood", "city", "state", "0", "2", null), ResidenceType.House),
                        new Product(1, "broom", 10F, ProductCategory.Utensil),
                        new Worker("00000000000", "Name", "00000000000", "11111111111","client@client.com", new Address("rua dos bobos", "neighborhood", "city", "state", "0", "2", null)))),
                Arguments.of(new Service(
                        0,
                        LocalDateTime.of(2021, 1, 6, 22 , 14),
                        LocalDateTime.of(2021, 1, 6, 22 , 24),
                        -100F,
                        50,
                        ServiceStatus.Scheduled ,
                        ServiceCategory.kitchenCleansing,
                        new Client("00000000000", "Name", "00000000000", "client@client.com", new Address("rua dos bobos", "neighborhood", "city", "state", "0", "2", null), ResidenceType.House),
                        new Product(1, "broom", 10F, ProductCategory.Utensil),
                        new Worker("00000000000", "Name", "00000000000", "11111111111","client@client.com", new Address("rua dos bobos", "neighborhood", "city", "state", "0", "2", null)))),
                Arguments.of(new Service(
                        0,
                        LocalDateTime.of(2021, 1, 6, 22 , 14),
                        LocalDateTime.of(2021, 1, 6, 22 , 24),
                        100F,
                        150,
                        ServiceStatus.Scheduled ,
                        ServiceCategory.kitchenCleansing,
                        new Client("00000000000", "Name", "00000000000", "client@client.com", new Address("rua dos bobos", "neighborhood", "city", "state", "0", "2", null), ResidenceType.House),
                        new Product(1, "broom", 10F, ProductCategory.Utensil),
                        new Worker("00000000000", "Name", "00000000000", "11111111111","client@client.com", new Address("rua dos bobos", "neighborhood", "city", "state", "0", "2", null)))),
                Arguments.of(new Service(
                        0,
                        LocalDateTime.of(2021, 1, 6, 22 , 14),
                        LocalDateTime.of(2021, 1, 6, 22 , 24),
                        100F,
                        50,
                        null ,
                        ServiceCategory.kitchenCleansing,
                        new Client("00000000000", "Name", "00000000000", "client@client.com", new Address("rua dos bobos", "neighborhood", "city", "state", "0", "2", null), ResidenceType.House),
                        new Product(1, "broom", 10F, ProductCategory.Utensil),
                        new Worker("00000000000", "Name", "00000000000", "11111111111","client@client.com", new Address("rua dos bobos", "neighborhood", "city", "state", "0", "2", null)))),
                Arguments.of(new Service(
                        0,
                        LocalDateTime.of(2021, 1, 6, 22 , 14),
                        LocalDateTime.of(2021, 1, 6, 22 , 24),
                        100F,
                        50,
                        ServiceStatus.Scheduled ,
                        null,
                        new Client("00000000000", "Name", "00000000000", "client@client.com", new Address("rua dos bobos", "neighborhood", "city", "state", "0", "2", null), ResidenceType.House),
                        new Product(1, "broom", 10F, ProductCategory.Utensil),
                        new Worker("00000000000", "Name", "00000000000", "11111111111","client@client.com", new Address("rua dos bobos", "neighborhood", "city", "state", "0", "2", null)))),
                Arguments.of(new Service(
                        0,
                        LocalDateTime.of(2021, 1, 6, 22 , 14),
                        LocalDateTime.of(2021, 1, 6, 22 , 24),
                        100F,
                        50,
                        ServiceStatus.Scheduled ,
                        ServiceCategory.kitchenCleansing,
                        new Client("0", "Name", "00000000000", "client@client.com", new Address("rua dos bobos", "neighborhood", "city", "state", "0", "2", null), ResidenceType.House),
                        new Product(1, "broom", 10F, ProductCategory.Utensil),
                        new Worker("00000000000", "Name", "00000000000", "11111111111","client@client.com", new Address("rua dos bobos", "neighborhood", "city", "state", "0", "2", null)))),
                Arguments.of(new Service(
                        0,
                        LocalDateTime.of(2021, 1, 6, 22 , 14),
                        LocalDateTime.of(2021, 1, 6, 22 , 24),
                        100F,
                        50,
                        ServiceStatus.Scheduled ,
                        ServiceCategory.kitchenCleansing,
                        new Client("00000000000", " ", "00000000000", "client@client.com", new Address("rua dos bobos", "neighborhood", "city", "state", "0", "2", null), ResidenceType.House),
                        new Product(1, "broom", 10F, ProductCategory.Utensil),
                        new Worker("00000000000", "Name", "00000000000", "11111111111","client@client.com", new Address("rua dos bobos", "neighborhood", "city", "state", "0", "2", null)))),
                Arguments.of(new Service(
                        0,
                        LocalDateTime.of(2021, 1, 6, 22 , 14),
                        LocalDateTime.of(2021, 1, 6, 22 , 24),
                        100F,
                        50,
                        ServiceStatus.Scheduled ,
                        ServiceCategory.kitchenCleansing,
                        new Client("00000000000", "Name", "(00)00000-0000", "client@client.com", new Address("rua dos bobos", "neighborhood", "city", "state", "0", "2", null), ResidenceType.House),
                        new Product(1, "broom", 10F, ProductCategory.Utensil),
                        new Worker("00000000000", "Name", "00000000000", "11111111111","client@client.com", new Address("rua dos bobos", "neighborhood", "city", "state", "0", "2", null)))),
                Arguments.of(new Service(
                        0,
                        LocalDateTime.of(2021, 1, 6, 22 , 14),
                        LocalDateTime.of(2021, 1, 6, 22 , 24),
                        100F,
                        50,
                        ServiceStatus.Scheduled ,
                        ServiceCategory.kitchenCleansing,
                        new Client("00000000000", "Name", "00000000000", "@client.com", new Address("rua dos bobos", "neighborhood", "city", "state", "0", "2", null), ResidenceType.House),
                        new Product(1, "broom", 10F, ProductCategory.Utensil),
                        new Worker("00000000000", "Name", "00000000000", "11111111111","client@client.com", new Address("rua dos bobos", "neighborhood", "city", "state", "0", "2", null)))),
                Arguments.of(new Service(
                        0,
                        LocalDateTime.of(2021, 1, 6, 22 , 14),
                        LocalDateTime.of(2021, 1, 6, 22 , 24),
                        100F,
                        50,
                        ServiceStatus.Scheduled ,
                        ServiceCategory.kitchenCleansing,
                        new Client("00000000000", "Name", "00000000000", "client@client.com", new Address("  ", "neighborhood", "city", "state", "0", "2", null), ResidenceType.House),
                        new Product(1, "broom", 10F, ProductCategory.Utensil),
                        new Worker("00000000000", "Name", "00000000000", "11111111111","client@client.com", new Address("rua dos bobos", "neighborhood", "city", "state", "0", "2", null)))),
                Arguments.of(new Service(
                        0,
                        LocalDateTime.of(2021, 1, 6, 22 , 14),
                        LocalDateTime.of(2021, 1, 6, 22 , 24),
                        100F,
                        50,
                        ServiceStatus.Scheduled ,
                        ServiceCategory.kitchenCleansing,
                        new Client("00000000000", "Name", "00000000000", "client@client.com", new Address("rua dos bobos", "neighborhood", "city", "state", "0", "2", null), null),
                        new Product(1, "broom", 10F, ProductCategory.Utensil),
                        new Worker("00000000000", "Name", "00000000000", "11111111111","client@client.com", new Address("rua dos bobos", "neighborhood", "city", "state", "0", "2", null)))),
                Arguments.of(new Service(
                        0,
                        LocalDateTime.of(2021, 1, 6, 22 , 14),
                        LocalDateTime.of(2021, 1, 6, 22 , 24),
                        100F,
                        50,
                        ServiceStatus.Scheduled ,
                        ServiceCategory.kitchenCleansing,
                        new Client("00000000000", "Name", "00000000000", "client@client.com", new Address("rua dos bobos", "neighborhood", "city", "state", "0", "2", null), ResidenceType.House),
                        new Product(-1, "broom" , 10F, ProductCategory.Utensil),
                        new Worker("00000000000", "Name", "00000000000", "11111111111","client@client.com", new Address("rua dos bobos", "neighborhood", "city", "state", "0", "2", null)))),
                Arguments.of(new Service(
                        0,
                        LocalDateTime.of(2021, 1, 6, 22 , 14),
                        LocalDateTime.of(2021, 1, 6, 22 , 24),
                        100F,
                        50,
                        ServiceStatus.Scheduled ,
                        ServiceCategory.kitchenCleansing,
                        new Client("00000000000", "Name", "00000000000", "client@client.com", new Address("rua dos bobos", "neighborhood", "city", "state", "0", "2", null), ResidenceType.House),
                        new Product(1, null, 10F, ProductCategory.Utensil),
                        new Worker("00000000000", "Name", "00000000000", "11111111111","client@client.com", new Address("rua dos bobos", "neighborhood", "city", "state", "0", "2", null)))),
                Arguments.of(new Service(
                        0,
                        LocalDateTime.of(2021, 1, 6, 22 , 14),
                        LocalDateTime.of(2021, 1, 6, 22 , 24),
                        100F,
                        50,
                        ServiceStatus.Scheduled ,
                        ServiceCategory.kitchenCleansing,
                        new Client("00000000000", "Name", "00000000000", "client@client.com", new Address("rua dos bobos", "neighborhood", "city", "state", "0", "2", null), ResidenceType.House),
                        new Product(1, "broom", -10F, ProductCategory.Utensil),
                        new Worker("00000000000", "Name", "00000000000", "11111111111","client@client.com", new Address("rua dos bobos", "neighborhood", "city", "state", "0", "2", null)))),
                Arguments.of(new Service(
                        0,
                        LocalDateTime.of(2021, 1, 6, 22 , 14),
                        LocalDateTime.of(2021, 1, 6, 22 , 24),
                        100F,
                        50,
                        ServiceStatus.Scheduled ,
                        ServiceCategory.kitchenCleansing,
                        new Client("00000000000", "Name", "00000000000", "client@client.com", new Address("rua dos bobos", "neighborhood", "city", "state", "0", "2", null), ResidenceType.House),
                        new Product(1, "broom", 10F, null),
                        new Worker("00000000000", "Name", "00000000000", "00000000000","client@client.com", new Address("rua dos bobos", "neighborhood", "city", "state", "0", "2", null)))),
                Arguments.of(new Service(
                        0,
                        LocalDateTime.of(2021, 1, 6, 22 , 14),
                        LocalDateTime.of(2021, 1, 6, 22 , 24),
                        100F,
                        50,
                        ServiceStatus.Scheduled ,
                        ServiceCategory.kitchenCleansing,
                        new Client("00000000000", "Name", "00000000000", "client@client.com", new Address("rua dos bobos", "neighborhood", "city", "state", "0", "2", null), ResidenceType.House),
                        new Product(1, "broom", 10F, ProductCategory.Utensil),
                        new Worker("000.000.000/00", "Name", "00000000000", "00000000000","client@client.com", new Address("rua dos bobos", "neighborhood", "city", "state", "0", "2", null)))),
                Arguments.of(new Service(
                        0,
                        LocalDateTime.of(2021, 1, 6, 22 , 14),
                        LocalDateTime.of(2021, 1, 6, 22 , 24),
                        100F,
                        50,
                        ServiceStatus.Scheduled ,
                        ServiceCategory.kitchenCleansing,
                        new Client("00000000000", "Name", "00000000000", "client@client.com", new Address("rua dos bobos", "neighborhood", "city", "state", "0", "2", null), ResidenceType.House),
                        new Product(1, "broom", 10F, ProductCategory.Utensil),
                        new Worker("00000000000", "     ", "00000000000", "11111111111","client@client.com", new Address("rua dos bobos", "neighborhood", "city", "state", "0", "2", null)))),
                Arguments.of(new Service(
                        0,
                        LocalDateTime.of(2021, 1, 6, 22 , 14),
                        LocalDateTime.of(2021, 1, 6, 22 , 24),
                        100F,
                        50,
                        ServiceStatus.Scheduled ,
                        ServiceCategory.kitchenCleansing,
                        new Client("00000000000", "Name", "00000000000", "client@client.com", new Address("rua dos bobos", "neighborhood", "city", "state", "0", "2", null), ResidenceType.House),
                        new Product(1, "broom", 10F, ProductCategory.Utensil),
                        new Worker("00000000000", "Name", "00000-0000", "11111111111","client@client.com", new Address("rua dos bobos", "neighborhood", "city", "state", "0", "2", null)))),
                Arguments.of(new Service(
                        0,
                        LocalDateTime.of(2021, 1, 6, 22 , 14),
                        LocalDateTime.of(2021, 1, 6, 22 , 24),
                        100F,
                        50,
                        ServiceStatus.Scheduled ,
                        ServiceCategory.kitchenCleansing,
                        new Client("00000000000", "Name", "00000000000", "client@client.com", new Address("rua dos bobos", "neighborhood", "city", "state", "0", "2", null), ResidenceType.House),
                        new Product(1, "broom", 10F, ProductCategory.Utensil),
                        new Worker("", "Name", "00000000000", "11111-1111","client@client.com", new Address("rua dos bobos", "neighborhood", "city", "state", "0", "2", null)))),
                Arguments.of(new Service(
                        0,
                        LocalDateTime.of(2021, 1, 6, 22 , 14),
                        LocalDateTime.of(2021, 1, 6, 22 , 24),
                        100F,
                        50,
                        ServiceStatus.Scheduled ,
                        ServiceCategory.kitchenCleansing,
                        new Client("00000000000", "Name", "00000000000", "client@client.com", new Address("rua dos bobos", "neighborhood", "city", "state", "0", "2", null), ResidenceType.House),
                        new Product(1, "broom", 10F, ProductCategory.Utensil),
                        new Worker("00000000000", "Name", "00000000000", "00000000000","client@.com", new Address("rua dos bobos", "neighborhood", "city", "state", "0", "2", null)))),
                Arguments.of(new Service(
                        0,
                        LocalDateTime.of(2021, 1, 6, 22 , 14),
                        LocalDateTime.of(2021, 1, 6, 22 , 24),
                        100F,
                        50,
                        ServiceStatus.Scheduled ,
                        ServiceCategory.kitchenCleansing,
                        new Client("00000000000", "Name", "00000000000", "client@client.com", new Address("rua dos bobos", "neighborhood", "city", "state", "0", "2", null), ResidenceType.House),
                        new Product(1, "broom", 10F, ProductCategory.Utensil),
                        new Worker("00000000000", "Name", "00000000000", "11111111111","client@client.com", new Address("rua dos bobos", "neighborhood", "        ", "state", "0", "2", null))))
        );
    }

    @ParameterizedTest
    @MethodSource("provideArgsForMultipleErrorsTest")
    public void validateWithMultipleErrors(Service service) {
        Notification notification = serviceValidator.validate(service);
        assertTrue(notification.hasErrors());
        assertTrue(notification.getMessage().split(";").length > 1);
    }

    private static Stream<Arguments> provideArgsForMultipleErrorsTest() {
        return Stream.of(
                Arguments.of(new Service(
                        -1,
                        LocalDateTime.of(1999, 1, 6, 22 , 14),
                        LocalDateTime.of(2021, 1, 6, 22 , 24),
                        100F,
                        50,
                        ServiceStatus.Scheduled ,
                        ServiceCategory.kitchenCleansing,
                        new Client("00000000000", "  ", "00000000000", "client@client.com", new Address("rua dos bobos", "neighborhood", "city", "state", "0", "2", null), ResidenceType.House),
                        new Product(1, "broom", 10F, ProductCategory.Utensil),
                        new Worker("00000000000", "Name", "00000000000", "111111-11111","client@client.com", new Address("rua dos bobos", "neighborhood", "city", "state", "0", "2", null)))),
                Arguments.of(new Service(
                        1,
                        LocalDateTime.of(2021, 1, 6, 22 , 24),
                        LocalDateTime.of(2021, 1, 6, 22 , 24),
                        100F,
                        0,
                        null ,
                        ServiceCategory.kitchenCleansing,
                        new Client("00000000000", "Name", "00000000000", "client@client.com", new Address("rua dos bobos", " ", "city", "state", "0", "2", null), ResidenceType.House),
                        new Product(1, "  ", 10F, ProductCategory.Utensil),
                        new Worker("00000000000", "Name", "00000000000", "11111111111","client@client.com", new Address("rua dos bobos", "neighborhood", "city", "state", "0", "2", null)))),
                Arguments.of(new Service(
                        1,
                        LocalDateTime.of(2021, 1, 6, 22 , 14),
                        LocalDateTime.of(2021, 1, 6, 22 , 24),
                        100F,
                        50,
                        ServiceStatus.Scheduled ,
                        ServiceCategory.kitchenCleansing,
                        new Client("00000000000", "Name", " ", "client@client.com", new Address("rua dos bobos", "neighborhood", "city", "state", "0", "2", null), ResidenceType.House),
                        new Product(1, "broom", -10F, ProductCategory.Utensil),
                        new Worker("00000000000", "", "00000000000", "11111111111","client@.com", new Address("rua dos bobos", "neighborhood", "city", "state", "0", "2", null)))),
                Arguments.of(new Service(
                        1,
                        LocalDateTime.of(2021, 1, 6, 22 , 14),
                        LocalDateTime.of(2021, 1, 6, 22 , 24),
                        100F,
                        50,
                        ServiceStatus.Scheduled ,
                        ServiceCategory.kitchenCleansing,
                        new Client("00000000000", "", "00000000000", null, new Address("rua dos bobos", "neighborhood", "city", "state", "0", "2", null), ResidenceType.House),
                        new Product(1, "broom", 10F, ProductCategory.Utensil),
                        new Worker("00000000000", "Name", "00000000000", "11111111111","client@client.com", new Address("rua dos bobos", "neighborhood", "city", "state", "0", "2", null)))),
                Arguments.of(new Service(
                        -1,
                        LocalDateTime.of(2021, 1, 6, 22 , 14),
                        LocalDateTime.of(2021, 1, 6, 22 , 24),
                        100F,
                        50,
                        ServiceStatus.Scheduled ,
                        ServiceCategory.kitchenCleansing,
                        new Client("00000000000", "Name", "00000000000", "client@client.com", new Address("rua dos bobos", "neighborhood", "city", "state", "0", "2", null), ResidenceType.House),
                        new Product(1, "broom", 10F, ProductCategory.Utensil),
                        new Worker("00000000000", "Name", "00000000000", "11111111111","client@client.com", new Address(" ", "neighborhood", "city", "state", "0", "2", null))))
                );
    }

    @ParameterizedTest
    @MethodSource("serviceEvaluationWithErrorProvider")
    void validateWithServiceEvaluationError(ServiceEvaluation serviceEvaluation) {
        Service service = new Service(
                01,
                LocalDateTime.of(1999, 1, 6, 22 , 14),
                LocalDateTime.of(2021, 1, 6, 22 , 24),
                100F,
                50,
                ServiceStatus.Scheduled ,
                ServiceCategory.kitchenCleansing,
                new Client("11111111111", "Name", "00000000000", "client@client.com", new Address("rua dos bobos", "neighborhood", "city", "state", "0", "2", null), ResidenceType.House),
                new Product(1, "broom", 10F, ProductCategory.Utensil),
                new Worker("00000000000", "Name", "00000000000", "111111-11111","client@client.com", new Address("rua dos bobos", "neighborhood", "city", "state", "0", "2", null)));

        service.setServiceEvaluation(serviceEvaluation);
        Notification notification = serviceValidator.validate(service);
        assertTrue(notification.hasErrors());
    }

    private static Stream<Arguments> serviceEvaluationWithErrorProvider(){
        Client client = new Client("00000000000", "Name", "00000000000", "client@client.com", null, ResidenceType.House);
        return Stream.of(
                Arguments.of(new ServiceEvaluation("comment", 5, null)),
                Arguments.of(new ServiceEvaluation("comment", -1, client))
        );
    }
}