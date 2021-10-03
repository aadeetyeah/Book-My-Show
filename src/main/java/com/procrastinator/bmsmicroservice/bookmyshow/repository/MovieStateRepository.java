package com.procrastinator.bmsmicroservice.bookmyshow.repository;

import com.procrastinator.bmsmicroservice.bookmyshow.model.TheatreState;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieStateRepository extends JpaRepository<TheatreState,Integer> {

}
