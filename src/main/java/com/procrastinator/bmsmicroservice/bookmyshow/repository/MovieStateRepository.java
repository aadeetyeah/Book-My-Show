package com.procrastinator.bmsmicroservice.bookmyshow.repository;

import com.procrastinator.bmsmicroservice.bookmyshow.model.MovieState;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieStateRepository extends JpaRepository<MovieState,Integer> {

}
