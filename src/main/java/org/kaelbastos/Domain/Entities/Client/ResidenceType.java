package org.kaelbastos.Domain.Entities.Client;

public enum ResidenceType {
    Apartment("Apartment"),
    House("House"),
    Rural("Rural"),
    Loft("Loft");
    public String value;
    ResidenceType(String value) { this.value = value; }
}
