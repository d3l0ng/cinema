package com.longosz.cinema.movie;

import com.longosz.cinema.movie.domain.Screening;
import com.longosz.cinema.movie.domain.ScreeningId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScreeningsRepository extends JpaRepository<Screening, ScreeningId> {

}
