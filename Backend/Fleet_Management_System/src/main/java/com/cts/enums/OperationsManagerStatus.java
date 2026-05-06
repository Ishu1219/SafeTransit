package com.cts.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum OperationsManagerStatus {
    ACTIVE,
    INACTIVE,
    SUSPENDED,
    TERMINATED;
	
    @JsonCreator
    public static OperationsManagerStatus fromString(String value) {
        if (value == null) {
            return null;
        }
        return OperationsManagerStatus.valueOf(value.trim().toUpperCase());
    }

    
    @JsonValue
    public String toValue() {
        return this.name();
    }
}
