package com.procrastinator.bmsmicroservice.bookmyshow.services;

import com.procrastinator.bmsmicroservice.bookmyshow.enums.ErrorCodes;
import com.procrastinator.bmsmicroservice.bookmyshow.enums.UserStatusEnum;
import com.procrastinator.bmsmicroservice.bookmyshow.exceptions.RequestValidationException;
import com.procrastinator.bmsmicroservice.bookmyshow.model.User;
import com.procrastinator.bmsmicroservice.bookmyshow.repository.MovieRepository;
import com.procrastinator.bmsmicroservice.bookmyshow.repository.UserRepository;
import com.procrastinator.bmsmicroservice.bookmyshow.response.UserResponse;
import com.procrastinator.bmsmicroservice.bookmyshow.utils.ResponseGenerator;
import com.procrastinator.bmsmicroservice.bookmyshow.validators.impl.UserValidator;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private UserValidator userValidator;

    @Autowired
    private ResponseGenerator responseGenerator;

    public UserResponse addUser(User user) {
        /* Before Adding a user we need to validate it.
        *
        * Request Validation */
        try {
            log.info("Adding new user :" +user.toString());
            if(Strings.isEmpty(user.getUsername())) {
                throw new RequestValidationException(ErrorCodes.ERR_001.name(), "Need to check!");
            }
            user.setUserStatusEnum(UserStatusEnum.ACTIVE);
            User user1=userRepository.save(user);
            return responseGenerator.createSuccessResponse(user1);

        }catch (RequestValidationException requestValidationException){
            log.error("Exception while Request Validation "+requestValidationException.getMessage());

            return responseGenerator.createFailedResponse(user,requestValidationException.getErrorCode(),requestValidationException.getErrorMessage());

        }catch (Exception e){
            log.error("Unexpected Exception "+e.getMessage());

            return responseGenerator.createFailedResponse(user, ErrorCodes.ERR_002.name(),e.getMessage());
        }


    }

    public UserResponse deleteUser(int id) {
        return  null;
    }
}
