package com.forever.mybatissingle.controller;

import com.forever.mybatissingle.dao.DynamicIfTestDao;
import com.forever.mybatissingle.mode.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author: Forever丶诺
 * @date: 2018/4/8 15:05
 */
@Controller
@RequestMapping("dynamicIfTest")
public class DynamicIfTestController {
    @Autowired
    private DynamicIfTestDao dynamicIfTestDao;

    @RequestMapping("/testNumberGt1")
    @ResponseBody
    public void testNumberGt1() {
        dynamicIfTestDao.testNumberGt1(new Person().setAge(20));
    }

    @RequestMapping("/testNumberLt1")
    @ResponseBody
    public void testNumberLt1() {
        dynamicIfTestDao.testNumberLt1(new Person().setAge(9));
    }

    @RequestMapping("/testManyCondition")
    @ResponseBody
    public void testManyCondition() {
        dynamicIfTestDao.testManyCondition(new Person().setName("王五"));
    }

    /**
     * 或条件的测试
     *
     * @Author: Forever丶诺
     * @Date: 2018/4/8 15:55
     */
    @RequestMapping("/testOr")
    @ResponseBody
    public void testOr() {
        dynamicIfTestDao.testOr(new Person().setName("赵六"));
    }

    /**
     * 或条件的测试
     *
     * @Author: Forever丶诺
     * @Date: 2018/4/8 15:55
     */
    @RequestMapping("/testOr1")
    @ResponseBody
    public void testOr1() {
        dynamicIfTestDao.testOr1(new Person().setName("张三"));
    }

}
