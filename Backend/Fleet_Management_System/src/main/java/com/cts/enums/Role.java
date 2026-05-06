package com.cts.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum Role {
	PASSENGER,
    DRIVER,
    CONDUCTOR,
    DISPATCHER,
    FLEET_MANAGER,
    OPERATIONS_MANAGER,
    ADMINISTRATOR,
    COMPLIANCE_OFFICER,
    AUDITOR;
	
    @JsonCreator
    public static Role fromString(String value) {
        if (value == null) {
            return null;
        }
        return Role.valueOf(value.trim().toUpperCase());
    }

   
    @JsonValue
    public String toValue() {
        return this.name();
    }
}
