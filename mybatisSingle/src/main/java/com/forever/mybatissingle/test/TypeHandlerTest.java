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
import java.util.Date;

/**
 * @author: Forever丶诺
 * @date: 2018/4/4 14:10
 */
public class TypeHandlerTest extends  TestBase {


    public SqlSessionFactory getSqlSessionFactory(){
        String mybatisXml = "mybatis.xml";
        Reader reader = null;
        SqlSessionFactory sqlFactory =null;
        try {
            reader = Resources.getResourceAsReader(mybatisXml);
             sqlFactory = new SqlSessionFactoryBuilder().build(reader);

        } catch (IOException e) {
            e.printStackTrace();

        }
        return sqlFactory;
    }

    @Test
    public void testInsertPerson() {
        SqlSession sqlSession = getSqlSession();
        PersonDao personDao = sqlSession.getMapper(PersonDao.class);
        personDao.insertPerson(new Person().setName("张三").setAge(10).setVersion(1).setAddTime(new Date()));
        sqlSession.commit();
        sqlSession.close();
    }


    @Test
    public void testInsertPerson2() {
        SqlSession sqlSession = getSqlSession();
        PersonDao personDao = sqlSession.getMapper(PersonDao.class);
        personDao.insertPerson2(new Person().setName("赵六").setAge(10).setVersion(1).setAddTime(new Date()));
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testGetPerson() {
        SqlSession sqlSession = getSqlSession();
        PersonDao personDao = sqlSession.getMapper(PersonDao.class);
        Person person = personDao.selectPerson(2);
        long timeStamp = person.getAddTime().getTime();
        System.out.println(timeStamp);
    }




}
