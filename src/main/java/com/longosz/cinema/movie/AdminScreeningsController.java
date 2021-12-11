package com.longosz.cinema.movie;

import com.longosz.cinema.movie.dao.MovieRepository;
import com.longosz.cinema.movie.domain.Movie;
import com.longosz.cinema.movie.handling.MovieNotFoundException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController
@RequestMapping("/admin/screenings")
@Slf4j
@RequiredArgsConstructor
public class AdminScreeningsController {

    @Operation(
            summary = "Saves screenings",
            description = "Saves screenings"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Screenings were saved in database"),
            @ApiResponse(responseCode = "500", description = "Something went wrong, screenings were not saved")
    })
    @PostMapping
    void addScreening(@ModelAttribute ScreeningSaveRequest screening) {
        log.info("Adding information on screening: {}", screening);

        LocalDateTime showTime = LocalDateTime.parse(screening.showTime, DateTimeFormatter.ISO_LOCAL_DATE_TIME); // TODO e.g. 2021-01-01T12:30:22
        log.info("show time: {}", showTime);
        // TODO
    }

    @PutMapping("/{screeningId}")
    void editScreening(@PathVariable int screeningId, @ModelAttribute ScreeningSaveRequest screening) {
        log.info("Editing information on screening {}:  {}", screeningId, screening);

        LocalDateTime showTime = LocalDateTime.parse(screening.showTime, DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        log.info("show time: {}", showTime);
        // TODO
    }

    private final MovieRepository movieRepository;

    @GetMapping("/save")
    void sss() {
        String id = "id1";
        log.info("saving {}", id);
        movieRepository.save(Movie.builder().imdbID(id).Title("test 1").build());
    }

    @GetMapping("/query")
    Movie qqq() {
        String id = "id1";

        log.info("quering {}", id);
        return movieRepository.findById(id).orElseThrow(() -> new MovieNotFoundException(id));
    }

    @Value
    private static class ScreeningSaveRequest {
        String movieId;
        String showTime;
        BigDecimal ticketPrice;
    }
}
