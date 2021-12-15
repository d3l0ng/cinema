package com.longosz.cinema.screening.controller.dto;

import com.longosz.cinema.screening.domain.Screening;
import com.longosz.cinema.screening.domain.ScreeningId;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Value
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
public class ScreeningSaveRequest {
    String movieId;
    String showTime;
    BigDecimal ticketPrice;

    public Screening toScreening() {
        return Screening.builder()
                .id(ScreeningId.builder()
                        .showTime(LocalDateTime.parse(getShowTime(), DateTimeFormatter.ISO_LOCAL_DATE_TIME))
                        .movieId(getMovieId())
                        .build())
                .ticketPrice(getTicketPrice())
                .build();
    }
}
