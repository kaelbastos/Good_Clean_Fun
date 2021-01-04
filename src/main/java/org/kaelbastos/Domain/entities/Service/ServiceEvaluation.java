package org.kaelbastos.Domain.entities.Service;

import org.kaelbastos.Domain.entities.utils.Person;

public class ServiceEvaluation {
    private String comment;
    private float rating;
    private final Person author;

    public ServiceEvaluation(
            String comment,
            Float OneToFiveRating,
            Person author) {
        this.comment = comment;
        if(OneToFiveRating != null && OneToFiveRating >= 1F && OneToFiveRating <= 5F)
            this.rating = OneToFiveRating;
        else
            this.rating = 1F;
        this.author = author;
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
