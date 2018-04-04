package com.forever.mybatissingle.dao;

import com.forever.mybatissingle.mode.Person;

/**
 * @author: Forever丶诺
 * @createTime: 2018-4-3.20:30
 */
public interface PersonDao {

    /**
     * 选择某个人
     *
     * @param id:
     * @return
     * @Author: Forever丶诺
     * @Date: 22:56 2018-4-3
     */
    Person selectPerson(Integer id);

    /**
     * 新增一个用户
     *
     * @param person
     * @return
     */
    int insertPerson(Person person);


    int insertPerson2(Person person);

}
