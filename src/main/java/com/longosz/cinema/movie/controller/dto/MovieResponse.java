package com.longosz.cinema.movie.controller.dto;

import com.longosz.cinema.movie.domain.Movie;
import com.longosz.cinema.movie.domain.Rating;
import lombok.*;

import java.util.stream.Collectors;

@Builder
@Value
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class MovieResponse {
    String imdbID;
    String title;
    int year;
    String rated;
    double avgRating;
    String release;
    String runtime;
    String genre;
    String directo;
    String writer;
    String actors;
    String plot;
    String language;
    String country;
    String awards;
    String poster;
    String metascore;
    String imdbRating;
    String imdbVotes;
    String type;
    String dVD;
    String boxOffice;
    String production;
    String website;
    String response;

    public static MovieResponse of(Movie movieDetails) {
        var avgRatings = movieDetails.getRatings().stream()
                .map(Rating::getValue)
                .map(Double::parseDouble)
                .collect(Collectors.summarizingDouble(Double::doubleValue))
                .getAverage();

        return MovieResponse.builder()
                .imdbID(movieDetails.getImdbID())
                .title(movieDetails.getTitle())
                .year(movieDetails.getYear())
                .rated(movieDetails.getRated())
                .avgRating(avgRatings)
                .release(movieDetails.getRelease())
                .runtime(movieDetails.getRuntime())
                .genre(movieDetails.getGenre())
                .directo(movieDetails.getDirecto())
                .writer(movieDetails.getWriter())
                .actors(movieDetails.getActors())
                .plot(movieDetails.getPlot())
                .language(movieDetails.getLanguage())
                .country(movieDetails.getCountry())
                .awards(movieDetails.getAwards())
                .poster(movieDetails.getPoster())
                .metascore(movieDetails.getMetascore())
                .imdbRating(movieDetails.getImdbRating())
                .imdbVotes(movieDetails.getImdbVotes())
                .type(movieDetails.getType())
                .dVD(movieDetails.getDVD())
                .boxOffice(movieDetails.getBoxOffice())
                .production(movieDetails.getProduction())
                .website(movieDetails.getWebsite())
                .response(movieDetails.getResponse())
                .build();
    }
}
