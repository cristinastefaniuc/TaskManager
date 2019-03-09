package com.endava.amcourse.mvc.dto;

import com.endava.amcourse.mvc.model.User;

public class UserConverter {

    public static UserDto convert(User user) {
        return new UserDto(user.getUsername(), user.getPassword());
    }
}
