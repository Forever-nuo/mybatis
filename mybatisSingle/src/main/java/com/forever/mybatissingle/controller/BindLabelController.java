package com.forever.mybatissingle.controller;

import com.forever.mybatissingle.dao.BindLabelDao;
import com.forever.mybatissingle.mode.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Bind标签的演示
 *
 * @author: Forever丶诺
 * @date: 2018/4/9 9:27
 */
@Controller
@RequestMapping("bindLabel")
public class BindLabelController {

    @Autowired
    private BindLabelDao bindLabelDao;

    /**
     * 使用bind  Like查询
     *
     * @Author: Forever丶诺
     * @Date: 2018/4/9 9:43
     */
    @RequestMapping("/demo1")
    @ResponseBody
    public void demo1() {
        bindLabelDao.demo1(new Person().setName("三"));
    }

    /**
     * 使用concat Like查询
     *
     * @Author: Forever丶诺
     * @Date: 2018/4/9 9:43
     */
    @RequestMapping("/likeSelectByConcat")
    @ResponseBody
    public void likeSelectByConcat() {
        bindLabelDao.likeSelectByConcat(new Person().setName("三"));
    }

    /**
     * 使用占位符$ Like查询
     *
     * @Author: Forever丶诺
     * @Date: 2018/4/9 9:43
     */
    @RequestMapping("/likeSelectByZWF")
    @ResponseBody
    public void likeSelectByZWF() {
        bindLabelDao.likeSelectByZWF(new Person().setName("三"));
    }

}
