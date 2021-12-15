package com.longosz.cinema.screening.controller.dto;

import com.longosz.cinema.screening.domain.Screening;
import com.longosz.cinema.screening.domain.ScreeningId;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiModelProperty;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Value
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
public class ScreeningSaveRequest {
    String movieId;
    @ApiModelProperty(
            value = "Time of the show in ISO_LOCAL_DATE_TIME format",
            dataType = "String",
            example = "2020-11-11T15:30:00")
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
