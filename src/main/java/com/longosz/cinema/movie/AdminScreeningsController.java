package com.longosz.cinema.movie;

import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@RestController
@Slf4j
public class AdminScreeningsController {

    @PutMapping("/screenings")
    void fullCatalog(@RequestParam ScreeningSaveRequest screening) {
        log.info("Saving information on screening: {}", screening);

        // TODO
    }


    @Value
    private static class ScreeningSaveRequest {
        String movieId;
        LocalDateTime showTime;
        BigDecimal ticketPrice;
    }
}
