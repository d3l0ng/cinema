package com.longosz.cinema.movie;

import com.longosz.cinema.movie.domain.ClientFeedback;
import com.longosz.cinema.movie.domain.Movie;
import com.longosz.cinema.movie.domain.Screening;
import io.swagger.v3.oas.annotations.Operation;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/api/movies")
@RequiredArgsConstructor
public class MoviesController {

    private final MoviesService moviesService;

    @Operation(description = "Used to provide users feedback")
    @PostMapping("/feedback")
    void provideClientFeedback(@RequestBody FeedbackRequest feedbackRequest) {
        log.info("Providing information on movie screenings");

        moviesService.saveClientFeedback(feedbackRequest.toClientFeedback());
    }

    @Operation(description = "Used to get information on setup screenings")
    @GetMapping("/screenings")
    List<Screening> getScreenings() {
        log.info("Providing information on all movie screenings");

        return moviesService.getScreenings();
    }

    @Operation(description = "Used to get information on particular movie")
    @GetMapping("/movies/{omdbId}")
    Movie movieDetails(@PathVariable String omdbId) {
        log.info("Providing information on movie with omdbId id {}", omdbId);

        return moviesService.getMovieDetails(omdbId);
    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    private static class FeedbackRequest {
        String movieId;
        int stars;
        String description;

        public ClientFeedback toClientFeedback() {
            return ClientFeedback.builder()
                    .movieId(movieId)
                    .stars(stars)
                    .description(description)
                    .build();
        }
    }
}
