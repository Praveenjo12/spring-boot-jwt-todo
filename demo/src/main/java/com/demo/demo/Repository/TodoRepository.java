package com.demo.demo.Repository;

import com.demo.demo.models.Todo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public interface TodoRepository extends MongoRepository<Todo, String> {

}
