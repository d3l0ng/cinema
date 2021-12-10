package com.longosz.cinema.movie.domain;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "screenings")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Screening {
    @Id
    @GeneratedValue
    Integer id;

    @ManyToOne
    @JoinColumn(name="movieId")
    Movie movie;
    LocalDateTime showTime;
    BigDecimal ticketPrice;
}
