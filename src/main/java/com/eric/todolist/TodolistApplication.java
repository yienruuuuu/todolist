package com.eric.todolist;

import com.eric.todolist.dao.ToDoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.net.InetAddress;


@SpringBootApplication
public class TodolistApplication {

    public static void main(String[] args) {
        SpringApplication.run(TodolistApplication.class, args);

        try {
            InetAddress addr = InetAddress.getLocalHost();
            System.out.println("Local HostAddress: " + addr.getHostAddress());
            Runtime.getRuntime().exec("cmd   /c   start   http://localhost:8080/swagger-ui.html");//可以指定自己的路径
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
