package com.cts.enums;

import com.fasterxml.jackson.annotation.JsonCreator; 
import com.fasterxml.jackson.annotation.JsonValue;

public enum InspectionRecordStatus {
    SCHEDULED,
    IN_PROGRESS,
    COMPLETED,
    CANCELLED;
	
    @JsonCreator
    public static InspectionRecordStatus fromString(String value) {
        if (value == null) {
            return null;
        }
        return InspectionRecordStatus.valueOf(value.trim().toUpperCase());
    }

   
    @JsonValue
    public String toValue() {
        return this.name();
    }
}