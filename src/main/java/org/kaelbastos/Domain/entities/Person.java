package org.kaelbastos.Domain.entities;

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

        if (cpf == null || !this.checkCPFFormat(cpf) || name == null || name.equals("")) {
            throw new IllegalArgumentException("Arguments are invalid");
        }
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

    public boolean setTelephone(String telephone) {
        if (telephone != null && checkPhoneFormat(telephone)) {
            this.telephone = telephone;
            return true;
        } else
            throw new IllegalArgumentException("Phone Format Exception");
    }

    public String getTelephone() {
        return telephone;
    }


    public boolean setEmail(String email) {
        if (email != null && checkEmailFormat(email)) {
            this.email = email;
            return true;
        } else
            throw new IllegalArgumentException("String Format Exception");
    }

    public String getEmail() {
        return email;
    }

    public boolean setAddress(Address address) {
        if(address != null) {
            this.address = address;
            return true;
        } else
            throw new IllegalArgumentException("Null Address Exception");
    }

    public Address getAddress() {
        return address;
    }

    protected boolean checkPhoneFormat(String telephone) {
        int length = telephone.length();
        if (telephone.matches("^[0-9]{11}$")) {
            return true;
        } else {
            return false;
        }
    }

    protected boolean checkEmailFormat(String email) {
        if (email.matches("^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$")) {
            return true;
        } else {
            return false;
        }
    }

    protected boolean checkCPFFormat(String cpf) {
        if (cpf.matches("^[0-9]{11}$")) {
            return true;
        } else {
            return false;
        }
    }
}
