package com.cts.mapper;

import com.cts.entity.User;
import com.cts.enums.Role;
import com.cts.enums.UserStatus;

public class UserMapper {

	
    public static User createUser(
            String name,
            String email,
            String phone,
            String password,
            Role role
    ) {
        return User.builder()
                .name(name)
                .email(email)
                .phone(phone)
                .password(password)   
                .role(role)
                .status(UserStatus.USER_REGISTERED)
                .build();
    }

    public static void updateUser(
            User user,
            String name,
            String phone,
            UserStatus status
    ) {
        if (name != null) user.setName(name);
        if (phone != null) user.setPhone(phone);
        if (status != null) user.setStatus(status);
    }
}