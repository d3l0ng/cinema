package com.longosz.cinema.screening.dao;

import com.longosz.cinema.screening.domain.Screening;
import com.longosz.cinema.screening.domain.ScreeningId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScreeningsRepository extends JpaRepository<Screening, ScreeningId> {

}
