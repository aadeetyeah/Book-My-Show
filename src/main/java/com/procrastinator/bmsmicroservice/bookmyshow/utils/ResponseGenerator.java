package com.procrastinator.bmsmicroservice.bookmyshow.utils;

import com.procrastinator.bmsmicroservice.bookmyshow.enums.UserStatusEnum;
import com.procrastinator.bmsmicroservice.bookmyshow.model.Movie;
import com.procrastinator.bmsmicroservice.bookmyshow.model.User;
import com.procrastinator.bmsmicroservice.bookmyshow.response.MovieResponse;
import com.procrastinator.bmsmicroservice.bookmyshow.response.UserResponse;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ResponseGenerator {

    public UserResponse createSuccessResponse( User user,String message){
        return UserResponse.builder().user(user).createdAt(new Date()).message(message).build();
    }
    public UserResponse createFailedResponse(User user,String errorCode,String errorMessage){

        return UserResponse.builder().user(user).errorCode(errorCode).errorMessage(errorMessage).createdAt(new Date()).build();
    }

    public MovieResponse createSuccessResponse(Movie movie, String message){

        return MovieResponse.builder().movieID(movie.getMovieID()).movieName(movie.getMovieName()).message(message).build();
    }
    public MovieResponse createFailedResponse(Movie movie,String errorCode,String errorMessage){

        return MovieResponse.builder().movieName(movie.getMovieName()).errorCode(errorCode).errorMessage(errorMessage).build();
    }
}
