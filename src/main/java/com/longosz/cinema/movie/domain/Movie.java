package com.longosz.cinema.movie.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "movies")
@Builder
@Value
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Movie {

    @Id
    String imdbID;

    String Title;
    int Year;
    String Rated;

    @OneToMany(mappedBy = "Source")
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
    String Type;
    String DVD;
    String BoxOffice;
    String Production;
    String Website;
    String Response;
}



