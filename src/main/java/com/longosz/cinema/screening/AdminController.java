package com.longosz.cinema.screening;

import com.longosz.cinema.movie.MoviesService;
import com.longosz.cinema.movie.domain.ClientFeedback;
import com.longosz.cinema.movie.domain.Screening;
import com.longosz.cinema.movie.domain.ScreeningId;
import io.swagger.v3.oas.annotations.Operation;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/admin")
@Slf4j
@RequiredArgsConstructor
public class AdminController {

    private final MoviesService moviesService;

    @Operation(description = "Allows to save screening") // TODO more swagger annotations to meet company standards
    @PostMapping
    void addScreening(@RequestBody ArrayList<ScreeningSaveRequest> screenings) {
        log.info("Adding information on screening: {}", screenings);

        List<Screening> domainScreenings = screenings.stream().map(ScreeningSaveRequest::toScreening).collect(Collectors.toList());
        moviesService.saveScreenings(domainScreenings);
    }

    @Operation(description = "Provides information on client feedbacks on particular movie")
    @GetMapping("/feedbacks/{movieId}")
    List<ClientFeedback> getClientFeedbacks(@PathVariable String movieId) {
        log.info("Retrieving client feedbacks for movie {}", movieId);

        return moviesService.getClientFeedbacks(movieId);
    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    private static class ScreeningSaveRequest {
        String movieId;
        String showTime;
        BigDecimal ticketPrice;

        Screening toScreening() {
            return Screening.builder()
                    .id(ScreeningId.builder()
                            .showTime(LocalDateTime.parse(showTime, DateTimeFormatter.ISO_LOCAL_DATE_TIME))
                            .movieId(movieId)
                            .build())
                    .ticketPrice(ticketPrice)
                    .build();
        }
    }
}
