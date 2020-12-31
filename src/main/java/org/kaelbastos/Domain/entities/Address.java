package org.kaelbastos.Domain.entities;

import java.util.Objects;

public class Address {
    private String street;
    private String neighborhood;
    private String city;
    private String state;
    private String number;
    private String postalCode;
    private String complement;

    public Address(String street,
                   String neighborhood,
                   String city,
                   String state,
                   String number,
                   String postalCode,
                   String complement) {
        this.setStreet(street);
        this.setNeighborhood(neighborhood);
        this.setCity(city);
        this.setState(state);
        this.setNumber(number);
        this.setPostalCode(postalCode);
        this.complement = complement;
    }

    public String getStreet() {
        return street;
    }

    public boolean setStreet(String newStreet) {
        if (newStreet != null) {
            this.street = newStreet;
            return true;
        } else
            throw new IllegalArgumentException("Null Street Argument");
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public boolean setNeighborhood(String neighborhood) {
        if (neighborhood != null){
            this.neighborhood = neighborhood;
            return true;
        }else
            throw new IllegalArgumentException("Null Neighborhood Argument");
    }

    public String getCity() {
        return city;
    }

    public boolean setCity(String city) {
        if (city != null){
            this.city = city;
            return true;
        } else
            throw new IllegalArgumentException("Null City Argument");
    }

    public String getState() {
        return state;
    }

    public boolean setState(String state) {
        if (state != null) {
            this.state = state;
            return true;
        }else
            throw new IllegalArgumentException("Null State Argument");
    }

    public String getNumber() {
        return number;
    }

    public boolean setNumber(String number) {
        if (number != null) {
            this.number = number;
            return true;
        } else
            throw new IllegalArgumentException("Null Number Argument");
    }

    public String getPostalCode() {
        return postalCode;
    }

    public boolean setPostalCode(String postalCode) {
        if (postalCode != null) {
            this.postalCode = postalCode;
            return true;
        }else
            throw new IllegalArgumentException("Null Postal Code Argument");
    }

    public String getComplement() {
        if (this.complement == null || this.complement.isEmpty())
            return "-";
        else
            return complement;
    }

    public boolean setComplement(String complement) {
        this.complement = complement;
        return true;
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
                ", complement='" + this.getComplement() + '\'' +
                '}';
    }
}
