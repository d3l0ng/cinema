package com.longosz.cinema.movie;

import com.longosz.cinema.movie.dao.ClientFeedbackRepository;
import com.longosz.cinema.movie.dao.MovieRepository;
import com.longosz.cinema.movie.domain.ClientFeedback;
import com.longosz.cinema.movie.domain.Movie;
import com.longosz.cinema.movie.handling.MovieNotFoundException;
import com.longosz.cinema.ombdb.OmdbClient;
import com.longosz.cinema.screening.dao.ScreeningsRepository;
import com.longosz.cinema.screening.domain.Screening;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;

@Component
@RequiredArgsConstructor
@Transactional
public class MoviesService {

    private final MovieRepository movieRepository;
    private final ClientFeedbackRepository clientFeedbackRepository;
    private final ScreeningsRepository screeningsRepository;
    private final OmdbClient omdbClient;
    @Value("${omdbi.token}")
    private final String omdbiToken;

    public Movie getMovieDetails(String movieId) {
        if(movieRepository.existsById(movieId)) {
            return movieRepository.getOne(movieId);
        }

        Movie omdbMovie = omdbClient.getMovieDetails(omdbiToken, movieId);
        if(omdbMovie == null || StringUtils.isBlank(omdbMovie.getTitle())) {
            throw new MovieNotFoundException(movieId);
        }
        movieRepository.save(omdbMovie);
        return omdbMovie;
    }

    public void saveClientFeedback(ClientFeedback toClientFeedback) {
        clientFeedbackRepository.save(toClientFeedback);
    }

    public List<ClientFeedback> getClientFeedbacks(String movieId) {
        return clientFeedbackRepository.findByMovieId(movieId);
    }

    public void saveScreenings(List<Screening> screenings) {
        screeningsRepository.saveAll(screenings);
    }

    public List<Screening> getScreenings() {
        return screeningsRepository.findAll();
    }
}
