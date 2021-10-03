package com.procrastinator.bmsmicroservice.bookmyshow.services;

import com.procrastinator.bmsmicroservice.bookmyshow.enums.ErrorCodes;
import com.procrastinator.bmsmicroservice.bookmyshow.model.Movie;
import com.procrastinator.bmsmicroservice.bookmyshow.repository.MovieRepository;
import com.procrastinator.bmsmicroservice.bookmyshow.repository.UserRepository;
import com.procrastinator.bmsmicroservice.bookmyshow.response.MovieResponse;
import com.procrastinator.bmsmicroservice.bookmyshow.utils.ResponseGenerator;
import com.procrastinator.bmsmicroservice.bookmyshow.validators.impl.UserValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class MovieService {
    /*Add movie
    * Search movie
    * Book movie */

    private UserRepository userRepository;
    private UserValidator userValidator;
    private MovieRepository movieRepository;
    private ResponseGenerator responseGenerator;



    void searchMovie(String cityName,String language){

    }

    public MovieResponse addMovie(Movie movie){
        try {
            Movie movie1= movieRepository.save(movie);
            return responseGenerator.createSuccessResponse(movie1,"Movie added Successfully");
        }catch (Exception e){
            return responseGenerator.createFailedResponse(movie, ErrorCodes.ERR_002.name(), ErrorCodes.ERR_002.getValue());
        }
    }

    void bookMovie(){

    }

    void addMovieState(){

    }
    void updateMovieState(){

    }
}
