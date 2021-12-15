package com.longosz.cinema.integration

import com.longosz.cinema.movie.MoviesService
import com.longosz.cinema.movie.dao.MovieRepository
import com.longosz.cinema.movie.domain.Movie
import com.longosz.cinema.movie.handling.MovieNotFoundException
import com.longosz.cinema.ombdb.OmdbClient
import org.spockframework.spring.SpringBean
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import spock.lang.Specification

@SpringBootTest
@ActiveProfiles(value = "test")
class IntegrationTest extends Specification {

    @Autowired
    MoviesService moviesService
    @Autowired
    MovieRepository movieRepository

    @SpringBean
    OmdbClient omdbClient = Mock()


    def "should throw exception if there is no movie with provided id"() {
        given:
        def movieId = "123"

        when:
        def movie = moviesService.getMovieDetails(movieId)

        then:
        thrown MovieNotFoundException
    }


    def "should get movie details once they have been added"() {
        given:
        def movieId = "123"

        def movie = Movie.builder()
                .imdbID(movieId)
                .Title("test title")
                .build()
        movieRepository.save(movie)

        when:
        def returnedMovie = moviesService.getMovieDetails(movieId)

        then:
        returnedMovie.title == movie.title
    }
}