package com.eric.todolist.controller;

import com.eric.todolist.entity.ToDo;
import com.eric.todolist.service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

/**
 * FileName:ToDoController
 *
 * @author Eric
 * @date 2023/1/18下午 04:37
 */
@RestController
@RequestMapping("/api")
public class ToDoController {
    @Autowired
    ToDoService todoService;

    @GetMapping("/todos")
    public ResponseEntity getTodos() {
        Iterable<ToDo> todoList = todoService.getTodos();
        return ResponseEntity.status(HttpStatus.OK).body(todoList);
    }

    @GetMapping("/todos/{id}")
    public Optional<ToDo> getTodo(@PathVariable Integer id) {
        Optional<ToDo> todo = todoService.findById(id);
        return todo;
    }

    @PostMapping("/todos")
    public ResponseEntity createTodo(@RequestBody ToDo todo) {
        Integer rlt = todoService.createTodo(todo);
        return ResponseEntity.status(HttpStatus.CREATED).body(rlt);
    }

    @PutMapping("/todos/{id}")
    public ResponseEntity upadteTodo(@PathVariable Integer id, @RequestBody ToDo todo) {
        Boolean rlt = todoService.updateTodo(id ,todo);
        if (!rlt) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Status 欄位不能為空");
        }
        return ResponseEntity.status(HttpStatus.OK).body("");
    }

    @DeleteMapping("/todos/{id}")
    public ResponseEntity deleteTodo(@PathVariable Integer id) {
        Boolean rlt = todoService.deleteTodo(id);
        if (!rlt) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Id 不存在");
        }
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("");
    }
}

