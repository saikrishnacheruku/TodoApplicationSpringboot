// Write your code here

package com.example.todo.repository;

import com.example.todo.model.*;

import java.util.ArrayList;

public interface TodoRepository {
    ArrayList<Todo> getTodos();

    Todo getTodoById(int id);

    Todo addTodo(Todo todo);

    Todo updateTodo(Todo todo, int id);

    void deleteTodo(int id);

}