package com.eric.todolist.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * FileName:appHelloController
 *
 * @author Eric
 * @date 2023/1/18下午 04:57
 */
@RestController
public class appController {

    @RequestMapping(value = {"/hello123"})
    public ModelAndView greeting(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {
        System.out.println("1111");
        final ModelAndView response = new ModelAndView("hello");
        return response;
    }
}
