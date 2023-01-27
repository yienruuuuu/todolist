package com.eric.todolist.controller;

import com.eric.todolist.entity.ToDo;
import com.eric.todolist.service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * FileName:ToDoController
 *
 * @author Eric
 * @date 2023/1/18下午 04:37
 */
@Controller
public class ToDoController {
    @Autowired
    ToDoService toDoService;

    @GetMapping("/todos")
    public String getToDoList(Model model) {
        Iterable<ToDo> todoList = toDoService.getToDos();
        model.addAttribute("todolist", todoList);
        ToDo todo = new ToDo();
        model.addAttribute("todoObject", todo);
        return "todolist";
    }

    @PostMapping("/todos")
    public String createTodo(@ModelAttribute ToDo todo, Model model) {
        Iterable<ToDo> allTodoList = toDoService.createTodo(todo);
        ToDo emptyTodo = new ToDo();
        model.addAttribute("todolist", allTodoList);
        model.addAttribute("todoObject", emptyTodo);
        return "todolist";
    }

    @ResponseBody
    @PutMapping("/todos/{id}")
    public void upadteTodo(@PathVariable Integer id, @RequestBody ToDo todo) {
        toDoService.updateToDo(id, todo);
    }

    @ResponseBody
    @DeleteMapping("/todos/{id}")
    public void deleteTodo(@PathVariable Integer id) {
        toDoService.deleteToDo(id);
    }

}
