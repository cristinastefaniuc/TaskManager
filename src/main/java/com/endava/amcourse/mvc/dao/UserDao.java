package com.endava.amcourse.mvc.dao;

import com.endava.amcourse.mvc.model.Gender;
import com.endava.amcourse.mvc.model.Status;
import com.endava.amcourse.mvc.model.User;

import java.util.List;
import java.util.Optional;

public interface UserDao {

    List<User> getAllUsers();

    Optional<User> getUserById(int id);

    User getUserByUsername(String username);

    List<User> getUsersByStatus(Status status);

    List<User> getUsersByGender(Gender gender);

    void persist(User user); // method to save registered user in Database

    void deleteUserById(int userId);

}
