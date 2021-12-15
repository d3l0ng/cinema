package com.longosz.cinema.api;

import com.longosz.cinema.movie.MoviesService;
import com.longosz.cinema.movie.controller.dto.FeedbackRequest;
import com.longosz.cinema.movie.controller.dto.MovieResponse;
import com.longosz.cinema.screening.controller.dto.ScreeningResponse;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@Slf4j
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserController {

    private final MoviesService moviesService;

    @Operation(description = "Used to provide users feedback")
    @PostMapping("/feedback")
    void provideClientFeedback(@Valid @RequestBody FeedbackRequest feedbackRequest) {
        log.info("Providing feedback on movie {}", feedbackRequest);

        moviesService.saveClientFeedback(feedbackRequest.toClientFeedback());
    }

    @Operation(description = "Used to get information on setup screenings")
    @GetMapping("/screenings")
    List<ScreeningResponse> getScreenings() {
        log.info("Providing information on all movie screenings");

        var screenings = moviesService.getScreenings();

        return screenings.stream()
                .map(ScreeningResponse::of)
                .collect(Collectors.toList());
    }

    @Operation(description = "Used to get information on particular movie")
    @GetMapping("/movies/{omdbId}")
    MovieResponse movieDetails(@PathVariable String omdbId) {
        log.info("Providing information on movie with omdbId id {}", omdbId);

        return MovieResponse.of(moviesService.getMovieDetails(omdbId));
    }
}
