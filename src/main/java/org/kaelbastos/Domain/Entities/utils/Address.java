package org.kaelbastos.Domain.Entities.utils;

import java.util.Objects;

public class Address {
    private String street;
    private String neighborhood;
    private String city;
    private String state;
    private String number;
    private String postalCode;
    private String complement;

    public Address(
            String street,
            String neighborhood,
            String city,
            String state,
            String number,
            String postalCode,
            String complement) {
        this.street = street;
        this.neighborhood = neighborhood;
        this.city = city;
        this.state = state;
        this.number = number;
        this.postalCode = postalCode;
        this.complement = complement;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String newStreet) {
        this.street = newStreet;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Objects.equals(street, address.street) &&
                Objects.equals(neighborhood, address.neighborhood) &&
                Objects.equals(city, address.city) &&
                Objects.equals(state, address.state) &&
                Objects.equals(number, address.number) &&
                Objects.equals(postalCode, address.postalCode) &&
                Objects.equals(complement, address.complement);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                street,
                neighborhood,
                city,
                state,
                number,
                postalCode,
                complement);
    }

    @Override
    public String toString() {
        return "Address{" +
                "street='" + street + '\'' +
                ", neighborhood='" + neighborhood + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", number='" + number + '\'' +
                ", postalCode=" + postalCode +
                ", complement='" + complement + '\'' +
                '}';
    }
}
