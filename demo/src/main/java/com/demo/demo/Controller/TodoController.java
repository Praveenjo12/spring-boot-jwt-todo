package com.demo.demo.Controller;

import com.demo.demo.Service.TodoService;
import com.demo.demo.models.Todo;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
    @RequestMapping("/api/v2/todo")
    @Slf4j
    public class TodoController {
        @Autowired
        private TodoService todoService;

        //path variable
        @GetMapping("/{id}")
        ResponseEntity<Todo> gethello(@PathVariable String id){
            try{
                Todo createdtodo =todoService.getTodoById(id);
                return new ResponseEntity<>(todoService.getTodoById(id),HttpStatus.OK);
            } catch (RuntimeException e) {
                log.info("Error");
                log.warn("");
                log.error("",e);
                return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
            }
        }
        //reqparam
        @GetMapping
        ResponseEntity<List<Todo>> getAllTodo(){
            return new ResponseEntity<List<Todo>>(todoService.getAllTodo(),HttpStatus.OK);

        }
        @GetMapping("/page")
        ResponseEntity<Page<Todo>> getTodos(@RequestParam int page, @RequestParam  int size){
            return new ResponseEntity<>(todoService.getallTodoPages(page,size), HttpStatus.OK);
        }
        @PostMapping("/create")
        ResponseEntity<Todo> createUser(@Valid @RequestBody Todo todo){
            return new ResponseEntity<>(todoService.createTodo(todo), HttpStatus.CREATED);
        }
        @PutMapping("/{id}")
        ResponseEntity<Todo> updateTodo(@PathVariable String id,@RequestBody Todo todo){
            return new ResponseEntity<>(todoService.updateTodo(id,todo),HttpStatus.OK);
        }
        @DeleteMapping("/{id}")
        void  DeleteTodobyId(@PathVariable String id){
            todoService.deleteTodoById(id);
        }


    }



