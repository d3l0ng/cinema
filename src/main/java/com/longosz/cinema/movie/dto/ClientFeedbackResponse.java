package com.longosz.cinema.movie.dto;

import com.longosz.cinema.movie.domain.ClientFeedback;
import lombok.*;

@Builder
@Value
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ClientFeedbackResponse {
    String movieId;
    int stars;
    String description;

    public static ClientFeedbackResponse of(ClientFeedback clientFeedback) {
        return ClientFeedbackResponse.builder()
                .movieId(clientFeedback.getMovieId())
                .description(clientFeedback.getDescription())
                .stars(clientFeedback.getStars())
                .build();
    }
}
