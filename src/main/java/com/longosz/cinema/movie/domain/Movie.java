package com.longosz.cinema.movie.domain;

//import io.swagger.annotations.ApiModel;
import lombok.Value;

import java.util.List;

//@ApiModel("Personal data of Movie")
@Value
public class Movie {

    String Title;
    int Year;
    String Rated;
    List<Rating> Ratings;
    String Release;
    String Runtime;
    String Genre;
    String Directo;
    String Writer;
    String Actors;
    String Plot;
    String Language;
    String Country;
    String Awards;
    String Poster;
    String Metascore;
    String imdbRating;
    String imdbVotes;
    String imdbID;
    String Type;
    String DVD;
    String BoxOffice;
    String Production;
    String Website;
    String Response;
}



