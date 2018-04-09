package com.forever.mybatissingle.controller;

import com.forever.mybatissingle.dao.CacheDao;
import com.forever.mybatissingle.service.CacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author: Forever丶诺
 * @date: 2018/4/9 10:10
 */
@Controller
@RequestMapping("cache")
public class CacheController {

    @Autowired
    private CacheDao cacheDao;


    @Autowired
    private CacheService cacheService;

    @RequestMapping("/firstCacheDemo1")
    @ResponseBody
    public void firstCacheDemo1() {
        //查看是否执行了2次sql语句
        cacheService.firstCacheDemo1();
    }





}
