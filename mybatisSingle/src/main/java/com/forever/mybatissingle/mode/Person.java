package com.forever.mybatissingle.mode;

import org.apache.ibatis.type.Alias;

/**
 * @author: Forever丶诺
 * @createTime: 2018-4-3.20:10
 */
@Alias("person")
public class Person {
    private Integer id;
    private String name;
    private Integer age;
    private Integer version;
}
