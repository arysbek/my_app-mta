package com.arysbek.moneytransferapp.services;

import com.arysbek.moneytransferapp.model.User;
import com.arysbek.moneytransferapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {


    private final UserRepository userRepository;

    public UserService(UserRepository userRepository)
    {
        this.userRepository = userRepository;
    }

    public Iterable<User> fetchAllUsers() {

        return userRepository.findAll();
    }
}
