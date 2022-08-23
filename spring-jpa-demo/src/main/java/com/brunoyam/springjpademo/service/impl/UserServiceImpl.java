package com.brunoyam.springjpademo.service.impl;

import com.brunoyam.springjpademo.model.User;
import com.brunoyam.springjpademo.repository.UserRepository;
import com.brunoyam.springjpademo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUser(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            return optionalUser.get();
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "Пользователь с идентификатором " + id + " не найден");
        }
    }

    @Override
    public void addUser(User user) {
        userRepository.save(user);
    }

    @Override
    public void updateUser(Long id, User user) {
        User savedUser = getUser(id);

        savedUser.setId(user.getId());
        savedUser.setName(user.getName());
        savedUser.setAge(user.getAge());

        userRepository.save(savedUser);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
