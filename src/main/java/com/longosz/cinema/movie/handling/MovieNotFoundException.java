package com.longosz.cinema.movie.handling;

class MovieNotFoundException extends RuntimeException {

  MovieNotFoundException(Long id) {
    super("Could not find movie " + id);
  }
}