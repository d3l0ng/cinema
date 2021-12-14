package com.longosz.cinema.ombdb;

import com.longosz.cinema.config.FeignClientConfig;
import com.longosz.cinema.movie.domain.Movie;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(
        value = "omdbapi",
        url = "http://www.omdbapi.com/",
        configuration = FeignClientConfig.class,
        fallback = OmdbClient.OmdbClientFallback.class
)
public interface OmdbClient {

    @RequestMapping(method = RequestMethod.GET, value = "?apikey={token}&i={omdbId}")
    Movie getMovieDetails(@PathVariable("token") String token, @PathVariable("omdbId") String omdbId);

    @Component
    class OmdbClientFallback implements OmdbClient {
        @Override
        public Movie getMovieDetails(String token, String omdbId) {
            return Movie.builder()      // TODO we could lookup in mem the best user film to 'make up' to him
                    .Title("Your best movie instead")
                    .build();
        }
    }
}
