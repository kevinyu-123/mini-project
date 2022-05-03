package com.travel.proj.service;

import com.travel.proj.model.User;
import com.travel.proj.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;


@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Transactional
    public void register(User user){
        userRepository.save(user);
    }

}
