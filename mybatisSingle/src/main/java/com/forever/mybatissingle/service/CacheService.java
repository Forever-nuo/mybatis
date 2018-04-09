package com.forever.mybatissingle.service;

import com.forever.mybatissingle.mode.Person;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author: Forever丶诺
 * @date: 2018/4/9 11:23
 */
public interface CacheService {

    List<Person> firstCacheDemo1();
}
