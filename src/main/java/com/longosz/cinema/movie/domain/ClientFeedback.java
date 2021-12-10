package com.longosz.cinema.movie.domain;

import lombok.*;

import javax.persistence.Entity;
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
    String movieId;
    int stars;
}
