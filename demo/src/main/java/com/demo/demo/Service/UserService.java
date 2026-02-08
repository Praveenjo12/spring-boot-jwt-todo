package com.demo.demo.Service;


import com.demo.demo.Repository.UserRepository;
import com.demo.demo.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserService {

        @Autowired
        private UserRepository userRepository;


        public User createUser(User user){
             return userRepository.save(user);
        }
        public User getUserById(String id){
            return userRepository.findById(id).orElseThrow(()-> new RuntimeException("Todo not Found"));
        }
        public List<User> getAllTodo(){
             return userRepository.findAll();

        }
    }


