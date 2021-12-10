package com.longosz.cinema.movie.domain;

import lombok.Value;

@Value
public class ClientFeedback {
    String movieId;
    int stars;
}
