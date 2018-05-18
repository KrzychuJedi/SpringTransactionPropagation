package com.spring.transactions.service;

import com.spring.transactions.entity.User;
import com.spring.transactions.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional(readOnly = true)
    public void readOnlySaveUser(User user){
        userRepository.save(user);
    }

    @Transactional(readOnly = false)
    public void readWriteSaveUser(User user){
        userRepository.save(user);
    }

    @Transactional(readOnly = true)
    public Optional<User> readOnlyFindById(Long id){
        return userRepository.findById(id);
    }

    @Transactional(readOnly = false)
    public Optional<User> readWriteFindById(Long id){
        return userRepository.findById(id);
    }
}
