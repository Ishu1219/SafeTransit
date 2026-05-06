package com.cts.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum UserStatus {
	USER_REGISTERED,
    USER_UPDATED,
    USER_DEACTIVATED,
    USER_DELETED,
    USER_SUSPENDED,
    PASSWORD_CHANGED,
    LOGIN_SUCCESS,
    LOGIN_FAILED,
    LOGOUT,
    ROLE_CHANGED,
    TOKEN_REFRESHED,
    PENDING_VERIFICATION,
    ACCOUNT_LOCKED,
    PASSWORD_RESET_REQUESTED,
    PASSWORD_RESET_COMPLETED,
    ACTIVE;
	
    @JsonCreator
    public static UserStatus fromString(String value) {
        if (value == null) {
            return null;
        }
        return UserStatus.valueOf(value.trim().toUpperCase());
    }

    
    @JsonValue
    public String toValue() {
        return this.name();
    }
}
