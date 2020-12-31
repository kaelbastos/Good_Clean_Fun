package org.kaelbastos.Domain.entities;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.ValueSource;


public class PersonTest {
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

    @Test
    public void Instantiation() {
        Person person1 = new Person(cpf, name, telephone, email, address);
    }

    @Test
    public void InstantiationWithNullCPFArg() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Person(null, name, telephone, email, address);
        });
    }

    @Test
    public void InstantiationWithNullNameArg() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Person(cpf, null, telephone, email, address);
        });
    }

    @Test
    public void InstantiationWithNullTelephoneArg() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Person(cpf, name, null, email, address);
        });
    }

    @Test
    public void InstantiationWithNullEmailArg() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Person(cpf, name, telephone, null, address);
        });
    }

    @Test
    public void InstantiationWithNullAddressArg() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Person(cpf, name, telephone, email, null);
        });
    }

    @Test
    public void getCpf() {
        assertEquals(cpf, person.getCpf());
    }

    @Test
    public void getName() {
        assertEquals(name, person.getName());
    }

    @Test
    public void setTelephone() {
        assertTrue(person.setTelephone("11111111111"));
    }

    @ParameterizedTest
    @ValueSource(strings = {"1111111111", "(11)11111-1111", "a1111111111"})
    public void setUnformattedTelephone(String telephoneInput) {
        assertThrows(IllegalArgumentException.class, () -> {
            person.setTelephone(telephoneInput);
        });
    }

    @Test
    public void setNullTelephone() {
        assertThrows(IllegalArgumentException.class, () -> {
            person.setTelephone(null);
        });
    }

    @Test
    public void getTelephone() {
        assertEquals(telephone, person.getTelephone());
    }

    @Test
    public void setEmail() {
        assertTrue(person.setEmail("test@test.org"));
    }

    @ParameterizedTest
    @ValueSource(strings = {"test", "test@test", "test@test", "@test.com", "test@.com", "@.", ""})
    public void setUnformattedEmail(String emailInput) {
        assertThrows(IllegalArgumentException.class, () -> {
            person.setEmail(emailInput);
        });
    }

    @Test
    public void setNullEmail() {
        assertThrows(IllegalArgumentException.class, () -> {
            person.setEmail(null);
        });
    }

    @Test
    public void getEmail() {
        assertEquals(email, person.getEmail());
    }

    @Test
    public void setAddress() {
        Address newAddress = new Address("street",
                "neighborhood",
                "city",
                "state",
                "001",
                "1",
                "apartment 1B"
                );
        assertTrue(person.setAddress(newAddress));
    }

    @Test
    public void getAddress() {
        assertEquals(address, person.getAddress());
    }

    @Test
    void CheckPhoneFormat() {
        assertTrue(person.checkPhoneFormat("00000000000"));
    }

    @ParameterizedTest
    @ValueSource(strings = {"1111111111", "(11)11111-1111", "a1111111111"})
    public void checkUnformattedPhones(String string) {
        assertFalse(person.checkPhoneFormat(string));
    }

    @Test
    void checkEmailFormat() {
        assertTrue(person.checkEmailFormat("test@test.com"));
    }

    @ParameterizedTest
    @ValueSource(strings = {"test", "test@test", "test@test", "@test.com", "test@.com", "@.", ""})
    public void checkUnformattedEmails(String string) {
        assertFalse(person.checkEmailFormat(string));
    }

    @Test
    void CheckCPFFormat() {
        assertTrue(person.checkCPFFormat("00000000000"));
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "000.000.000/00",
            "000000000000",
            "000-000-000/00",
            "a0000000000",
            "0000000000",
            "",
            " "})
    public void checkUnformattedCPFs(String string) {
        assertFalse(person.checkCPFFormat(string));
    }
}
