package com.forever.mybatissingle.dao;

import com.forever.mybatissingle.mode.Person;

import java.util.List;

/**
 * 动态标签Trim的用法
 *
 * @author: Forever丶诺
 * @date: 2018/4/8 13:32
 */
public interface DynamicTrimDao {

    /**
     * 使用Trim标签代替Where标签
     *
     * @param person
     * @return
     */
    List<Person> getDataByTrimReplaceWhere(Person person);

    /**
     * 使用Trim标签代替set标签
     *
     * @param person
     * @return
     */
    List<Person> updateDataByTrimReplaceSet(Person person);


    /**
     * 多个PrefixOverrides的示例
     *
     * @param person
     * @return
     */
    List<Person> getDataByTrimAndManyPrefixOverrides(Person person);

}
