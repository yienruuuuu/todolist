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
import java.util.Optional;
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

    @Test
    public void testUpdateTodoSuccess () {
        // 準備資料
        ToDo todo = new ToDo();
        todo.setId(1);
        todo.setTask("寫鐵人賽文章");
        todo.setStatus(1);
        Optional<ToDo> resTodo = Optional.of(todo);

        // 模擬呼叫todoDao.findById(id) 回傳的資料
        Mockito.when(tododao.findById(1)).thenReturn(resTodo);

        // [Arrange] 更改的資料
        todo.setStatus(2);

        // [Act] 實際呼叫操作todoService.createTodo
        Boolean actualUpdateRlt = todoService.updateTodo(1, todo);

        //  [Assert] 預期與實際的資料
        assertEquals(true, actualUpdateRlt);
    }

    @Test
    public void testUpdateTodoNotExistId () {
        // 準備更改的資料
        ToDo todo = new ToDo();
        todo.setStatus(2);
        Optional<ToDo> resTodo = Optional.of(todo);

        // 模擬呼叫todoDao.findById(id)，資料庫沒有id=100的資料 回傳empty物件
        Mockito.when(tododao.findById(100)).thenReturn(Optional.empty());

        // [Act] 實際呼叫操作todoService.updateTodo()
        Boolean actualUpdateRlt = todoService.updateTodo(100, todo);

        // [Assert] 預期與實際的資料
        assertEquals(false, actualUpdateRlt);
    }

    @Test
    public void testUpdateTodoOccurException () {
        // 準備更改的資料
        ToDo todo = new ToDo();
        todo.setId(1);
        todo.setStatus(1);
        Optional<ToDo> resTodo = Optional.of(todo);

        // 模擬呼叫todoDao.findById(id)，資料庫有id=1的資料
        Mockito.when(tododao.findById(1)).thenReturn(resTodo);
        todo.setStatus(2);

        // 模擬呼叫todoDao.save(todo)時發生NullPointerException例外
        Mockito.doThrow(NullPointerException.class).when(tododao).save(todo);

        // [Act] 實際呼叫操作todoService.updateTodo()
        Boolean actualUpdateRlt = todoService.updateTodo(100, todo);

        //  [Assert] 預期與實際的資料
        assertEquals(false, actualUpdateRlt);
    }
    @Test
    public void testDeleteTodoSuccess () {
        //準備更改的資料
        ToDo todo = new ToDo();
        todo.setId(1);
        todo.setTask("鐵人賽文章");
        todo.setStatus(2);
        Optional<ToDo> resTodo = Optional.of(todo);

        // 模擬呼叫todoDao.findById(id)，模擬資料庫有id=1的資料
        Mockito.when(tododao.findById(1)).thenReturn(resTodo);

        // [Act] 實際呼叫操作todoService.deleteTodo()
        Boolean actualDeleteRlt = todoService.deleteTodo(1);

        //  [Assert] 預期與實際的資料
        assertEquals(true, actualDeleteRlt);
    }

    @Test
    public void testDeleteTodoIdNotExist () {
        //準備更改的資料
        ToDo todo = new ToDo();
        todo.setId(1);
        todo.setTask("鐵人賽文章");
        todo.setStatus(2);
        Optional<ToDo> resTodo = Optional.of(todo);

        // 模擬呼叫todoDao.findById(id)，並模擬資料庫沒有id=100的資料
        Mockito.when(tododao.findById(100)).thenReturn(Optional.empty());

        // [Act] 實際呼叫操作todoService.deleteTodo()
        Boolean actualDeleteRlt = todoService.deleteTodo(100);

        //  [Assert] 預期與實際的資料
        assertEquals(false, actualDeleteRlt);
    }

    @Test
    public void testDeleteTodoOccurException () {
        //準備更改的資料
        ToDo todo = new ToDo();
        todo.setId(1);
        todo.setTask("鐵人賽文章");
        todo.setStatus(2);
        Optional<ToDo> resTodo = Optional.of(todo);

        // 模擬呼叫todoDao.findById(id)，並模擬資料庫有id=1的資料
        Mockito.when(tododao.findById(1)).thenReturn(resTodo);

        // 模擬呼叫todoDao.deleteById(id)，會發生NullPointerException
        Mockito.doThrow(NullPointerException.class).when(tododao).deleteById(1);

        // [Act] 實際呼叫操作todoService.deleteTodo()
        Boolean actualDeleteRlt = todoService.deleteTodo(1);

        //  [Assert] 預期與實際的資料
        assertEquals(false, actualDeleteRlt);
    }
}
