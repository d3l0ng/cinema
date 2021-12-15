package com.longosz.cinema.movie.dao;

import com.longosz.cinema.movie.domain.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, String> {
}
