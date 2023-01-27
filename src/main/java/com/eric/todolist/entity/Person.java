package com.eric.todolist.entity;
/**
 * @fileName Person
 * @author Eric
 * @date 2023/1/18下午 02:34
 */

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter @Setter
public class Person {

    String name;
    String password;
}
