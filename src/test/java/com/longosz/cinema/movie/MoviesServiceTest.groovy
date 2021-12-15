package com.longosz.cinema.movie


import com.longosz.cinema.movie.dao.ClientFeedbackRepository
import com.longosz.cinema.movie.dao.MovieRepository
import com.longosz.cinema.movie.domain.Movie
import com.longosz.cinema.ombdb.OmdbClient
import com.longosz.cinema.screening.dao.ScreeningsRepository
import spock.lang.Specification

class MoviesServiceTest extends Specification {

    def "should return movie from db" (){
        given:
        def movieRepository = Mock(MovieRepository)
        def clientFeedbackRepository = Mock(ClientFeedbackRepository)
        def screeningsRepository = Mock(ScreeningsRepository)
        def omdbClient = Mock(OmdbClient)
        def omdbiToken = "token"
        def service = new MoviesService(
                movieRepository,
                clientFeedbackRepository,
                screeningsRepository,
                omdbClient,
                omdbiToken
        )
        def movieId = "123"
        def mockMovie = Movie.builder()
                .Title("test")
                .build()

        when:
        def returnedMovie = service.getMovieDetails(movieId)

        then:
        1 * movieRepository.existsById(movieId) >> true
        1 * movieRepository.getOne(movieId) >> mockMovie
        returnedMovie == mockMovie
    }
}
