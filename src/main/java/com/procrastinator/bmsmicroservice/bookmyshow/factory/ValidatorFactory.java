package com.procrastinator.bmsmicroservice.bookmyshow.factory;

import com.procrastinator.bmsmicroservice.bookmyshow.constant.ProjectConstants;
import com.procrastinator.bmsmicroservice.bookmyshow.validators.Validator;
import com.procrastinator.bmsmicroservice.bookmyshow.validators.impl.MovieValidator;
import com.procrastinator.bmsmicroservice.bookmyshow.validators.impl.UserValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class ValidatorFactory {

    @Autowired
    private UserValidator userValidator;

    @Autowired
    private MovieValidator movieValidator;

    public Validator getValidator(String validatorType) throws Exception{
        switch(validatorType){
            case ProjectConstants.USER_VALIDATOR:
                return userValidator;
            case ProjectConstants.MOVIE_VALIDATOR:
                return movieValidator;
            default:
                throw new Exception("Not a valid validator Type.");
        }
    }
}
