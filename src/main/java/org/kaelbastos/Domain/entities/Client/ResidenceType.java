package org.kaelbastos.Domain.entities.Client;

public enum ResidenceType {
    Apartment("Apartment"),
    House("House"),
    Loft("Loft"),
    Rural("Rural");
    public String value;
    ResidenceType(String value) { this.value = value; }
}
