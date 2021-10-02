package com.procrastinator.bmsmicroservice.bookmyshow.model;

import com.procrastinator.bmsmicroservice.bookmyshow.enums.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "booking_order")
public class Order {

    @Id
    @GeneratedValue
    private int id;

    private String userID;
    private String movieID;
    private OrderStatus orderStatus;
    private Date createdAt;
    private Date updatedAt;
    //private List<String> seatNo;
    private Date movieTimings;


}
