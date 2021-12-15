package com.longosz.cinema;

import com.longosz.cinema.movie.MoviesService;
import com.longosz.cinema.movie.dao.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import java.util.Set;

@Component
@RequiredArgsConstructor
@Profile("!test")
public class InMemoryMovieLoader {

    private final MoviesService moviesService;
    private final MovieRepository movieRepository;

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
                .map(moviesService::getMovieDetails)
                .forEach(movieRepository::save);
    }
}
