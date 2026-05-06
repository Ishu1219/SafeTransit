package com.cts.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum ComplainceOfficer {
    ACTIVE,
    INACTIVE,
    SUSPENDED,
    TERMINATED;

	
    @JsonCreator
    public static ComplainceOfficer fromString(String value) {
        if (value == null) {
            return null;
        }
        return ComplainceOfficer.valueOf(value.trim().toUpperCase());
    }

    
    @JsonValue
    public String toValue() {
        return this.name();
    }
}