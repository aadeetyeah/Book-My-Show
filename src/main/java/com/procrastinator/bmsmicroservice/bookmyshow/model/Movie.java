package com.procrastinator.bmsmicroservice.bookmyshow.model;

import com.procrastinator.bmsmicroservice.bookmyshow.enums.CityNameEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Movie")
public class Movie {
    @Id
    @GeneratedValue
    private int movieID;

    private String movieName;
    private String duration;
    private CityNameEnum city;
    private float price;
}
