package com.demo.demo.Repository;

import com.demo.demo.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User, String> { // Change Long to String
    Optional<User> findByEmail(String email);
}
