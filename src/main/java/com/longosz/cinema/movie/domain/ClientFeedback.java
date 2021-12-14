package com.longosz.cinema.movie.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "clientFeedbacks")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClientFeedback {
    @Id
    @GeneratedValue
    Integer id;

    String movieId;
    int stars;
    String description;
}
