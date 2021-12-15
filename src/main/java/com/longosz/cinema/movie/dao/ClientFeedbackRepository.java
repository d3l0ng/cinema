package com.longosz.cinema.movie.dao;

import com.longosz.cinema.movie.domain.ClientFeedback;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClientFeedbackRepository extends JpaRepository<ClientFeedback, Integer> {
    List<ClientFeedback> findByMovieId(String movieId);
}
