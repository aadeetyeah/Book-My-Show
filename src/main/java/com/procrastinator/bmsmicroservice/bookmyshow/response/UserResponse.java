package com.procrastinator.bmsmicroservice.bookmyshow.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.procrastinator.bmsmicroservice.bookmyshow.enums.UserStatusEnum;
import com.procrastinator.bmsmicroservice.bookmyshow.model.User;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)   /*Null Response can be avoided to be shown by this Annotation */
public class UserResponse {

    private User user;
    private Date createdAt;
    private String errorCode;
    private String errorMessage;
}
