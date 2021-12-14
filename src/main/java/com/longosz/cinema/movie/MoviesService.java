package com.longosz.cinema.movie;

import com.longosz.cinema.movie.domain.ClientFeedback;
import com.longosz.cinema.movie.domain.Movie;
import com.longosz.cinema.movie.domain.Screening;
import com.longosz.cinema.ombdb.OmdbClient;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;

@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Transactional
public class MoviesService {

    private final MovieRepository movieRepository;
    private final ClientFeedbackRepository clientFeedbackRepository;
    private final ScreeningsRepository screeningsRepository;
    private final OmdbClient omdbClient;
    @Value("${omdbi.token}")
    private final String omdbiToken;

    private static final Set<String> AVAILABLE_MOVIES = Set.of(
            "tt0232500",
            "tt0322259",
            "tt0463985",
            "tt1013752",
            "tt1596343",
            "tt1905041",
            "tt2820852",
            "tt4630562",
            "tt5433138"
    );

    @PostConstruct
    @Transactional
    public void setupScreenings() {
        AVAILABLE_MOVIES.stream()
                .map(omdbId -> omdbClient.getMovieDetails(omdbiToken, omdbId))
                .forEach(movieRepository::save);
    }


    public Movie getMovieDetails(String movieId) {
        if(movieRepository.existsById(movieId)) {
            return movieRepository.getOne(movieId);
        }

        return omdbClient.getMovieDetails(omdbiToken, movieId);
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
