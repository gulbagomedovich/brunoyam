package com.brunoyam.springjpademo.service;

import com.brunoyam.springjpademo.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    User getUser(Long id);

    void addUser(User user);

    void updateUser(Long id, User user);

    void deleteUser(Long id);
}
