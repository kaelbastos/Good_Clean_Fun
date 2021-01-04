package org.kaelbastos.Domain.entities.utils;

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
    public void getCpf() {
        assertEquals(cpf, person.getCpf());
    }

    @Test
    public void getName() {
        assertEquals(name, person.getName());
    }

    @Test
    public void getTelephone() {
        assertEquals(telephone, person.getTelephone());
    }

    @Test
    public void setTelephone() {
        String telephone = "11111111111";
        person.setTelephone(telephone);
        assertEquals(telephone, person.getTelephone());
    }

    @Test
    public void setEmail() {
        String email = "test@test.org";
        person.setEmail(email);
        assertEquals(email, person.getEmail());
    }

    @Test
    public void getEmail() {
        assertEquals(email, person.getEmail());
    }

    @Test
    public void getAddress() {
        assertEquals(address, person.getAddress());
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
        person.setAddress(newAddress);
        assertEquals(newAddress, person.getAddress());
    }
}
