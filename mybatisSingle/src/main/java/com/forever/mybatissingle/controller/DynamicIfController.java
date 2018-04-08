package com.forever.mybatissingle.controller;

import com.forever.mybatissingle.dao.DynamicIfDao;
import com.forever.mybatissingle.mode.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 动态sql语句的演示
 *
 * @author: Forever丶诺
 * @date: 2018/4/8 11:06
 */
@Controller
@RequestMapping("dynamicIf")
public class DynamicIfController {

    @Autowired
    private DynamicIfDao dynamicIfDao;

    @RequestMapping("/selectPersonIfNoName")
    @ResponseBody
    public void selectPersonIfNoName() {
        dynamicIfDao.selectPersonIf(new Person().setAge(10));

    }

    @RequestMapping("/selectPersonIfNoAge")
    @ResponseBody
    public void selectPersonIfNoAge() {
        dynamicIfDao.selectPersonIf(new Person().setName("张三"));
    }

    /**
     * if 错误的演示
     *
     * @param
     * @Author: Forever丶诺
     * @Date: 2018/4/8 11:41
     */
    @RequestMapping("/selectPersonIfError")
    @ResponseBody
    public void selectPersonIfError() {
        dynamicIfDao.selectPersonIfError(new Person());
    }

    /**
     * if和where 结合  没有条件
     *
     * @param
     * @Author: Forever丶诺
     * @Date: 2018/4/8 11:41
     */
    @RequestMapping("/selectPersonIfAndWhereNoCondition")
    @ResponseBody
    public void selectPersonIfAndWhereNoCondition() {
        dynamicIfDao.selectPersonIfAndWhere(new Person());
    }

    /**
     * if和where 结合  没有条件
     *
     * @param
     * @Author: Forever丶诺
     * @Date: 2018/4/8 11:41
     */
    @RequestMapping("/selectPersonIfAndWhereHasCondition")
    @ResponseBody
    public void selectPersonIfAndWhereHasCondition() {
        dynamicIfDao.selectPersonIfAndWhere(new Person().setAge(10).setName("张三"));
    }

    /**
     * If标签和Trim标签的结合使用
     *
     * @Author: Forever丶诺
     * @Date: 2018/4/8 13:03
     */
    @RequestMapping("/selectPersonIfAndTrim")
    @ResponseBody
    public void selectPersonIfAndTrim() {
        dynamicIfDao.selectPersonIfAndTrim(new Person().setAge(10).setName("张三"));
    }

    @RequestMapping("/updateDataBySet")
    @ResponseBody
    public void updateDataBySet() {
        dynamicIfDao.updateDataBySet(new Person().setAge(22).setName("张三update").setId(18));
    }

}
