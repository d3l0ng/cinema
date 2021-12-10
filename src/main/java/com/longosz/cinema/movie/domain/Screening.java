package com.longosz.cinema.movie.domain;

import lombok.Builder;
import lombok.Value;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Builder
@Value
public class Screening {
    Movie movie;    // TODO maybe just id?
    LocalDateTime showTime;
    BigDecimal ticketPrice;
}
