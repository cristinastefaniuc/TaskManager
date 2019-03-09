package com.endava.amcourse.mvc.service;

import com.endava.amcourse.mvc.dto.UserDto;
import com.endava.amcourse.mvc.model.Gender;
import com.endava.amcourse.mvc.model.Status;
import com.endava.amcourse.mvc.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<User> getAllUsers();

    Optional<User> getUserById(int id);

    User getUserByUsername(String username);

    List<User> getUsersByStatus(Status status);

    List<User> getUsersByGender(Gender gender);

    boolean validateUser(UserDto userDto);

    void add(User user);

    void deleteUserById(int userId);

    Optional<User> getUserByName(String username);
}
