package org.kaelbastos.Domain.useCases.WorkerUseCases;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.kaelbastos.Domain.Entities.Worker.Worker;
import org.kaelbastos.Domain.Entities.utils.Address;
import org.kaelbastos.Domain.UseCases.WorkerUseCases.AlterWorker;
import org.kaelbastos.Domain.UseCases.WorkerUseCases.InsertWorker;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class AlterWorkerTest {

    AlterWorker alterWorker = new AlterWorker();
    InsertWorker insertWorker = new InsertWorker();

    Worker workerDefault = new Worker(
            "12345678915",
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
                    null
            )
    );

    @ParameterizedTest
    @MethodSource("provideArgsForAlterWorkerTrueReturn")
    public void insertWorkerTrueReturn(Worker worker) {
        assertTrue(insertWorker.insert(workerDefault));
        assertTrue(alterWorker.alter(worker));
    }

    private static Stream<Arguments> provideArgsForAlterWorkerTrueReturn() {
        return Stream.of(
                Arguments.of(new Worker(
                                "12345678915",
                                "Person Test",
                                "11111111111",
                                "00000000000",
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
    @MethodSource("provideArgsForAlterWorkerWithExceptionThrow")
    public void insertWorkerExceptionThrow(Worker worker) {
        assertThrows(IllegalArgumentException.class, () -> alterWorker.alter(worker));
    }

    private static Stream<Arguments> provideArgsForAlterWorkerWithExceptionThrow() {
        return Stream.of(
                Arguments.of(new Worker(
                                "12345678900",
                                "Person Test",
                                "11111111111",
                                "00000000000",
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
                                "Person Test",
                                "11111111111",
                                "00000000000",
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
                                " ",
                                "Person Test",
                                "11111111111",
                                "00000000000",
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
                                "   .   ",
                                "Person Test",
                                "11111111111",
                                "00000000000",
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
                                "11111111111",
                                "",
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
                                null,
                                "Person Test",
                                "11111111111",
                                "",
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
                                null,
                                "11111111111",
                                "",
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
                                "11111111111",
                                "",
                                "test@test.com",
                                null
                        )
                )
        );
    }

}