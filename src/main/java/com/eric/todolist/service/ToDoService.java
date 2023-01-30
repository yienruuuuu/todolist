package com.eric.todolist.service;

import com.eric.todolist.dao.ToDoDao;
import com.eric.todolist.entity.ToDo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;
import java.util.TimeZone;

/**
 * FileName:ToDoService
 *
 * @author Eric
 * @date 2023/1/18下午 04:26
 */
@Service
public class ToDoService {
    @Autowired
    ToDoDao todoDao;

    public Iterable<ToDo> getTodos() {
        return todoDao.findAll();
    }

    public Integer createTodo(ToDo todo) {
        SimpleDateFormat formatDateToData = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        todo.setCreateTime(formatDateToData.format(new Date()).toString());
        todo.setUpdateTime(formatDateToData.format(new Date()).toString());
        ToDo rltTodo = todoDao.save(todo);
        return rltTodo.getId();
    }

    public Boolean updateTodo(Integer id,ToDo todo) {
        Optional<ToDo> isExistTodo = findById(id);
        if (! isExistTodo.isPresent()) {
            return false;
        }
        ToDo newTodo = isExistTodo.get();
        if (todo.getStatus() == null) {
            return false;
        }
        newTodo.setStatus(todo.getStatus());
        todoDao.save(newTodo);
        return true;
    }

    public Optional<ToDo> findById(Integer id) {
        Optional<ToDo> todo = todoDao.findById(id);
        return todo;
    }

    public Boolean deleteTodo(Integer id) {
        Optional<ToDo> findTodo = findById(id);
        if (!findTodo.isPresent()) {
            return false;
        }
        todoDao.deleteById(id);
        return true;
    }
}
