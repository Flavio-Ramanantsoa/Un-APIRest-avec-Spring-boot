package com.restapi.service;

import com.restapi.model.User;
import com.restapi.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepo userRepo;

    @Autowired
    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }


    public User findUserById(Long id) {
        return this.userRepo.findById(id).orElseGet(
            () -> new User()
        );
    }

    public List<User> findAllUser() {
        return this.userRepo.findAll();
    }


    public User addUser(User user) {
        this.userRepo.save(user);
        return user;
    }

    public User getUserByEmail(String email) {
        return this.userRepo.findUserByEmail(email);
    }

    public void deleteUserById(Long id) {
        this.userRepo.deleteById(id);
    }
}
