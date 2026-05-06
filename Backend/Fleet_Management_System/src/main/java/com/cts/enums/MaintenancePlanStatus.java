package com.cts.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum MaintenancePlanStatus {
    ACTIVE,
    PAUSED,
    COMPLETED;
	@JsonCreator
    public static MaintenancePlanStatus fromString(String value) {
        if (value == null) {
            return null;
        }
        return MaintenancePlanStatus.valueOf(value.trim().toUpperCase());
    }

   
    @JsonValue
    public String toValue() {
        return this.name();
    }
}