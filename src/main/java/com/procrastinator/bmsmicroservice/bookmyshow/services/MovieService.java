package com.procrastinator.bmsmicroservice.bookmyshow.services;

import com.procrastinator.bmsmicroservice.bookmyshow.constant.ProjectConstants;
import com.procrastinator.bmsmicroservice.bookmyshow.enums.ErrorCodes;
import com.procrastinator.bmsmicroservice.bookmyshow.factory.ValidatorFactory;
import com.procrastinator.bmsmicroservice.bookmyshow.model.Movie;
import com.procrastinator.bmsmicroservice.bookmyshow.model.MovieState;
import com.procrastinator.bmsmicroservice.bookmyshow.repository.MovieRepository;
import com.procrastinator.bmsmicroservice.bookmyshow.repository.MovieStateRepository;
import com.procrastinator.bmsmicroservice.bookmyshow.repository.UserRepository;
import com.procrastinator.bmsmicroservice.bookmyshow.request.TheatreRequest;
import com.procrastinator.bmsmicroservice.bookmyshow.response.MovieResponse;
import com.procrastinator.bmsmicroservice.bookmyshow.response.MovieStateResponse;
import com.procrastinator.bmsmicroservice.bookmyshow.utils.ResponseGenerator;
import com.procrastinator.bmsmicroservice.bookmyshow.validators.Validator;
import com.procrastinator.bmsmicroservice.bookmyshow.validators.impl.UserValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class MovieService {
    /*Add movie
    * Search movie
    * Book movie */

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserValidator userValidator;

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private ResponseGenerator responseGenerator;

    @Autowired
    private ValidatorFactory validatorFactory;

    @Autowired
    private MovieStateRepository movieStateRepository;


    void searchMovie(String cityName,String language){

    }

    public MovieResponse addMovie(Movie movie){
        try {
            Validator validator=validatorFactory.getValidator(ProjectConstants.MOVIE_VALIDATOR);
            validator.requestValidation(movie);
            Movie movie1= movieRepository.save(movie);
            return responseGenerator.createSuccessResponse(movie1,"Movie added Successfully");
        }catch (Exception e){
            return responseGenerator.createFailedResponse(movie, ErrorCodes.ERR_002.name(), ErrorCodes.ERR_002.getValue());
        }
    }

    void bookMovie(){

    }

    public MovieStateResponse addMovieState(TheatreRequest theatreRequest){
        try{
            if(theatreRequest.getMovieID()==0){
                return responseGenerator.createFailedResponse(theatreRequest.getMovieID(),ErrorCodes.ERR_004.name(), ErrorCodes.ERR_004.getValue());
            }
            Movie movie=movieRepository.getById(theatreRequest.getMovieID());
            if(Objects.nonNull(movie)){
                List<MovieState> movieStates=createMovieState(theatreRequest);
                movieStateRepository.saveAll(movieStates);
                responseGenerator.createSuccessResponse(theatreRequest.getMovieID(),"Movie State added successfully.");

            }else {
                return responseGenerator.createFailedResponse(theatreRequest.getMovieID(),ErrorCodes.ERR_005.name(), ErrorCodes.ERR_005.getValue());
            }
        }catch (Exception e){

        }
        return null;
    }


    private List<MovieState> createMovieState(TheatreRequest theatreRequest){
        List<String> time=theatreRequest.getTime();
        List<String> city=theatreRequest.getCity();
        List<MovieState> movieStates=new ArrayList<>();
        for(int itr1=0;itr1<time.size();itr1++){
            for(int itr2=0;itr2<city.size();itr2++){
                movieStates.add(MovieState.builder().date(theatreRequest.getDate()).time(time.get(itr1))
                        .movieName(theatreRequest.getMovieName())
                        .theatreState(theatreRequest.getTheatreName())
                        .city(city.get(itr2)).duration(theatreRequest.getDuration())
                        .movieID(theatreRequest.getMovieID()).build());
            }
        }
        return movieStates;
    }
    void updateMovieState(){

    }
}
