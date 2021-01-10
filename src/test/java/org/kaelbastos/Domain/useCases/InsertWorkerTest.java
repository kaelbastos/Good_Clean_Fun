package org.kaelbastos.Domain.UseCases;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.kaelbastos.Domain.Entities.Worker.Worker;
import org.kaelbastos.Domain.Entities.utils.Address;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class InsertWorkerTest {

    InsertWorker insertWorker = new InsertWorker();

    @ParameterizedTest
    @MethodSource("provideArgsForInsertWorkerTrueReturn")
    public void insertWorkerTrueReturn(Worker worker) {
        assertTrue(insertWorker.insert(worker));
    }

    private static Stream<Arguments> provideArgsForInsertWorkerTrueReturn() {
        return Stream.of(
                Arguments.of(new Worker(
                        "12345678911",
                        "Person Test",
                        "00000000000",
                        "11111111111",
                        "test@test.com",
                        new Address(
                                "street",
                                "neighborhood",
                                "city",
                                "State",
                                "00",
                                "0",
                                null)
                        )
                )
        );
    }

    @ParameterizedTest
    @MethodSource("provideArgsForInsertWorkerWithExceptionThrow")
    public void insertWorkerExceptionThrow(Worker worker) {
        assertThrows(IllegalArgumentException.class, () -> {insertWorker.insert(worker);});
    }


    private static Stream<Arguments> provideArgsForInsertWorkerWithExceptionThrow() {
        return Stream.of(
                Arguments.of(new Worker(
                        "12345678910",
                        "Person Test",
                        "000000000",
                        "11111111111",
                        "test@test.com",
                        new Address(
                                "street",
                                "neighborhood",
                                "city",
                                "State",
                                "00",
                                "0",
                                null)
                        ),
                        new Worker(
                                "12345678",
                                "Person Test",
                                "00000000000",
                                "11111111111",
                                "test@test.com",
                                new Address(
                                        "street",
                                        "neighborhood",
                                        "city",
                                        "State",
                                        "00",
                                        "0",
                                        null)
                        ),
                        new Worker(
                                "12345678910",
                                "",
                                "00000000000",
                                "11111111111",
                                "test@test.com",
                                new Address(
                                        "street",
                                        "neighborhood",
                                        "city",
                                        "State",
                                        "00",
                                        "0",
                                        null)
                        ),
                        new Worker(
                                "12345678910",
                                "Person Test",
                                "00000000000",
                                "11111111111",
                                "test@test",
                                new Address(
                                        "street",
                                        "neighborhood",
                                        "city",
                                        "State",
                                        "00",
                                        "0",
                                        null)
                        ),
                        new Worker(
                                "12345678910",
                                "Person Test",
                                "00000000000",
                                "11111111",
                                "test@test.com",
                                new Address(
                                        "street",
                                        "neighborhood",
                                        "city",
                                        "State",
                                        "00",
                                        "0",
                                        null)
                        ),
                        new Worker(
                                "",
                                "",
                                "",
                                "",
                                "",
                                new Address(
                                        "street",
                                        "neighborhood",
                                        "city",
                                        "State",
                                        "00",
                                        "0",
                                        null)
                        ),
                        new Worker(
                                " ",
                                " ",
                                " ",
                                " ",
                                " ",
                                new Address(
                                        "street",
                                        "neighborhood",
                                        "city",
                                        "State",
                                        "00",
                                        "0",
                                        null)
                        ),
                        new Worker(
                                null,
                                null,
                                null,
                                null,
                                null,
                                new Address(
                                        "street",
                                        "neighborhood",
                                        "city",
                                        "State",
                                        "00",
                                        "0",
                                        null)
                        ),
                        new Worker(
                                "12345678910",
                                "Person Test",
                                "00000000000",
                                "11111111111",
                                "test@test.com",
                                new Address(
                                        "",
                                        "neighborhood",
                                        "city",
                                        "State",
                                        "00",
                                        "0",
                                        null)
                        ),
                        new Worker(
                                "12345678910",
                                "Person Test",
                                "00000000000",
                                "11111111111",
                                "test@test.com",
                                new Address(
                                        "street",
                                        "neighborhood",
                                        "city",
                                        "",
                                        "00",
                                        "0",
                                        null)
                        ),
                        new Worker(
                                "12345678910",
                                "Person Test",
                                "00000000000",
                                "11111111111",
                                "test@test.com",
                                new Address(
                                        "street",
                                        "neighborhood",
                                        "city",
                                        "State",
                                        "",
                                        "0",
                                        null)
                        ),
                        new Worker(
                                "12345678910",
                                "Person Test",
                                "00000000000",
                                "11111111111",
                                "test@test.com",
                                null
                        ),
                        new Worker(
                                null,
                                null,
                                null,
                                null,
                                null,
                                null
                        ),
                        new Worker(
                                "      ",
                                "       ",
                                "   ",
                                "    ",
                                "    ",
                                new Address(
                                        "     ",
                                        "    ",
                                        "    ",
                                        "   ",
                                        "    ",
                                        " ",
                                        null)
                        ),
                        new Worker(
                                "    /  ",
                                "   /    ",
                                "   /",
                                "  /  ",
                                " /   ",
                                new Address(
                                        "   .  ",
                                        ".    ",
                                        "   . ",
                                        " . ",
                                        "  .  ",
                                        ". ",
                                        null)
                        )

                )
        );
    }

    @Test
    void saveWorkerWithSameCPF() {
        Worker worker1 = new Worker(
                "12345678910",
                "Person Test",
                "00000000000",
                "11111111111",
                "test@test.com",
                new Address(
                        "street",
                        "neighborhood",
                        "city",
                        "State",
                        "00",
                        "0",
                        null)
        );
        assertTrue(insertWorker.insert(worker1));
        assertThrows(IllegalArgumentException.class, () -> {insertWorker.insert(worker1);});
    }
}