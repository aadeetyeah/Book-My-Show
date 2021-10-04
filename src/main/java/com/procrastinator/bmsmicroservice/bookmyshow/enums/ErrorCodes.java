package com.procrastinator.bmsmicroservice.bookmyshow.enums;

import lombok.Getter;

public enum ErrorCodes {




    ERR_001("User name cannot be null or empty"),
    ERR_002("Unexpected Error!!!!"),
    ERR_003("User not found!!"),
    ERR_004("Movie ID is not available."),
    ERR_005("Movie is not available");

    @Getter
    private final String value;

    ErrorCodes(String value) {
        this.value = value;
    }
}
