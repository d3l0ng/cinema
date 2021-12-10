package com.longosz.cinema.movie;

import lombok.Value;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Value
public class Screening {
    Movie movie;    // TODO maybe just id?
    LocalDateTime showTime;
    BigDecimal ticketPrice;
}
