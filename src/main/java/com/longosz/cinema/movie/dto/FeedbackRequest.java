package com.longosz.cinema.movie.dto;

import com.longosz.cinema.movie.domain.ClientFeedback;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.Value;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Value
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
public class FeedbackRequest {
    @NotNull
    String movieId;

    @Min(1)
    @Max(5)
    int stars;

    @NotBlank
    String description;

    public ClientFeedback toClientFeedback() {
        return ClientFeedback.builder()
                .movieId(movieId)
                .stars(stars)
                .description(description)
                .build();
    }
}
