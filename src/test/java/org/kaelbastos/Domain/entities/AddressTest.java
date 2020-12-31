package org.kaelbastos.Domain.entities;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


public class AddressTest {
    private String street = "Street";
    private String neighborhood = "Neighborhood";
    private String city = "City";
    private String state = "State";
    private String number = "000";
    private String postalCode = "0";
    private String complement = "Complement";

    Address address = new Address(
            street,
            neighborhood,
            city,
            state,
            number,
            postalCode,
            complement);

    @Test
    public void classInstantiation() {
        Address address1 = new Address(
                street,
                neighborhood,
                city,
                state,
                number,
                postalCode,
                complement);
    }

    @Test
    public void classInstantiationWithNullStreetArg() {
        assertThrows(IllegalArgumentException.class, () -> {
            Address address1 = new Address(
                    null,
                    neighborhood,
                    city,
                    state,
                    number,
                    postalCode,
                    complement);
        });
    }

    @Test
    public void classInstantiationWithNullNeighborhoodArg() {
        assertThrows(IllegalArgumentException.class, () -> {
            Address address1 = new Address(
                    street,
                    null,
                    city,
                    state,
                    number,
                    postalCode,
                    complement);
        });
    }

    @Test
    public void classInstantiationWithNullCityArg() {
        assertThrows(IllegalArgumentException.class, () -> {
            Address address1 = new Address(
                    street,
                    neighborhood,
                    null,
                    state,
                    number,
                    postalCode,
                    complement);
        });
    }

    @Test
    public void classInstantiationWithNullStateArg() {
        assertThrows(IllegalArgumentException.class, () -> {
            Address address1 = new Address(
                    street,
                    neighborhood,
                    city,
                    null,
                    number,
                    postalCode,
                    complement);
        });
    }

    @Test
    public void classInstantiationWithNullNumberArg() {
        assertThrows(IllegalArgumentException.class, () -> {
            Address address1 = new Address(
                    street,
                    neighborhood,
                    city,
                    state,
                    null,
                    postalCode,
                    complement);
        });
    }

    @Test
    public void classInstantiationWithNullPostalCodeArg() {
        assertThrows(IllegalArgumentException.class, () -> {
            Address address1 = new Address(
                    street,
                    neighborhood,
                    city,
                    state,
                    number,
                    null,
                    complement);
        });
    }

    @Test
    public void classInstantiationWithNullComplementArg() {
        Address address1 = new Address(
                street,
                neighborhood,
                city,
                state,
                number,
                postalCode,
                null);
    }

    @Test
    public void getStreet() {
        assertEquals(street, address.getStreet());
    }

    @Test
    public void setStreet() {
        assertTrue(address.setStreet("New Street"));
    }

    @Test
    public void setNullStreet() {
        assertThrows(IllegalArgumentException.class, () -> {
            address.setStreet(null);
        });
    }

    @Test
    public void getNeighborhood() {
        assertEquals(neighborhood, address.getNeighborhood());
    }

    @Test
    public void setNeighborhood() {
        assertTrue(address.setNeighborhood("new Neighborhood"));
    }

    @Test
    public void setNullNeighborhood() {
        assertThrows(IllegalArgumentException.class, () -> {
            address.setNeighborhood(null);
        });
    }

    @Test
    public void getCity() {
        assertEquals(city, address.getCity());
    }

    @Test
    public void setCity() {
        assertTrue(address.setCity("new City"));
    }

    @Test
    public void setNullCity() {
        assertThrows(IllegalArgumentException.class, () -> {
            address.setCity(null);
        });
    }

    @Test
    public void getState() {
        assertEquals(state, address.getState());
    }

    @Test
    public void setState() {
        assertTrue(address.setState("new State"));
    }

    @Test
    public void setNullState() {
        assertThrows(IllegalArgumentException.class, () -> {
            address.setState(null);
        });
    }

    @Test
    public void getNumber() {
        assertEquals(number, address.getNumber());
    }

    @Test
    public void setNumber() {
        assertTrue(address.setNumber("01"));
    }

    @Test
    public void setNullNumber() {
        assertThrows(IllegalArgumentException.class, () -> {
            address.setNumber(null);
        });
    }

    @Test
    public void getPostalCode() {
        assertEquals(postalCode, address.getPostalCode());
    }

    @Test
    public void setPostalCode() {
        assertTrue(address.setPostalCode("1"));
    }

    @Test
    void setNullPostalCode() {
        assertThrows(IllegalArgumentException.class, () -> {
            address.setPostalCode(null);
        });
    }

    @Test
    public void getComplement() {
        assertEquals(complement, address.getComplement());
    }

    @Test
    public void setComplement() {
        assertTrue(address.setComplement("new Complement"));
    }

    @Test
    public void setNullComplement() {
        assertTrue(address.setComplement(null));
    }
}