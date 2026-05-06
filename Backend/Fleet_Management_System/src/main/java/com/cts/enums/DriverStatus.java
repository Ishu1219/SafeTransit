package com.cts.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum DriverStatus {
    ACTIVE,
    INACTIVE,
    SUSPENDED,
    TERMINATED;
	
    @JsonCreator
    public static DriverStatus fromString(String value) {
        if (value == null) {
            return null;
        }
        return DriverStatus.valueOf(value.trim().toUpperCase());
    }

    
    @JsonValue
    public String toValue() {
        return this.name();
    }
	
}