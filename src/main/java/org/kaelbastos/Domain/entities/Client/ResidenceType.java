package org.kaelbastos.Domain.entities.Client;

public enum ResidenceType {
    Apartament("Apartament"),
    House("House"),
    Loft("Loft");
    public String valor;
    ResidenceType(String valorOpcao) { this.valor = valorOpcao; } 
}
