package com.longosz.cinema.movie.domain;

//import io.swagger.annotations.ApiModel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

//@ApiModel("Personal data of Movie")
//@Value
@Entity
@Table(name = "movies")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
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



