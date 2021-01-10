package org.kaelbastos.Domain.Entities.utils;

import java.util.Objects;

public class Person {
    private final String cpf;
    private final String name;
    private String telephone;
    private String email;
    private Address address;


    public Person(String cpf,
                  String name,
                  String telephone,
                  String email,
                  Address address) {
        this.cpf = cpf;
        this.name = name;
        this.setTelephone(telephone);
        this.setEmail(email);
        this.setAddress(address);
    }

    public String getCpf() {
        return cpf;
    }

    public String getName() {
        return name;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getTelephone() {
        return telephone;
    }


    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Address getAddress() {
        return address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return cpf.equals(person.cpf);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cpf);
    }

    @Override
    public String toString() {
        return "Person{" +
                "cpf='" + cpf + '\'' +
                ", name='" + name + '\'' +
                ", telephone='" + telephone + '\'' +
                ", email='" + email + '\'' +
                ", " + address.toString() +
                '}';
    }
}
