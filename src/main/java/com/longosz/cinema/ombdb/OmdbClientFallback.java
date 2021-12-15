package com.longosz.cinema.ombdb;

import com.longosz.cinema.movie.domain.Movie;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("!test")
@Component
public class OmdbClientFallback implements OmdbClient {

    @Override
    public Movie getMovieDetails(String token, String omdbId) {
        return Movie.builder()      // TODO we could lookup in mem the best user film to 'make up' to him
                .Title("Your best movie instead")
                .build();
    }
}
