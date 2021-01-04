package org.kaelbastos.Domain.entities.utils;

public class Observation {
    private ObservationType observationType;
    private String comment;
    private float rating;
    private final Person author;

    public Observation(
            ObservationType observationType,
            String comment,
            Float OneToFiveRating,
            Person author) {
        this.observationType = observationType;
        this.comment = comment;
        if(OneToFiveRating != null && OneToFiveRating >= 1F && OneToFiveRating <= 5F)
            this.rating = OneToFiveRating;
        else
            this.rating = 1F;
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

    public float getRating() {
        return rating;
    }

    public void setRating(Float OneToFiveRating) {
        if (OneToFiveRating != null && OneToFiveRating >= 1F && OneToFiveRating <= 5F)
            this.rating = OneToFiveRating;
    }

    public Person getAuthor() {
        return author;
    }
}
