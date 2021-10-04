package com.procrastinator.bmsmicroservice.bookmyshow.controller;

import com.procrastinator.bmsmicroservice.bookmyshow.constant.RequestConstants;
import com.procrastinator.bmsmicroservice.bookmyshow.model.Movie;
import com.procrastinator.bmsmicroservice.bookmyshow.request.TheatreRequest;
import com.procrastinator.bmsmicroservice.bookmyshow.response.MovieResponse;
import com.procrastinator.bmsmicroservice.bookmyshow.response.MovieStateResponse;
import com.procrastinator.bmsmicroservice.bookmyshow.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class MovieController {
    @Autowired
    private MovieService movieService;

    @PostMapping(RequestConstants.ADD_MOVIE_URI)
    public MovieResponse addUser(@RequestBody Movie movie){

        return  movieService.addMovie(movie);
    }

    @PostMapping(RequestConstants.ADD_MOVIE_STATE_URI)
    public MovieStateResponse addMovieState(@RequestBody TheatreRequest theatreRequest){
        return movieService.addMovieState(theatreRequest);
    }

}
