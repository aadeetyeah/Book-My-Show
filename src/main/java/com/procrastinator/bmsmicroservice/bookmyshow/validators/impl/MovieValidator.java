package com.procrastinator.bmsmicroservice.bookmyshow.validators.impl;

import com.procrastinator.bmsmicroservice.bookmyshow.model.Movie;
import com.procrastinator.bmsmicroservice.bookmyshow.model.User;
import com.procrastinator.bmsmicroservice.bookmyshow.validators.Validator;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MovieValidator implements Validator {
    @Override
    public void requestValidation(Movie movie) throws Exception {
        if(movie.getMovieName().isEmpty() || movie.getMovieName()==null){
            throw new Exception("Movie name cannot be empty or null");
        }
        if(movie.getPrice()==0){
            throw new Exception("Movie Price cannot be zero.");
        }
    }
}
