package com.forever.mybatissingle.dao;

import com.forever.mybatissingle.mode.Person;

import java.util.List;

/**
 * @author: Forever丶诺
 * @date: 2018/4/8 11:09
 */
public interface DynamicIfDao {

    /**
     * selectPersonIf动态sql 语句的演示
     *
     * @param person pojo对象
     * @return
     * @Author: Forever丶诺
     * @Date: 2018/4/8 11:27
     */
    List<Person> selectPersonIf(Person person);

    /**
     * if语句使用时可能引发的错误
     *
     * @param person pojo对象
     * @return
     * @Author: Forever丶诺
     * @Date: 2018/4/8 11:27
     */
    List<Person> selectPersonIfError(Person person);

    /**
     * if标签和where标签结合使用
     *
     * @param person pojo对象
     * @return
     * @Author: Forever丶诺
     * @Date: 2018/4/8 11:27
     */
    List<Person> selectPersonIfAndWhere(Person person);

    /**
     * if标签和Trim标签的结合使用
     *
     * @param person pojo对象
     * @return
     * @Author: Forever丶诺
     * @Date: 2018/4/8 11:27
     */
    List<Person> selectPersonIfAndTrim(Person person);

    /**
     * If标签和set标签结合使用
     *
     * @param person
     */
    void updateDataBySet(Person person);

}
