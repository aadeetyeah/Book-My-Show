package com.procrastinator.bmsmicroservice.bookmyshow.services;

import com.procrastinator.bmsmicroservice.bookmyshow.constant.ProjectConstants;
import com.procrastinator.bmsmicroservice.bookmyshow.enums.ErrorCodes;
import com.procrastinator.bmsmicroservice.bookmyshow.enums.UserStatusEnum;
import com.procrastinator.bmsmicroservice.bookmyshow.exceptions.RequestValidationException;
import com.procrastinator.bmsmicroservice.bookmyshow.factory.ValidatorFactory;
import com.procrastinator.bmsmicroservice.bookmyshow.model.User;
import com.procrastinator.bmsmicroservice.bookmyshow.repository.MovieRepository;
import com.procrastinator.bmsmicroservice.bookmyshow.repository.UserRepository;
import com.procrastinator.bmsmicroservice.bookmyshow.response.UserResponse;
import com.procrastinator.bmsmicroservice.bookmyshow.utils.ResponseGenerator;
import com.procrastinator.bmsmicroservice.bookmyshow.validators.Validator;
import com.procrastinator.bmsmicroservice.bookmyshow.validators.impl.UserValidator;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.util.Constants;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

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

    @Autowired
    private ValidatorFactory validatorFactory;

    public UserResponse addUser(User user) {
        /* Before Adding a user we need to validate it.
        *
        * Request Validation */
        try {

            Validator validator=validatorFactory.getValidator(ProjectConstants.USER_VALIDATOR);
            validator.requestValidation(user);
            if(Strings.isEmpty(user.getUsername())) {
                throw new RequestValidationException(ErrorCodes.ERR_001.name(), "Need to check!");
            }
            user.setUserStatusEnum(UserStatusEnum.ACTIVE);
            User user1=userRepository.save(user);
            return responseGenerator.createSuccessResponse(user1,"User Added Successfully");

        }catch (RequestValidationException requestValidationException){
            log.error("Exception while Request Validation "+requestValidationException.getMessage());

            return responseGenerator.createFailedResponse(user,requestValidationException.getErrorCode(),requestValidationException.getErrorMessage());

        }catch (Exception e){
            log.error("Unexpected Exception "+e.getMessage());

            return responseGenerator.createFailedResponse(user, ErrorCodes.ERR_002.name(),ErrorCodes.ERR_002.getValue());
        }


    }

    public UserResponse deleteUser(int id) {
        try {
            Optional<User> user = userRepository.findById(id);
            if (Objects.nonNull(user)) {
                userRepository.deleteById(id);
                return responseGenerator.createSuccessResponse(user.get(), "User deleted Successfully");
            }
        }catch (EmptyResultDataAccessException e){
            return  responseGenerator.createFailedResponse((User) null,ErrorCodes.ERR_003.name(), ErrorCodes.ERR_003.getValue());
        }
        return null;
    }

    public List<User> getAllUsers() {

        return userRepository.findAll();

    }
}
