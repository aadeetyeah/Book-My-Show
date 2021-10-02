package com.procrastinator.bmsmicroservice.bookmyshow.repository;

import com.procrastinator.bmsmicroservice.bookmyshow.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {

}
