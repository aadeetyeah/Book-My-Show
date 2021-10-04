package com.procrastinator.bmsmicroservice.bookmyshow.request;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TheatreRequest {

    private int movieID;
    private String movieName;
    private String duration;
    private List<String> time;
    private List<String> city;
    private String date;
    private String theatreName;
}
