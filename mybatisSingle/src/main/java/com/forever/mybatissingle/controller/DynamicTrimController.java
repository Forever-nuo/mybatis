package com.forever.mybatissingle.controller;

import com.forever.mybatissingle.dao.DynamicIfDao;
import com.forever.mybatissingle.dao.DynamicTrimDao;
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
@RequestMapping("dynamicTrim")
public class DynamicTrimController {

    @Autowired
    private DynamicTrimDao dynamicTrimDao;

    /**
     * 使用Trim标签代替Where标签
     *
     * @Author: Forever丶诺
     * @Date: 2018/4/8 13:41
     */
    @RequestMapping("/getDataByTrimReplaceWhere")
    @ResponseBody
    public void selectPersonIfAndTrim() {
        dynamicTrimDao.getDataByTrimReplaceWhere(new Person().setAge(10).setName("张三"));
    }

    /**
     * 使用Trim标签代替Where标签
     *
     * @Author: Forever丶诺
     * @Date: 2018/4/8 13:41
     */
    @RequestMapping("/updateDataByTrimReplaceSet")
    @ResponseBody
    public void updateDataByTrimReplaceSet() {
        dynamicTrimDao.updateDataByTrimReplaceSet(new Person().setAge(15).setName("张三").setId(7));
    }

    /**
     * Trim中多个Override的示例
     *
     * @Author: Forever丶诺
     * @Date: 2018/4/8 13:41
     */
    @RequestMapping("/getDataByTrimAndManyPrefixOverrides")
    @ResponseBody
    public void getDataByTrimAndManyPrefixOverrides() {
        dynamicTrimDao.getDataByTrimAndManyPrefixOverrides(new Person());
    }

}
