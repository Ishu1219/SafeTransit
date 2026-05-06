package com.cts.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum Sex {
    MALE,
    FEMALE,
    OTHER;

  
    @JsonCreator
    public static Sex fromString(String value) {
        if (value == null) {
            return null;
        }
        return Sex.valueOf(value.trim().toUpperCase());
    }

  
    @JsonValue
    public String toValue() {
        return this.name();
    }
}