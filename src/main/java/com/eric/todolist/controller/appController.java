package com.eric.todolist.controller;

import com.eric.todolist.entity.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

/**
 * FileName:appHelloController
 *
 * @author Eric
 * @date 2023/1/18下午 04:57
 */
@Controller
public class appController {
    /**
     * 測試thymeleaf的th:text取值功能及th:if判斷功能
     */
    @GetMapping("person")
    public String showGender(Model model) {
        model.addAttribute("hello", "Hello World!!!1231236666");
        model.addAttribute("gender", "female");
        return "hello";
    }

    /**
     * 測試thymeleaf的iterator功能
     */
    @GetMapping("list")
    public String listNumber(Model model) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i <= 10; i++) {
            list.add("This is ArrayList" + i);
        }
        model.addAttribute("list", list);
        return "list";
    }

    /**
     * 測試thymeleaf，以表格實作iterator功能功能-1
     */
    @GetMapping("/form")
    public String form(Model model) {
        // 將Person 實體化
        Person person = new Person();
        model.addAttribute("person", person);
        // 導至form.html
        return "form";
    }

    /**
     * 測試thymeleaf，以表格實作iterator功能功能-2
     */
    @PostMapping("/add")
    public String add(@ModelAttribute Person person, Model model) {
        model.addAttribute("person", person);
        // 導至form.html
        return "add";
    }
}
