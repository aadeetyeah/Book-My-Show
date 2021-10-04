package com.procrastinator.bmsmicroservice.bookmyshow.validators.impl;

import com.procrastinator.bmsmicroservice.bookmyshow.model.User;
import com.procrastinator.bmsmicroservice.bookmyshow.validators.Validator;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserValidator implements Validator {
    @Override
    public void requestValidation(User user) throws Exception {
        if(user.getUsername().isEmpty() || user.getUsername()==null){
            throw new Exception("User name cannot be empty or null");
        }
        if(user.getEmailID().isEmpty() || user.getEmailID()==null){
            throw new Exception("User emailID cannot be empty or null");
        }
    }

}
