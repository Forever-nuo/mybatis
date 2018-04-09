package com.forever.mybatissingle.test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

/**
 * @author: Forever丶诺
 * @date: 2018/4/4 14:10
 */
public class TestBase {

    public SqlSession getSqlSession() {
        String mybatisXml = "mybatis.xml";
        Reader reader = null;
        SqlSession sqlSession = null;
        try {
            reader = Resources.getResourceAsReader(mybatisXml);
            SqlSessionFactory sqlFactory = new SqlSessionFactoryBuilder().build(reader);
            sqlSession = sqlFactory.openSession();
        } catch (IOException e) {
            e.printStackTrace();

        }
        return sqlSession;
    }

    public SqlSessionFactory getSessionFactory() {
        String mybatisXml = "mybatis.xml";
        Reader reader = null;
        SqlSessionFactory sqlFactory = null;
        try {
            reader = Resources.getResourceAsReader(mybatisXml);
            sqlFactory = new SqlSessionFactoryBuilder().build(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sqlFactory;
    }

}
