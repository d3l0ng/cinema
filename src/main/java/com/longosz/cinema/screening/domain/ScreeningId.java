package com.longosz.cinema.screening.domain;

import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;


@Builder
@Value
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ScreeningId implements Serializable {
    String movieId;
    LocalDateTime showTime;
}
