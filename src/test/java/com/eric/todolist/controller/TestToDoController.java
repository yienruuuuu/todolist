package com.eric.todolist.controller;

import com.eric.todolist.entity.ToDo;
import com.eric.todolist.service.ToDoService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jdk.nashorn.internal.parser.Token;
import org.assertj.core.api.Assert;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.apache.commons.collections4.CollectionUtils;





import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@AutoConfigureMockMvc
public class TestToDoController {
    @MockBean
    ToDoService todoService;

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private MockMvc mockMvc;

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    ObjectMapper objectMapper;

    @Test
    public void testGetTodos() throws Exception {
        // 設定資料
        List<ToDo> expectedList = new ArrayList();
        ToDo todo = new ToDo();
        todo.setTask("洗衣服");
        todo.setId(1);
        expectedList.add(todo);

        // 模擬todoService.getTodos() 回傳 expectedList
        Mockito.when(todoService.getTodos()).thenReturn(expectedList);

        // 模擬呼叫[GET] /api/todos
        String returnString = mockMvc.perform(MockMvcRequestBuilders.get("/api/todos")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn().getResponse().getContentAsString();

        List<ToDo> actualList = objectMapper.readValue(returnString, new TypeReference<List<ToDo>>() {
        });
//        Boolean equalsOrNot = 	isEqualList();
        // 判定回傳的body是否跟預期的一樣
//        assertEquals(expectedList.get(0).getId(), actualList.get(0).getId());
//        Assertions.assertThat(expectedList).isSameAs(actualList);
//        Assertions.assertThat(expectedList).containsAll(actualList);
//        Assertions.assertThat(expectedList).containsExactlyInAnyOrderElementsOf(actualList);

    }
}

