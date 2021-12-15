package com.longosz.cinema.movie.handling;

public class MovieNotFoundException extends RuntimeException {

  public MovieNotFoundException(String id) {
    super("Could not find movie " + id);
  }
}