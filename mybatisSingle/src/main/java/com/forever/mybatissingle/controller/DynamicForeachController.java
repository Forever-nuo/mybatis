package com.forever.mybatissingle.controller;

import com.forever.mybatissingle.dao.DynamicChooseDao;
import com.forever.mybatissingle.dao.DynamicForeachDao;
import com.forever.mybatissingle.mode.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * choose标签的使用
 *
 * @author: Forever丶诺
 * @date: 2018/4/8 16:17
 */
@Controller
@RequestMapping("dynamicForeach")
public class DynamicForeachController {

    @Autowired
    private DynamicForeachDao dynamicForeachDao;

    /**
     * 有@param 注解
     *
     * @Author: Forever丶诺
     * @Date: 2018/4/8 16:57
     */
    @RequestMapping("/testListHasAnnotation")
    @ResponseBody
    public void testListHasAnnotation() {
        ArrayList<Integer> idList = new ArrayList<>();
        dynamicForeachDao.testListHasAnnotation(idList);
    }

    /**
     * 没有param注解
     *
     * @Author: Forever丶诺
     * @Date: 2018/4/8 16:57
     */
    @RequestMapping("/testList")
    @ResponseBody
    public void testList() {
        dynamicForeachDao.testList(Arrays.asList(1, 2, 3));
    }

    @RequestMapping("/testArray")
    @ResponseBody
    public void testArray() {
        dynamicForeachDao.testArray(new Integer[]{2, 3, 4, 6});
    }

    /**
     * 使用Pojo 封装 List
     *
     * @Author: Forever丶诺
     * @Date: 2018/4/8 17:03
     */
    @RequestMapping("/testObjIds")
    @ResponseBody
    public void testObjIds() {
        dynamicForeachDao.testObjIds(new Person().setIds(Arrays.asList(2, 4, 6, 8)));
    }


    @RequestMapping("/testMapList")
    @ResponseBody
    public void testMapList() {
        List<Map> allPersonMap = dynamicForeachDao.getAllPersonMap();
        dynamicForeachDao.testMapList(allPersonMap);
    }


    @RequestMapping("/testMap")
    @ResponseBody
    public void testMap() {
        List<Map> allPersonMap = dynamicForeachDao.getAllPersonMap();
        Map map = allPersonMap.get(0);
        dynamicForeachDao.testMap(map);
    }


}
