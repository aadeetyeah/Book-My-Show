package com.procrastinator.bmsmicroservice.bookmyshow.enums;

import lombok.Getter;

public enum ErrorCodes {




    ERR_001("User name cannot be null or empty"),
    ERR_002("Unexpected Error!!!!"),
    ERR_003("User not found!!");

    @Getter
    private final String value;

    ErrorCodes(String value) {
        this.value = value;
    }
}
