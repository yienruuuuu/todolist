package com.eric.todolist.service;

import com.eric.todolist.dao.ToDoDao;
import com.eric.todolist.entity.ToDo;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * FileName:ToDoService
 *
 * @author Eric
 * @date 2023/1/18下午 04:26
 */
@SpringBootTest
public class TestToDoService {
    @Autowired
    ToDoService todoService;

    @MockBean
    ToDoDao tododao;

    @Test
    public void testGetTodos () {
        // [Arrange] 預期資料
        List<ToDo> expectedTodosList = new ArrayList();
        ToDo todo = new ToDo();
        todo.setId(1);
        todo.setTask("洗衣服");
        todo.setStatus(1);
        expectedTodosList.add(todo);

        // 定義模擬呼叫todoDao.findAll() 要回傳的預設結果
        Mockito.when(tododao.findAll()).thenReturn(expectedTodosList);

        // [Act]操作todoService.getTodos();
        Iterable<ToDo> actualTodoList = todoService.getTodos();

        // [Assert] 預期與實際的資料
        assertEquals(expectedTodosList, actualTodoList);
    }

    @Test
    public void testCreateTodo () {
        // [Arrange] 準備資料
        ToDo todo = new ToDo();
        todo.setId(1);
        todo.setTask("寫鐵人賽文章");
        todo.setStatus(1);

        // 模擬呼叫todoDao.save(todo) 的回傳結果
        Mockito.when(tododao.save(todo)).thenReturn(todo);

        // [Act] 實際呼叫操作todoService.createTodo
        Integer actualId = todoService.createTodo(todo);

        //  [Assert] 預期與實際的資料
        assertEquals(1, actualId);
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
