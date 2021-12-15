package com.longosz.cinema.movie.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "clientFeedbacks")
@Builder
@Value
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ClientFeedback {
    @Id
    @GeneratedValue
    Integer id;

    String movieId;
    int stars;
    String description;
}
