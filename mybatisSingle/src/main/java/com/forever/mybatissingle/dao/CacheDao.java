package com.forever.mybatissingle.dao;

import com.forever.mybatissingle.mode.Person;

import java.util.List;

/**
 * @author: Forever丶诺
 * @date: 2018/4/9 10:12
 */
public interface CacheDao {

    /**
     * 获取所有的用户
     *
     * @return
     */
    List<Person> getAllPerson();

    /**
     * 获取某个用户
     *
     * @param id
     * @return
     */
    Person getPersonById(Integer id);

    /**
     * 更新用户
     * @param person
     * @return
     */
    void updatePerson(Person person);

    /**
     * 更新数据 不刷新缓存
     *
     * @param person
     */
    void updatePersonNoFlushCache(Person person);
}
