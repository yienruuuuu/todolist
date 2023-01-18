package com.eric.todolist.service;

import com.eric.todolist.dao.ToDoDao;
import com.eric.todolist.entity.ToDo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * FileName:ToDoService
 *
 * @author Eric
 * @date 2023/1/18下午 04:26
 */
@Service
public class ToDoService {
    @Autowired
    ToDoDao tododao;

    public Iterable<ToDo> getToDos() {
        return tododao.findAll();
    }
}
