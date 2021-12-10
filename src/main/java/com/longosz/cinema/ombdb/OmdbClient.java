package com.longosz.cinema.ombdb;

import com.longosz.cinema.movie.Movie;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "omdbapi", url = "http://www.omdbapi.com/")
public interface OmdbClient {

    @RequestMapping(method = RequestMethod.GET, value = "?apikey={token}&i={omdbId}", produces = "application/json")
    Movie getPostById(@PathVariable("token") String token, @PathVariable String omdbId);
}
