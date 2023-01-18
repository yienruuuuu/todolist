package com.eric.todolist.controller;

import com.eric.todolist.entity.ToDo;
import com.eric.todolist.service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * FileName:ToDoController
 *
 * @author Eric
 * @date 2023/1/18下午 04:37
 */
@RestController
public class ToDoController {
    @Autowired
    ToDoService toDoService;

    @GetMapping("/todos")
    public Iterable<ToDo> getToDoList(){
        Iterable<ToDo> toDoList = toDoService.getToDos();
        return  toDoList;
    }
}
