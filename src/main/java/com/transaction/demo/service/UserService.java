package com.transaction.demo.service;

import java.time.Instant;
import java.util.Optional;
import java.util.UUID;

import com.transaction.demo.dto.UserDTO;
import com.transaction.demo.model.User;
import com.transaction.demo.repo.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserService {
    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public UserDTO getUser(Long id) {
        log.info("Get user info for {}", id);
        Optional<User> user = userRepository.findById(id);
        return user.map(item -> {
            UserDTO userDTO = new UserDTO();
            userDTO.setAddress(item.getAddress());
            userDTO.setEmail(item.getEmail());
            userDTO.setName(item.getName());
            userDTO.setPhone(item.getPhone());
            return userDTO;
        }).orElseGet(() -> {
            log.info("User not found for {}", id);
            return new UserDTO();
        });
    }

    @Transactional
    public void printUserDelay(Long id) {
        log.info("Get user info for {}", id);
        while(true) {
            try{
                Thread.sleep(500);
            } catch(Exception e) {
            }
            Optional<User> user = userRepository.findById(id);
            log.info(user.toString());
        }
    }

    @Transactional
    public void updateUserName(UserDTO userInfo) {
        Optional<User> user = userRepository.findById(userInfo.getId());
        user.ifPresent(item -> {
            item.setName(userInfo.getName() + UUID.randomUUID().toString());
            item.setUpdatedTime(Instant.now());
            userRepository.save(item);
        });
    }
}