package com.forever.mybatissingle.dao;

import com.forever.mybatissingle.mode.Person;

import java.util.List;

/**
 * @author: Forever丶诺
 * @date: 2018/4/8 15:12
 */
public interface DynamicIfTestDao {

    /**
     * 测试大于的
     *
     * @param person
     * @return
     */
    List<Person> testNumberGt1(Person person);

    /**
     * 测试小于的 方式1
     *
     * @param person
     * @return
     */
    List<Person> testNumberLt1(Person person);

    /**
     * 多个条件的判断
     *
     * @param person
     * @return
     * @Author: Forever丶诺
     * @Date: 2018/4/8 15:46
     */
    List<Person> testManyCondition(Person person);

    /**
     * 或条件的方式1测试
     *
     * @param person
     * @return
     */
    List<Person> testOr(Person person);


    /**
     * 或条件方式2的测试
     *
     * @param person
     * @return
     */
    List<Person> testOr1(Person person);

}
