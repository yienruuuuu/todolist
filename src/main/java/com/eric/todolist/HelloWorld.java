package com.eric.todolist;/*
 * FileName:HelloWorld
 * Author:Eric
 * Date:2023/1/18上午 11:39
 *
 */

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorld {
    @RequestMapping("/")
    public String sayHello() {
        return "Hello World";
    }
}
