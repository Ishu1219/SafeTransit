package com.cts.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum VehicleStatus {
    ACTIVE,
    IN_MAINTENANCE,
    RETIRED;

  
    @JsonCreator
    public static VehicleStatus fromString(String value) {
        if (value == null) {
            return null;
        }
        return VehicleStatus.valueOf(value.trim().toUpperCase());
    }

  
    @JsonValue
    public String toValue() {
        return this.name();
    }
}