/*
 * You can use the following import statements
 * 
 * import org.springframework.beans.factory.annotation.Autowired;
 * import org.springframework.http.HttpStatus;
 * import org.springframework.stereotype.Service;
 * import org.springframework.web.server.ResponseStatusException;
 * import java.util.*;
 *
 */

// Write your code here

package com.example.todo.service;

import com.example.todo.repository.TodoJpaRepository;
import com.example.todo.repository.TodoRepository;

import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import java.util.*;
import com.example.todo.model.*;

@Service

public class TodoJpaService implements TodoRepository {

    @Autowired
    private TodoJpaRepository todoJpaRepository;

    public ArrayList<Todo> getTodos() {
        List<Todo> todoList = todoJpaRepository.findAll();
        ArrayList<Todo> todos = new ArrayList<>(todoList);

        return todos;
    }

    @Override
    public Todo getTodoById(int id) {

        try {
            Todo todo = todoJpaRepository.findById(id).get();
            return todo;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public Todo addTodo(Todo todo) {

        todoJpaRepository.save(todo);

        return todo;
    }

    @Override
    public Todo updateTodo(Todo todo, int id) {
        try {
            Todo newTodo = todoJpaRepository.findById(id).get();
            if (todo.getStatus() != null) {
                newTodo.setStatus(todo.getStatus());
            }

            todoJpaRepository.save(newTodo);
            return newTodo;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public void deleteTodo(int id) {

        try {
            todoJpaRepository.deleteById(id);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

    }

}
