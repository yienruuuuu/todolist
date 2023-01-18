package com.eric.todolist.dao;

import com.eric.todolist.entity.ToDo;
import org.springframework.data.repository.CrudRepository;

/*
 * FileName:ToDoDao
 * Author:Eric
 * Date:2023/1/18下午 03:12
 *
 */
// 第一個參數為訪問的實體，第二參數是這個Entity ID的資料型態
public interface ToDoDao  extends CrudRepository<ToDo, Integer> {

}
