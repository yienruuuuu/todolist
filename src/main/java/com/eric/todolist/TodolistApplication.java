package com.eric.todolist;

import com.eric.todolist.dao.ToDoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class TodolistApplication {

    public static void main(String[] args) {
                SpringApplication.run(TodolistApplication.class, args);
    }

}
