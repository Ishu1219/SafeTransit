package com.cts.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum DriverAssignmentStatus {
    ASSIGNED,
    ACTIVE,
    COMPLETED,
    CANCELLED;

    @JsonCreator
    public static DriverAssignmentStatus fromString(String value) {
        return DriverAssignmentStatus.valueOf(value.toUpperCase());
    }

    @JsonValue
    public String toValue() {
        return name();
    }
}