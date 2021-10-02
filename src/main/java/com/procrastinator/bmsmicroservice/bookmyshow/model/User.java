package com.procrastinator.bmsmicroservice.bookmyshow.model;

import com.procrastinator.bmsmicroservice.bookmyshow.enums.UserStatusEnum;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name="User")
public class User {
    @Id
    @GeneratedValue
    private int userID;

    private  String username;
    private  String emailID;
    private  String phoneNo;
    private UserStatusEnum userStatusEnum;
}
