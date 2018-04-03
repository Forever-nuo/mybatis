package com.forever.mybatissingle.test;

import com.forever.mybatissingle.dao.PersonDao;
import com.forever.mybatissingle.mode.Person;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.Reader;

/**
 * @author: Forever丶诺
 * @createTime: 2018-4-3.20:13
 */
public class TestMybatis {


    @Test
    public void testCreateSqlSessionFactory() throws IOException {
        createSqlSessionFactory();
    }

    /**
     * 创建SqlSessionFactory对象
     *
     * @Description:
     * @Author: Forever丶诺
     * @Date: 20:2220:22-2018-4-3
     */
    public SqlSessionFactory createSqlSessionFactory() throws IOException {
        String mybatisXml = "mybatis.xml";
        Reader reader = Resources.getResourceAsReader(mybatisXml);
        SqlSessionFactory sqlFactory = new SqlSessionFactoryBuilder().build(reader);
        return sqlFactory;
    }

    /**
     * 使用sqlSession的获取数据库对象
     *
     * @return
     * @throws IOException
     */
    public Person getPerson1() throws IOException {
        SqlSessionFactory sqlSessionFactory = createSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        Person person;
        try {
            //参数是 唯一名称 = 命名空间 + id
            person = sqlSession.selectOne("com.forever.mybatissingle.dao.PersonDao.selectPerson", 1);
        } finally {
            sqlSession.close();
        }
        return person;
    }



    @Test
    public void testGetPerson1() throws IOException {
        getPerson1();
    }



    /**
     * 使用sqlSession的获取数据库对象
     *
     * @return
     * @throws IOException
     */
    public Person getPerson2() throws IOException {
        SqlSessionFactory sqlSessionFactory = createSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        Person person;
        try {
            //参数是 唯一名称 =  只要是整个项目中的唯一就行
            person = sqlSession.selectOne("selectPerson", 1);
        } finally {
            sqlSession.close();
        }
        return person;
    }

    @Test
    public void testGetPerson2() throws IOException {
        getPerson2();
    }

    /**
     * 使用Mapper接口对象 获取数据库对象
     * Mapper接口 和 XXXMapper.xml文件的命名空间一致
     * 接口的方法和 XXXMapper.xml文件对象的sql 语句的id一致
     *
     * @return
     * @throws IOException
     */
    public Person getPerson3() throws IOException {
        SqlSessionFactory sqlSessionFactory = createSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        Person person;
        try {
            PersonDao personDao = sqlSession.getMapper(PersonDao.class);
            person = personDao.selectPerson(1);
        } finally {
            sqlSession.close();
        }
        return person;
    }

    @Test
    public void testGetPerson3() throws IOException {
        getPerson3();
    }


}
