package com.longosz.cinema.movie;

import com.longosz.cinema.movie.domain.Movie;
import com.longosz.cinema.movie.domain.Screening;
import com.longosz.cinema.ombdb.OmdbClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

@RestController
@Slf4j
@RequestMapping("/api/movies")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class MoviesController {

    private final OmdbClient omdbClient;
    @Value("${omdbi.token}")
    private final String omdbiToken;

    private static final Set<String> AVAILABLE_MOVIES = Set.of( // TODO populate DB with this
            "tt0232500",
            "tt0322259",
            "tt0463985",
            "tt1013752",
            "tt1596343",
            "tt1905041",
            "tt2820852",
            "tt4630562",
            "tt5433138"
    );

    @PutMapping("/movies/feedback")
    List<Screening> screenings(@RequestParam FeedbackRequest feedbackRequest) {
        log.info("Providing information on movie screenings");

        return List.of(); // TODO
    }

    @GetMapping("/screenings")
    List<Screening> screenings() {
        log.info("Providing information on movie screenings");

        return List.of(Screening.builder().ticketPrice(BigDecimal.ONE).build()); // TODO return only movie id, desc, time and price
    }

    @GetMapping("/movies/{omdbId}")
    Movie movieDetails(@PathVariable String omdbId) {       // TODO fix movieId (internal in app) vs omdbId (external id)
        log.info("Providing information on movie with omdbId id {}", omdbId);

        return omdbClient.getPostById(omdbiToken, omdbId);
    }

    @lombok.Value   // TOOD value vs java record
    private class FeedbackRequest { // TODO is it the same as ClientFeedback?
        String movieId;
        int star;
    }
}
