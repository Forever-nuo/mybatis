package com.forever.mybatissingle.dao;

import com.forever.mybatissingle.mode.Person;

/**
 * @author: Forever丶诺
 * @createTime: 2018-4-3.20:30
 */
public interface PersonDao {

    Person selectPerson(Integer id);
}
