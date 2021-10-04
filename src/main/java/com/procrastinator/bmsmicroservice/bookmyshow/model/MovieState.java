package com.procrastinator.bmsmicroservice.bookmyshow.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="movie_state")
public class MovieState {
    @Id
    @GeneratedValue
    private int id;

    private int movieID;
    private String movieName;
    private String duration;
    private String time;
    private String city;
    private String date;
    private String theatreState;

}
