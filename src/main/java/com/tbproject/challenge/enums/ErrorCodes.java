package com.tbproject.challenge.enums;


/**
 * Enum with some business codes
 */
public enum ErrorCodes {

    ERROR_DATA_VALIDATION("600"),
    OK("200"),
    INTERNAL_SYSTEM_ERROR("500");

    private ErrorCodes(String code) {
        this.code = code;
    }

    private String code;

    public String getCode() {
        return this.code;
    }
}
