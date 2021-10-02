package com.procrastinator.bmsmicroservice.bookmyshow.repository;

import com.procrastinator.bmsmicroservice.bookmyshow.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie,Integer> {
}
