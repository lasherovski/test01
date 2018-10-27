package com.group19.comment.g19_comment.entity;

import lombok.Data;
import lombok.NonNull;

import javax.persistence.*;

@Data
@Entity
@Table(name = "Ratings")

public class Rating {
    @Id
    @SequenceGenerator(name = "rating_seq", sequenceName = "rating_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rating_seq")
    private @NonNull
    Long rateid;
    private @NonNull
    Long ratinglevel;


    public Rating() {
    }

    public Rating(Long rateinglevel) {
        this.ratinglevel = rateinglevel;
    }
}
