package org.kaelbastos.Domain.entities.Client;

public enum ResidenceType {
    Apartment("Apartment"),
    House("House"),
    Rural("Rural"),
    Loft("Loft");
    public String value;
    ResidenceType(String value) { this.value = value; }
}
