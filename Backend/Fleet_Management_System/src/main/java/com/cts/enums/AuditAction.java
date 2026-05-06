package com.cts.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum AuditAction {
	ACTIVE,
    INACTIVE,
    SUSPENDED,
    PENDING_VERIFICATION,
    DELETED,
    SUBMITTED,
    VERIFIED;
	@JsonCreator
	public static AuditAction fromString(String value) {
	    if (value == null) {
	        return null;
	    }
	    return AuditAction.valueOf(value.trim().toUpperCase());
	}

    @JsonValue
    public String toValue() {
        return name();
    }
}
