package com.procrastinator.bmsmicroservice.bookmyshow.utils;

import com.procrastinator.bmsmicroservice.bookmyshow.enums.UserStatusEnum;
import com.procrastinator.bmsmicroservice.bookmyshow.model.User;
import com.procrastinator.bmsmicroservice.bookmyshow.response.UserResponse;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ResponseGenerator {

    public UserResponse createSuccessResponse( User user){
        return UserResponse.builder().user(user).createdAt(new Date()).build();
    }
    public UserResponse createFailedResponse(User user,String errorCode,String errorMessage){

        return UserResponse.builder().user(user).errorCode(errorCode).errorMessage(errorMessage).createdAt(new Date()).build();
    }
}
