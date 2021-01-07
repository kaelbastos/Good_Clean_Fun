package org.kaelbastos.Domain.entities.utils;

public class Observation {
    private ObservationType observationType;
    private String comment;
    private final Person author;

    public Observation(
            ObservationType observationType,
            String comment,
            Person author) {
        this.observationType = observationType;
        this.comment = comment;
        this.author = author;
    }

    public ObservationType getObservationType() {
        return observationType;
    }

    public void setObservationType(ObservationType observationType) {
        this.observationType = observationType;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Person getAuthor() {
        return author;
    }
}
