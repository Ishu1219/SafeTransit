package com.cts.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum RouteScheduleStatus {
    PLANNED,
    ACTIVE,
    COMPLETED,
    CANCELLED;

    @JsonCreator
    public static RouteScheduleStatus fromString(String value) {
        return RouteScheduleStatus.valueOf(value.toUpperCase());
    }

    @JsonValue
    public String toValue() {
        return name();
    }
}