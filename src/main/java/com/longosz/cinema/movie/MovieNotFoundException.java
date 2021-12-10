package com.longosz.cinema.movie;

class MovieNotFoundException extends RuntimeException {

  MovieNotFoundException(Long id) {
    super("Could not find movie " + id);
  }
}