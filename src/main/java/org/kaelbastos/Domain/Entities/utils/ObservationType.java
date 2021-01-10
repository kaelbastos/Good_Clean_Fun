package org.kaelbastos.Domain.Entities.utils;

public enum ObservationType {
    Complaint("complaint"),
    Comment("comment"),
    Compliment("compliment"),
    Suggestion("suggestion"),
    Other("other"),
    None("None");

    public String value;

    ObservationType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
