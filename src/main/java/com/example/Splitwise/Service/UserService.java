package com.example.Splitwise.Service;

import com.example.Splitwise.Models.User;
import com.example.Splitwise.Repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
@Transactional
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User registerUser(String name, String phoneNo, String password) throws Exception {
        System.out.println("Starting registering process for phone number: " + phoneNo);

        Optional<User> existingUserOptional = userRepository.findByPhoneNo(phoneNo);

        if (existingUserOptional.isPresent()) {
            System.out.println("User with phone number " + phoneNo + " already exists");
            throw new Exception("User with phone number " + phoneNo + " already exists");

        } else {
            User newUser = new User();
            newUser.setName(name);
            newUser.setPassword(password);
            newUser.setPhoneNo(phoneNo);

            User savedUser = userRepository.save(newUser);

            System.out.println("New user is saved with name: " + savedUser.getName());
            return savedUser;
        }
    }
}
