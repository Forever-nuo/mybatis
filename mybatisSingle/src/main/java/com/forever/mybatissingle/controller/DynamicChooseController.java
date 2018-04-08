package com.forever.mybatissingle.controller;

import com.forever.mybatissingle.dao.DynamicChooseDao;
import com.forever.mybatissingle.mode.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * choose标签的使用
 *
 * @author: Forever丶诺
 * @date: 2018/4/8 16:17
 */
@Controller
@RequestMapping("dynamicChoose")
public class DynamicChooseController {

    @Autowired
    private DynamicChooseDao dynamicChooseDao;

    @RequestMapping("/testChoose")
    @ResponseBody
    public void testChoose(String name) {
        dynamicChooseDao.testChoose(new Person().setName(name));
    }

}
