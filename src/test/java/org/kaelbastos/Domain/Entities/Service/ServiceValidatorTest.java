package org.kaelbastos.Domain.Entities.Service;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullSource;
import org.kaelbastos.Domain.Entities.Client.Client;
import org.kaelbastos.Domain.Entities.Client.ResidenceType;
import org.kaelbastos.Domain.Entities.Product.Product;
import org.kaelbastos.Domain.Entities.Product.ProductCategory;
import org.kaelbastos.Domain.Entities.Worker.Worker;
import org.kaelbastos.Domain.Entities.utils.Address;
import org.kaelbastos.Domain.Entities.utils.Notification;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
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
                        100F,
                        50,
                        ServiceStatus.Scheduled ,
                        new ServiceCategory(0 , "name", 1.5),
                        new Client("00000000000", "Name", "00000000000", "client@client.com", new Address("rua dos bobos", "neighborhood", "city", "state", "0", "2", null), ResidenceType.House),
                        new ArrayList<>(List.of(new Product(1, "broom", 10F, ProductCategory.Utensil))),
                        new ArrayList<>(List.of(new Worker("00000000000", "Name", "00000000000", "11111111111","client@client.com", new Address("rua dos bobos", "neighborhood", "city", "state", "0", "2", null)))))),
                Arguments.of(new Service(
                        1,
                        null,
                        100F,
                        50,
                        ServiceStatus.Scheduled ,
                        new ServiceCategory(0 , "name", 1.5),
                        new Client("00000000000", "Name", "00000000000", "client@client.com", new Address("rua dos bobos", "neighborhood", "city", "state", "0", "2", null), ResidenceType.House),
                        new ArrayList<>(List.of(new Product(1, "broom", 10F, ProductCategory.Utensil))),
                        new ArrayList<>(List.of(new Worker("00000000000", "Name", "00000000000", "11111111111","client@client.com", new Address("rua dos bobos", "neighborhood", "city", "state", "0", "2", null)))))),
                Arguments.of(new Service(
                        1,
                        LocalDateTime.of(2021, 1, 6, 22 , 14),
                        -100F,
                        50,
                        ServiceStatus.Scheduled ,
                        new ServiceCategory(0 , "name", 1.5),
                        new Client("00000000000", "Name", "00000000000", "client@client.com", new Address("rua dos bobos", "neighborhood", "city", "state", "0", "2", null), ResidenceType.House),
                        new ArrayList<>(List.of(new Product(1, "broom", 10F, ProductCategory.Utensil))),
                        new ArrayList<>(List.of(new Worker("00000000000", "Name", "00000000000", "11111111111","client@client.com", new Address("rua dos bobos", "neighborhood", "city", "state", "0", "2", null)))))),
                Arguments.of(new Service(
                        1,
                        LocalDateTime.of(2021, 1, 6, 22 , 14),
                        100F,
                        150,
                        ServiceStatus.Scheduled ,
                        new ServiceCategory(0 , "name", 1.5),
                        new Client("00000000000", "Name", "00000000000", "client@client.com", new Address("rua dos bobos", "neighborhood", "city", "state", "0", "2", null), ResidenceType.House),
                        new ArrayList<>(List.of(new Product(1, "broom", 10F, ProductCategory.Utensil))),
                        new ArrayList<>(List.of(new Worker("00000000000", "Name", "00000000000", "11111111111","client@client.com", new Address("rua dos bobos", "neighborhood", "city", "state", "0", "2", null)))))),
                Arguments.of(new Service(
                        1,
                        LocalDateTime.of(2021, 1, 6, 22 , 14),
                        100F,
                        50,
                        null ,
                        new ServiceCategory(0 , "name", 1.5),
                        new Client("00000000000", "Name", "00000000000", "client@client.com", new Address("rua dos bobos", "neighborhood", "city", "state", "0", "2", null), ResidenceType.House),
                        new ArrayList<>(List.of(new Product(1, "broom", 10F, ProductCategory.Utensil))),
                        new ArrayList<>(List.of(new Worker("00000000000", "Name", "00000000000", "11111111111","client@client.com", new Address("rua dos bobos", "neighborhood", "city", "state", "0", "2", null)))))),
                Arguments.of(new Service(
                        1,
                        LocalDateTime.of(2021, 1, 6, 22 , 14),
                        100F,
                        50,
                        ServiceStatus.Scheduled ,
                        new ServiceCategory(-1 , "name", 1.5),
                        new Client("00000000000", "Name", "00000000000", "client@client.com", new Address("rua dos bobos", "neighborhood", "city", "state", "0", "2", null), ResidenceType.House),
                        new ArrayList<>(List.of(new Product(1, "broom", 10F, ProductCategory.Utensil))),
                        new ArrayList<>(List.of(new Worker("00000000000", "Name", "00000000000", "11111111111","client@client.com", new Address("rua dos bobos", "neighborhood", "city", "state", "0", "2", null)))))),
                Arguments.of(new Service(
                        1,
                        LocalDateTime.of(2021, 1, 6, 22 , 14),
                        100F,
                        50,
                        ServiceStatus.Scheduled ,
                        new ServiceCategory(0 , "", 1.5),
                        new Client("00000000000", "Name", "00000000000", "client@client.com", new Address("rua dos bobos", "neighborhood", "city", "state", "0", "2", null), ResidenceType.House),
                        new ArrayList<>(List.of(new Product(1, "broom", 10F, ProductCategory.Utensil))),
                        new ArrayList<>(List.of(new Worker("00000000000", "Name", "00000000000", "11111111111","client@client.com", new Address("rua dos bobos", "neighborhood", "city", "state", "0", "2", null)))))),
                Arguments.of(new Service(
                        1,
                        LocalDateTime.of(2021, 1, 6, 22 , 14),
                        100F,
                        50,
                        ServiceStatus.Scheduled ,
                        new ServiceCategory(0 , "name", 0),
                        new Client("00000000000", "Name", "00000000000", "client@client.com", new Address("rua dos bobos", "neighborhood", "city", "state", "0", "2", null), ResidenceType.House),
                        new ArrayList<>(List.of(new Product(1, "broom", 10F, ProductCategory.Utensil))),
                        new ArrayList<>(List.of(new Worker("00000000000", "Name", "00000000000", "11111111111","client@client.com", new Address("rua dos bobos", "neighborhood", "city", "state", "0", "2", null)))))),
                Arguments.of(new Service(
                        1,
                        LocalDateTime.of(2021, 1, 6, 22 , 14),
                        100F,
                        50,
                        ServiceStatus.Scheduled ,
                        new ServiceCategory(0 , "name", 1.5),
                        new Client("000/000/000-00", "Name", "00000000000", "client@client.com", new Address("rua dos bobos", "neighborhood", "city", "state", "0", "2", null), ResidenceType.House),
                        new ArrayList<>(List.of(new Product(1, "broom", 10F, ProductCategory.Utensil))),
                        new ArrayList<>(List.of(new Worker("00000000000", "Name", "00000000000", "11111111111","client@client.com", new Address("rua dos bobos", "neighborhood", "city", "state", "0", "2", null)))))),
                Arguments.of(new Service(
                        1,
                        LocalDateTime.of(2021, 1, 6, 22 , 14),
                        100F,
                        50,
                        ServiceStatus.Scheduled ,
                        new ServiceCategory(0 , "name", 1.5),
                        new Client("00000000000", "  ", "00000000000", "client@client.com", new Address("rua dos bobos", "neighborhood", "city", "state", "0", "2", null), ResidenceType.House),
                        new ArrayList<>(List.of(new Product(1, "broom", 10F, ProductCategory.Utensil))),
                        new ArrayList<>(List.of(new Worker("00000000000", "Name", "00000000000", "11111111111","client@client.com", new Address("rua dos bobos", "neighborhood", "city", "state", "0", "2", null)))))),
                Arguments.of(new Service(
                        1,
                        LocalDateTime.of(2021, 1, 6, 22 , 14),
                        100F,
                        50,
                        ServiceStatus.Scheduled ,
                        new ServiceCategory(0 , "name", 1.5),
                        new Client("00000000000", "Name", "(00)00000-0000", "client@client.com", new Address("rua dos bobos", "neighborhood", "city", "state", "0", "2", null), ResidenceType.House),
                        new ArrayList<>(List.of(new Product(1, "broom", 10F, ProductCategory.Utensil))),
                        new ArrayList<>(List.of(new Worker("00000000000", "Name", "00000000000", "11111111111","client@client.com", new Address("rua dos bobos", "neighborhood", "city", "state", "0", "2", null)))))),
                Arguments.of(new Service(
                        1,
                        LocalDateTime.of(2021, 1, 6, 22 , 14),
                        100F,
                        50,
                        ServiceStatus.Scheduled ,
                        new ServiceCategory(0 , "name", 1.5),
                        new Client("00000000000", "Name", "00000000000", "@client.com", new Address("rua dos bobos", "neighborhood", "city", "state", "0", "2", null), ResidenceType.House),
                        new ArrayList<>(List.of(new Product(1, "broom", 10F, ProductCategory.Utensil))),
                        new ArrayList<>(List.of(new Worker("00000000000", "Name", "00000000000", "11111111111","client@client.com", new Address("rua dos bobos", "neighborhood", "city", "state", "0", "2", null)))))),
                Arguments.of(new Service(
                        1,
                        LocalDateTime.of(2021, 1, 6, 22 , 14),
                        100F,
                        50,
                        ServiceStatus.Scheduled ,
                        new ServiceCategory(0 , "name", 1.5),
                        new Client("00000000000", "Name", "00000000000", "client@client.com", new Address("  ", "neighborhood", "city", "state", "0", "2", null), ResidenceType.House),
                        new ArrayList<>(List.of(new Product(1, "broom", 10F, ProductCategory.Utensil))),
                        new ArrayList<>(List.of(new Worker("00000000000", "Name", "00000000000", "11111111111","client@client.com", new Address("rua dos bobos", "neighborhood", "city", "state", "0", "2", null)))))),
                Arguments.of(new Service(
                        1,
                        LocalDateTime.of(2021, 1, 6, 22 , 14),
                        100F,
                        50,
                        ServiceStatus.Scheduled ,
                        new ServiceCategory(0 , "name", 1.5),
                        new Client("00000000000", "Name", "00000000000", "client@client.com", new Address("rua dos bobos", "neighborhood", "city", "state", "0", "2", null), ResidenceType.House),
                        new ArrayList<>(List.of(new Product(-1, "broom", 10F, ProductCategory.Utensil))),
                        new ArrayList<>(List.of(new Worker("00000000000", "Name", "00000000000", "11111111111","client@client.com", new Address("rua dos bobos", "neighborhood", "city", "state", "0", "2", null)))))),
                Arguments.of(new Service(
                        1,
                        LocalDateTime.of(2021, 1, 6, 22 , 14),
                        100F,
                        50,
                        ServiceStatus.Scheduled ,
                        new ServiceCategory(0 , "name", 1.5),
                        new Client("00000000000", "Name", "00000000000", "client@client.com", new Address("rua dos bobos", "neighborhood", "city", "state", "0", "2", null), ResidenceType.House),
                        new ArrayList<>(List.of(new Product(1, null, 10F, ProductCategory.Utensil))),
                        new ArrayList<>(List.of(new Worker("00000000000", "Name", "00000000000", "11111111111","client@client.com", new Address("rua dos bobos", "neighborhood", "city", "state", "0", "2", null)))))),
                Arguments.of(new Service(
                        1,
                        LocalDateTime.of(2021, 1, 6, 22 , 14),
                        100F,
                        50,
                        ServiceStatus.Scheduled ,
                        new ServiceCategory(0 , "name", 1.5),
                        new Client("00000000000", "Name", "00000000000", "client@client.com", new Address("rua dos bobos", "neighborhood", "city", "state", "0", "2", null), ResidenceType.House),
                        new ArrayList<>(List.of(new Product(1, "broom", -10F, ProductCategory.Utensil))),
                        new ArrayList<>(List.of(new Worker("00000000000", "Name", "00000000000", "11111111111","client@client.com", new Address("rua dos bobos", "neighborhood", "city", "state", "0", "2", null)))))),
                Arguments.of(new Service(
                        1,
                        LocalDateTime.of(2021, 1, 6, 22 , 14),
                        100F,
                        50,
                        ServiceStatus.Scheduled ,
                        new ServiceCategory(0 , "name", 1.5),
                        new Client("00000000000", "Name", "00000000000", "client@client.com", new Address("rua dos bobos", "neighborhood", "city", "state", "0", "2", null), ResidenceType.House),
                        new ArrayList<>(List.of(new Product(1, "broom", 10F, null))),
                        new ArrayList<>(List.of(new Worker("00000000000", "Name", "00000000000", "11111111111","client@client.com", new Address("rua dos bobos", "neighborhood", "city", "state", "0", "2", null)))))),
                Arguments.of(new Service(
                        1,
                        LocalDateTime.of(2021, 1, 6, 22 , 14),
                        100F,
                        50,
                        ServiceStatus.Scheduled ,
                        new ServiceCategory(0 , "name", 1.5),
                        new Client("00000000000", "Name", "00000000000", "client@client.com", new Address("rua dos bobos", "neighborhood", "city", "state", "0", "2", null), ResidenceType.House),
                        new ArrayList<>(List.of(new Product(1, "broom", 10F, ProductCategory.Utensil))),
                        new ArrayList<>(List.of(new Worker("0", "Name", "00000000000", "11111111111","client@client.com", new Address("rua dos bobos", "neighborhood", "city", "state", "0", "2", null)))))),
                Arguments.of(new Service(
                        -1,
                        LocalDateTime.of(2021, 1, 6, 22 , 14),
                        100F,
                        50,
                        ServiceStatus.Scheduled ,
                        new ServiceCategory(0 , "name", 1.5),
                        new Client("00000000000", "Name", "00000000000", "client@client.com", new Address("rua dos bobos", "neighborhood", "city", "state", "0", "2", null), ResidenceType.House),
                        new ArrayList<>(List.of(new Product(1, "broom", 10F, ProductCategory.Utensil))),
                        new ArrayList<>(List.of(new Worker("00000000000", "Name", "00000000000", "11111111111","client@client.com", new Address("rua dos bobos", "neighborhood", "city", "state", "0", "2", null))))))
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
                        LocalDateTime.of(2021, 1, 6, 22 , 14),
                        100F,
                        50,
                        ServiceStatus.Scheduled ,
                        new ServiceCategory(0 , "", 1.5),
                        new Client("00000000000", "Name", "00000000000", "client@client.com", new Address("rua dos bobos", "neighborhood", "city", "state", "0", "2", null), ResidenceType.House),
                        new ArrayList<>(List.of(new Product(1, "broom", 10F, ProductCategory.Utensil))),
                        new ArrayList<>(List.of(new Worker("00000000000", "Name", "0-0000000000", "11111111111","client@client.com", new Address("rua dos bobos", "neighborhood", "city", "state", "0", "2", null)))))),
                Arguments.of(new Service(
                        1,
                        LocalDateTime.of(2021, 1, 6, 22 , 14),
                        100F,
                        250,
                        ServiceStatus.Scheduled ,
                        new ServiceCategory(0 , "name", 5.),
                        new Client("00000000000", "Name", "00000000000", "client@client.com", new Address("rua dos bobos", "neighborhood", "city", "state", "0", "2", null), ResidenceType.House),
                        new ArrayList<>(List.of(new Product(-1, "broom", 10F, ProductCategory.Utensil))),
                        new ArrayList<>(List.of(new Worker("00000000000", "Name", "00000000000", "11111111111","client@client.com", new Address("rua dos bobos", "neighborhood", "city", "state", "0", "2", null)))))),
                Arguments.of(new Service(
                        1,
                        LocalDateTime.of(2021, 1, 6, 22 , 14),
                        100F,
                        50,
                        ServiceStatus.Scheduled ,
                        new ServiceCategory(0 , "name", 1.5),
                        new Client("00000000000", "Name", "00000000000", "client@client,com", new Address("rua dos bobos", "neighborhood", "city", "state", "0", "2", null), ResidenceType.House),
                        new ArrayList<>(),
                        new ArrayList<>()))
                );
    }

    @ParameterizedTest
    @MethodSource("serviceEvaluationWithErrorProvider")
    void validateWithServiceEvaluationError(ServiceEvaluation serviceEvaluation) {
        Service service = new Service(
                01,
                LocalDateTime.of(1999, 1, 6, 22 , 14),
                100F,
                50,
                ServiceStatus.Scheduled ,
                new ServiceCategory(0, "name", 1.0),
                new Client("11111111111", "Name", "00000000000", "client@client.com", new Address("rua dos bobos", "neighborhood", "city", "state", "0", "2", null), ResidenceType.House),
                new ArrayList<>(List.of(new Product(1, "broom", 10F, ProductCategory.Utensil))),
                new ArrayList<>(List.of(new Worker("00000000000", "Name", "00000000000", "111111-11111","client@client.com", new Address("rua dos bobos", "neighborhood", "city", "state", "0", "2", null)))));

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