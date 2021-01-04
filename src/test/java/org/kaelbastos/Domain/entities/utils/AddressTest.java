package org.kaelbastos.Domain.entities.utils;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Order;
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
    @Order(1)
    @Test
    public void getStreet() {
        assertEquals(street, address.getStreet());
    }

    @Order(2)
    @Test
    public void setStreet() {
        String newStreet = "New Street";
        address.setStreet(newStreet);
        assertEquals(newStreet, address.getStreet());
    }

    @Order(3)
    @Test
    public void getNeighborhood() {
        assertEquals(neighborhood, address.getNeighborhood());
    }

    @Order(4)
    @Test
    public void setNeighborhood() {
        String newNeighborhood = "new Neighborhood";
        address.setNeighborhood(newNeighborhood);
        assertEquals(newNeighborhood, address.getNeighborhood());
    }

    @Order(5)
    @Test
    public void getCity() {
        assertEquals(city, address.getCity());
    }

    @Order(6)
    @Test
    public void setCity() {
        String newCity = "new City";
        address.setCity(newCity);
        assertEquals(newCity, address.getCity());
    }

    @Order(8)
    @Test
    public void getState() {
        assertEquals(state, address.getState());
    }

    @Order(9)
    @Test
    public void setState() {
        String newState = "new State";
        address.setState(newState);
        assertEquals(newState, address.getState());
    }

    @Order(10)
    @Test
    public void getNumber() {
        assertEquals(number, address.getNumber());
    }

    @Order(11)
    @Test
    public void setNumber() {
        String newNumber = "01";
        address.setNumber(newNumber);
        assertEquals(newNumber, address.getNumber());
    }

    @Order(12)
    @Test
    public void getPostalCode() {
        assertEquals(postalCode, address.getPostalCode());
    }

    @Order(13)
    @Test
    public void setPostalCode() {
        String newPostalCode = "1";
        address.setPostalCode(newPostalCode);
        assertEquals(newPostalCode, address.getPostalCode());
    }

    @Order(14)
    @Test
    public void getComplement() {
        assertEquals(complement, address.getComplement());
    }

    @Order(15)
    @Test
    public void setComplement() {
        String newComplement = "new Complement";
        address.setComplement(newComplement);
        assertEquals(newComplement, address.getComplement());
    }
}