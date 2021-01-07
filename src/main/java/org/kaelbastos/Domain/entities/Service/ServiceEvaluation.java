package org.kaelbastos.Domain.entities.Service;

import org.kaelbastos.Domain.entities.utils.Person;

public class ServiceEvaluation {
    private String comment;
    private int rating;
    private final Person author;

    public ServiceEvaluation(
            String comment,
            int rating,
            Person author) {
        this.comment = comment;
        this.rating = rating;
        this.author = author;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public Person getAuthor() {
        return author;
    }
}
