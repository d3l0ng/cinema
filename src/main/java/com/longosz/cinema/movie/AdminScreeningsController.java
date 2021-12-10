package com.longosz.cinema.movie;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/admin/screenings")
@Slf4j
public class AdminScreeningsController {

    @Operation(
            summary = "Saves screenings",
            description = "Saves screenings"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Screenings were saved in database"),
            @ApiResponse(responseCode = "500", description = "Something went wrong, screenings were not saved")
    })
    @PutMapping
    void fullCatalog(@RequestParam ScreeningSaveRequest screening) {
        log.info("Saving information on screening: {}", screening);

        // TODO
    }

    @GetMapping("/abc")
    String aaa() {
        log.info("okokok");
        return "ok";
    }

    @Value
    private static class ScreeningSaveRequest {
        String movieId;
        LocalDateTime showTime;
        BigDecimal ticketPrice;
    }
}
