package org.kaelbastos.Domain.entities.Service;
public enum ServiceStatus {
    Ongoing("Ongoing"),
    Scheduled("Scheduled"),
    Done("Done"),
    Canceled("Canceled");

    public String valor;

    ServiceStatus(String valorOpcao) {
        this.valor = valorOpcao;
    }
}
