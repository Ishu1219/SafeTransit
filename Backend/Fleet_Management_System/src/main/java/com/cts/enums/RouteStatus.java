package com.cts.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum RouteStatus {
    ACTIVE,
    INACTIVE;

    
    @JsonCreator
    public static RouteStatus fromString(String value) {
        if (value == null) {
            return null;
        }
        return RouteStatus.valueOf(value.trim().toUpperCase());
    }

    
    @JsonValue
    public String toValue() {
        return this.name();
    }
}