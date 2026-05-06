package com.cts.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum FleetManagerStatus {

    ACTIVE,
    INACTIVE,
    SUSPENDED,
    TERMINATED;

  
    @JsonCreator
    public static FleetManagerStatus fromString(String value) {
        if (value == null) {
            return null;
        }
        return FleetManagerStatus.valueOf(value.trim().toUpperCase());
    }

   
    @JsonValue
    public String toValue() {
        return this.name();
    }
}
