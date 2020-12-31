package org.kaelbastos.Domain.entities.Service;

public enum ObservationType {
    Complaint("complaint"),
    Comment("comment"),
    Compliment("compliment"),
    Suggestion("suggestion"),
    Other("other");

    public String valor;

    ObservationType(String valorOpcao) {
        this.valor = valorOpcao;
    }
}
