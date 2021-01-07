package org.kaelbastos.Domain.entities.Service;
public enum ServiceStatus {
    Ongoing("Ongoing"),
    Scheduled("Scheduled"),
    Done("Done"),
    Canceled("Canceled");

    public String value;

    ServiceStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
