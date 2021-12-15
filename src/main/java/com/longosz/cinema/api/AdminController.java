package com.longosz.cinema.api;

import com.longosz.cinema.movie.MoviesService;
import com.longosz.cinema.movie.controller.dto.ClientFeedbackResponse;
import com.longosz.cinema.screening.controller.dto.ScreeningSaveRequest;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/admin")
@Slf4j
@RequiredArgsConstructor
public class AdminController {

    private final MoviesService moviesService;

    @Operation(description = "Allows to save screening") // TODO add any more swagger annotations to meet company standards
    @PostMapping("/screenings")
    void addScreening(@RequestBody ArrayList<ScreeningSaveRequest> screenings) {
        log.info("Adding information on screening: {}", screenings);

        var domainScreenings = screenings.stream()
                .map(ScreeningSaveRequest::toScreening)
                .collect(Collectors.toList());

        moviesService.saveScreenings(domainScreenings);
    }

    @Operation(description = "Provides information on client feedbacks on particular movie")
    @GetMapping("/feedbacks/{movieId}")
    List<ClientFeedbackResponse> getClientFeedbacks(@PathVariable String movieId) {
        log.info("Retrieving client feedbacks for movie {}", movieId);

        var feedbacks = moviesService.getClientFeedbacks(movieId);
        return feedbacks.stream()
                .map(ClientFeedbackResponse::of)
                .collect(Collectors.toList());
    }
}
