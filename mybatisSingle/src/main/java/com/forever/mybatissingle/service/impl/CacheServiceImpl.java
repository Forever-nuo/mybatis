package com.forever.mybatissingle.service.impl;

import com.forever.mybatissingle.dao.CacheDao;
import com.forever.mybatissingle.mode.Person;
import com.forever.mybatissingle.service.CacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author: Forever丶诺
 * @date: 2018/4/9 11:23
 */
@Service
public class CacheServiceImpl implements CacheService {

    @Autowired
    private CacheDao cacheDao;

    @Override
    @Transactional
    public List<Person> firstCacheDemo1(){
        cacheDao.getAllPerson();
        return  cacheDao.getAllPerson();
    }

}
