package org.kaelbastos.Domain.useCases;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullSource;
import org.kaelbastos.Domain.Entities.Client.Client;
import org.kaelbastos.Domain.Entities.Client.ResidenceType;
import org.kaelbastos.Domain.Entities.utils.Address;
import org.kaelbastos.Domain.UseCases.InsertClient;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class InsertClientTest {
    InsertClient insertClient = new InsertClient();

    @ParameterizedTest
    @MethodSource("provideArgsForInsertClientTrueReturn")
    public void insertClientTrueReturn(Client client) {
        assertTrue(insertClient.insert(client));
    }

    private static Stream<Arguments> provideArgsForInsertClientTrueReturn() {
        return Stream.of(
                Arguments.of(new Client(
                        "00000000000",
                        "Name",
                        "00000000000",
                        "client@client.com",
                        new Address("rua dos bobos",
                                "neighborhood",
                                "city",
                                "state",
                                "0",
                                "2",
                                null),
                        ResidenceType.House)),
                Arguments.of(new Client(
                        "00000000002",
                        "Name",
                        "00000000000",
                        "client@client.com",
                        new Address("rua dos bobos",
                                "neighborhood",
                                "city",
                                "state",
                                "0",
                                "2",
                                "complement"),
                        ResidenceType.House)));
    }

    @ParameterizedTest
    @NullSource
    @MethodSource("provideArgsForMultipleErrorsTest")
    public void validateWithMultipleErrors(Client client) {
        assertThrows(IllegalArgumentException.class, () -> {
           insertClient.insert(client);
        });
    }

    private static Stream<Arguments> provideArgsForMultipleErrorsTest() {
        return Stream.of(
                Arguments.of(new Client(
                        "00000000000",
                        null,
                        "00000000000",
                        "client@client.com",
                        new Address("rua dos bobos",
                                "neighborhood",
                                " ",
                                "state",
                                "0",
                                "2",
                                "complement"),
                        ResidenceType.House)),
                Arguments.of(new Client(
                        null,
                        null,
                        null,
                        null,
                        new Address(null,
                                null,
                                null,
                                null,
                                null,
                                null,
                                null),
                        ResidenceType.House)));

    }
}