package com.eric.todolist.entity;
/**
 * @fileName TestTodoEntity
 * @author Eric
 * @date 2023/1/18下午 03:37
 *
 */

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestTodoEntity {
    @Test
    public void WhenGetId_ThenSetId(){
        ToDo todo = new ToDo();
        todo.setId(1);
        Integer expected = 1;
        Integer actual = todo.getId();
        assertEquals(expected,actual);
    }

    @Test
    public void WhenGetTask_ThenSetTask(){
        ToDo todo = new ToDo();
        todo.setTask("洗衣服");
        String expected = "洗衣服";
        String actual = todo.getTask();
        assertEquals(expected,actual);
    }
    @Test
    public void WhenGetStatus_ThenSetStatus(){
        ToDo todo = new ToDo();
        todo.setStatus(0);
        Integer expected = 0;
        Integer actual = todo.getStatus();
        assertEquals(expected,actual);
    }
    @Test
    public void WhenToString(){
        ToDo todo = new ToDo();
        todo.setStatus(0);
        todo.setTask("洗衣服");
        todo.setId(1);
        String toDoStr = todo.toString();
        assertNotNull(toDoStr);
    }
}
