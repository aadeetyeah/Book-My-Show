package com.procrastinator.bmsmicroservice.bookmyshow.response;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MovieResponse {

    private int movieID;
    private String movieName;
    private String message;
    private String errorCode;
    private String errorMessage;

}
