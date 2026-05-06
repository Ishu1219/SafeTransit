package com.cts.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum ReportingPeriod {
    DAILY,
    WEEKLY,
    MONTHLY,
    YEARLY;

    @JsonCreator
    public static ReportingPeriod fromString(String value) {
        if (value == null) {
            return null;
        }
        return ReportingPeriod.valueOf(value.trim().toUpperCase());
    }

   
    @JsonValue
    public String toValue() {
        return this.name();
    }
}