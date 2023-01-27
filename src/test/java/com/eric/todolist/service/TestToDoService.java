package com.eric.todolist.service;

import com.eric.todolist.dao.ToDoDao;
import com.eric.todolist.entity.ToDo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * FileName:ToDoService
 *
 * @author Eric
 * @date 2023/1/18下午 04:26
 */
@Service
public class TestToDoService {
    @Autowired
    ToDoDao tododao;

    public Iterable<ToDo> getToDos() {
        return tododao.findAll();
    }

    public Iterable<ToDo> createTodo(ToDo todo) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        df.setTimeZone(TimeZone.getTimeZone("GMT"));
        String date = df.format(new Date());
        todo.setCreateTime(date);
        todo.setUpdateTime(date);
        todo.setStatus(0);
        tododao.save(todo);
        return getToDos();
    }

    public ToDo updateToDo(Integer id, ToDo todo) {
        try {
            ToDo resToDo = findById(id);
            Integer status = todo.getStatus();
            resToDo.setStatus(status);
            return tododao.save(resToDo);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public ToDo findById(Integer id) {
        ToDo todo = tododao.findById(id).get();
        return todo;
    }

    public Boolean deleteToDo(Integer id) {
        try {
            ToDo rsToDo = findById(id);
            tododao.delete(rsToDo);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
