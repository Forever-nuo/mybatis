package com.forever.mybatissingle.mode;

import lombok.Data;
import lombok.experimental.Accessors;
import org.apache.ibatis.type.Alias;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author: Forever丶诺
 * @createTime: 2018-4-3.20:10
 */
@Alias("person")
@Data
@Accessors(chain = true)
public class Person implements Serializable {
    private static final long serialVersionUID = 788085235452655595L;
    private Integer id;
    private String name;
    private Integer age;
    private Integer version;
    private Date addTime;

    List<Integer> ids;
}
