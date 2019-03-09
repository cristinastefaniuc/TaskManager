package com.endava.amcourse.mvc.service.impl;

import com.endava.amcourse.mvc.dao.UserDao;
import com.endava.amcourse.mvc.dto.UserConverter;
import com.endava.amcourse.mvc.dto.UserDto;
import com.endava.amcourse.mvc.model.Gender;
import com.endava.amcourse.mvc.model.Status;
import com.endava.amcourse.mvc.model.User;
import com.endava.amcourse.mvc.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    @Override
    public Optional<User> getUserById(int id) {
        return userDao.getUserById(id);
    }

    @Override
    public User getUserByUsername(String username) {
        return userDao.getUserByUsername(username);
    }

    @Override
    public List<User> getUsersByStatus(Status status) {
        return userDao.getUsersByStatus(status);
    }

    @Override
    public List<User> getUsersByGender(Gender gender) {
        //FIXME: review total user list and create new DAO method
        return userDao.getAllUsers().stream()
                .filter( u -> u.getGender() == gender)
                .collect(Collectors.toList());
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    public boolean validateUser(UserDto userDto) {
        return userDao.getAllUsers().stream()
                .anyMatch(u -> userDto.getUsername().equals(u.getUsername()) && userDto.getPassword().equals(u.getPassword()));
    }

    @Override
    public void add(User user) {
        userDao.persist(user);
    }

    @Override
    public void deleteUserById(int userId) {
        userDao.deleteUserById(userId);
    }

    @Override
    public Optional<User> getUserByName(String username) {
        return userDao.getAllUsers().stream()
                .filter(u -> username.equals(u.getUsername()))
                .findFirst();
    }
}
