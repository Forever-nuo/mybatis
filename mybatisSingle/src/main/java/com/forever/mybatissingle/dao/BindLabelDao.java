package com.forever.mybatissingle.dao;

import com.forever.mybatissingle.mode.Person;

import java.util.List;

/**
 * @author: Forever丶诺
 * @date: 2018/4/9 9:30
 */
public interface BindLabelDao {

    List<Person> demo1(Person person);

    List<Person> likeSelectByConcat (Person person);

    List<Person> likeSelectByZWF(Person person);
}
