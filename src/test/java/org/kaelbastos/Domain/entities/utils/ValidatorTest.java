package org.kaelbastos.Domain.entities.utils;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class ValidatorTest {

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"", "        ", " "})
    void isNullOrEmptyStringTrueReturn(String string) {
        assertTrue(Validator.isNullOrEmpty(string));
    }

    @ParameterizedTest
    @MethodSource("randomStringProvider")
    @ValueSource(strings = {" /", "        .  ", "-", "0", "batata"})
    void isNullOrEmptyStringFalseReturn(String string) {
        assertFalse(Validator.isNullOrEmpty(string));
    }

    private static Stream<Arguments> randomStringProvider(){
        byte[] array = new byte[10]; // length is bounded by 10
        new Random().nextBytes(array);
        String generatedString = new String(array , StandardCharsets.UTF_8);

        return Stream.of(Arguments.of(generatedString));
    }

    @ParameterizedTest
    @NullSource
    @MethodSource("emptyCollectionProvider")
    void testIsNullOrEmptyCollectionTrueReturn(Collection collection) {
        assertTrue(Validator.isNullOrEmpty(collection));
    }

    private static Stream<Arguments> emptyCollectionProvider(){
        return Stream.of(
                Arguments.of(new ArrayList<Object>()),
                Arguments.of(new HashSet<Object>())
        );
    }

    @ParameterizedTest
    @MethodSource("collectionProvider")
    void testIsNullOrEmptyCollectionFalseReturn(Collection collection) {
        assertFalse(Validator.isNullOrEmpty(collection));
    }

    private static Stream<Arguments> collectionProvider(){
        return Stream.of(
                Arguments.of(new ArrayList<String>(List.of("1", "2", "batata", "program"))),
                Arguments.of(new HashSet<Integer>(List.of(1,2,3,4,5,6,7,8,9,10,11)))
        );
    }

    @Test
    void isNullObjectTrueReturn() {
        assertTrue(Validator.isNull((Object) null));
    }

    @Test
    void isNullObjectFalseReturn() {
        assertFalse(Validator.isNull(new Object()));
    }

    @Test
    void isNullIntegerTrueReturn() {
        assertTrue(Validator.isNull(null));
    }

    @Test
    void isNullIntegerFalseReturn() {
        assertFalse(Validator.isNull(1));
    }

    @Test
    void isNotNullObjectFalseReturn() {
        assertFalse(Validator.isNotNull(null));
    }

    @Test
    void isNotNullObjectTrueReturn() {
        assertTrue(Validator.isNotNull(new Object()));
    }
}