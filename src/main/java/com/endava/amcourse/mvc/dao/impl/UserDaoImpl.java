package com.endava.amcourse.mvc.dao.impl;

import com.endava.amcourse.mvc.dao.UserDao;
import com.endava.amcourse.mvc.model.Gender;
import com.endava.amcourse.mvc.model.Status;
import com.endava.amcourse.mvc.model.User;
import lombok.RequiredArgsConstructor;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Repository
public class UserDaoImpl implements UserDao {

    private final SessionFactory sessionFactory;

    @Override
    public List<User> getAllUsers() {
        return sessionFactory.getCurrentSession()
                .createQuery("SELECT u FROM User u", User.class)
                .getResultList();
    }

    @Override
    public Optional<User> getUserById(int id) {
        return sessionFactory.getCurrentSession()
                .createQuery("SELECT u FROM User u " +
                        "WHERE u.id=:uId", User.class)
                .setParameter("uId", id)
                .getResultList().stream().findFirst();
    }

    @Override
    public User getUserByUsername(String username) {
        return  sessionFactory.getCurrentSession()
                .createQuery("SELECT u FROM User u " +
                        "WHERE u.username=:username", User.class)
                .setParameter("username", username)
                .getSingleResult();
    }

    @Override
    public List<User> getUsersByStatus(Status status) {
        return sessionFactory.getCurrentSession()
                .createQuery("SELECT u FROM User u " +
                        "WHERE u.status=:status", User.class)
                .setParameter("status", status)
                .getResultList();
    }

    @Override
    public List<User> getUsersByGender(Gender gender) {
        return Collections.emptyList(); //TODO implement this method
    }

    @Override
    public void persist(User user) {
        sessionFactory.getCurrentSession().persist(user); //TODO check if it works properly
    }

    @Override
    public void deleteUserById(int userId) {
        sessionFactory.getCurrentSession()
                .createQuery("DELETE FROM User u " +
                        "WHERE u.id=:userId")
                .setParameter("userId", userId)
                .executeUpdate();
    }
}
