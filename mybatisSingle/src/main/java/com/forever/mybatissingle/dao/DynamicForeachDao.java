package com.forever.mybatissingle.dao;

import com.forever.mybatissingle.mode.Person;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author: Forever丶诺
 * @date: 2018/4/8 16:19
 */
public interface DynamicForeachDao {

    /**
     * 得到所有personMap 形式
     *
     * @return
     */
    List<Map> getAllPersonMap();

    /**
     * foreach List
     *
     * @param ids
     * @return
     */
    List<Person> testListHasAnnotation(@Param("ids") List<Integer> ids);

    /**
     * List 没有param注解
     *
     * @param ids
     * @return
     */
    List<Person> testList(List<Integer> ids);

    /**
     * array 没有param注解
     *
     * @param ids
     * @return
     */
    List<Person> testArray(Integer[] ids);

    /**
     * 使用Pojo 封装 List
     *
     * @param person
     * @return
     * @Author: Forever丶诺
     * @Date: 2018/4/8 17:01
     */
    List<Person> testObjIds(Person person);

    /**
     * 测试 List中是Map的元素
     *
     * @param allPersonMap
     */
    void testMapList(List<Map> allPersonMap);

    void testMap(@Param("map") Map map);
}
