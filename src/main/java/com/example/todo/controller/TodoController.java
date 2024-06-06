/*
 * You can use the following import statements
 *
 * import org.springframework.beans.factory.annotation.Autowired;
 * import org.springframework.web.bind.annotation.*;
 * import java.util.*;
 * 
 */

// Write your code here

package com.example.todo.controller;

import com.example.todo.model.*;
import com.example.todo.service.*;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TodoController {
    @Autowired
    public TodoJpaService todoService;

    @GetMapping("/todos")
    public ArrayList<Todo> getTodos() {
        return todoService.getTodos();
    }

    @GetMapping("/todos/{id}")
    public Todo getTodoById(@PathVariable("id") int id) {
        return todoService.getTodoById(id);
    }

    @PostMapping("/todos")
    public Todo addTodo(@RequestBody Todo todo) {
        return todoService.addTodo(todo);
    }

    @PutMapping("/todos/{id}")
    public Todo updateTodo(@RequestBody Todo todo, @PathVariable("id") int id) {
        return todoService.updateTodo(todo, id);
    }

    @DeleteMapping("/todos/{id}")
    public void deleteTodo(@PathVariable("id") int id) {
        todoService.deleteTodo(id);
    }

}
