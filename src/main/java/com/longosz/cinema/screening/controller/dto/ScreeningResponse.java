package com.longosz.cinema.screening.controller.dto;

import com.longosz.cinema.screening.domain.Screening;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Builder
@Value
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ScreeningResponse {
    String movieId;
    LocalDateTime showTime;
    BigDecimal ticketPrice;

    public static ScreeningResponse of(Screening screening) {
        return ScreeningResponse.builder()
                .movieId(screening.getId().getMovieId())
                .showTime(screening.getId().getShowTime())
                .ticketPrice(screening.getTicketPrice())
                .build();
    }
}
