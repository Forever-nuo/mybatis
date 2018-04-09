package com.forever.mybatissingle.test;

import com.forever.mybatissingle.dao.CacheDao;
import com.forever.mybatissingle.mode.Person;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

import java.util.List;

/**
 * @author: Forever丶诺
 * @date: 2018/4/9 10:22
 */
public class TestCache extends TestBase {

    /**
     * 一级缓存的演示1
     * <p>
     * 缓存的key:
     * 同一个sqlSession
     * 执行语句的id + sql语句+参数
     */
    @Test
    public void testDemo1() {
        //一级缓存的演示
        SqlSession sqlSession = getSqlSession();
        CacheDao cacheDao = sqlSession.getMapper(CacheDao.class);
        List<Person> allPerson = cacheDao.getAllPerson();

        //第二次执行的时候没有执行sql语句
        List<Person> allPerson1 = cacheDao.getAllPerson();
    }

    /***********************************************************一级缓存失效的情况************************************/

    /**
     * 失效情况1 : 开启不同的sqlSession
     *
     * @Author: Forever丶诺
     * @Date: 2018/4/9 10:33
     */
    @Test
    public void testFirstCacheNoUse1() {
        //一级缓存的演示
        SqlSession sqlSession = getSqlSession();
        CacheDao cacheDao = sqlSession.getMapper(CacheDao.class);
        List<Person> allPerson = cacheDao.getAllPerson();

        //开启新的sqlSession
        SqlSession sqlSession1 = getSqlSession();
        CacheDao mapper = sqlSession1.getMapper(CacheDao.class);
        //发出新的sql语句
        List<Person> allPerson1 = mapper.getAllPerson();
    }

    /**
     * 失效情况2: 同一个sqlSession,查询条件不一样
     *
     * @Author: Forever丶诺
     * @Date: 2018/4/9 10:37
     */
    @Test
    public void testFirstCacheNoUse2() {
        //一级缓存的演示
        SqlSession sqlSession = getSqlSession();
        CacheDao cacheDao = sqlSession.getMapper(CacheDao.class);
        //执行
        Person person1 = cacheDao.getPersonById(2);
        //未执行
        Person person3 = cacheDao.getPersonById(2);
        //执行
        Person person2 = cacheDao.getPersonById(1);
        //未执行
        Person person5 = cacheDao.getPersonById(1);
        //执行
        Person person4 = cacheDao.getPersonById(7);

    }

    /**
     * 一级缓存失效3:
     * 在同一个执行语句之间
     * 执行了增删改操作(哪怕不是那条数据)
     */
    @Test
    public void testFirstCacheNoUse3() {
        //一级缓存的演示
        SqlSession sqlSession = getSqlSession();
        CacheDao cacheDao = sqlSession.getMapper(CacheDao.class);
        //执行
        Person person1 = cacheDao.getPersonById(2);
        //进行修改操作
        cacheDao.updatePerson(new Person().setName("王五5").setId(7));
        //执行sql语句
        Person person3 = cacheDao.getPersonById(2);

    }

    /**
     * 失效情况4
     * 手动情况缓存
     *
     * @Author: Forever丶诺
     * @Date: 2018/4/9 10:46
     */
    @Test
    public void testFirstCacheNoUse4() {
        //一级缓存的演示
        SqlSession sqlSession = getSqlSession();
        CacheDao cacheDao = sqlSession.getMapper(CacheDao.class);
        //执行
        Person person1 = cacheDao.getPersonById(2);
        //情空缓存
        sqlSession.clearCache();
        //执行sql语句
        Person person3 = cacheDao.getPersonById(2);
    }

    @Test
    public void testSecondCacheDemo1() {
        SqlSessionFactory factory = getSessionFactory();
        //一级缓存的演示
        SqlSession sqlSession = factory.openSession();
        CacheDao cacheDao = sqlSession.getMapper(CacheDao.class);
        //执行
        Person person1 = cacheDao.getPersonById(2);
        sqlSession.close();
        SqlSession sqlSession1 = factory.openSession();
        CacheDao mapper = sqlSession1.getMapper(CacheDao.class);
        Person person2 = mapper.getPersonById(2);

    }

    /**
     *
     */
    @Test
    public void testSecondCacheDemo2() {
        SqlSessionFactory factory = getSessionFactory();

        //开启一个sqlSession
        SqlSession sqlSession = factory.openSession();

        CacheDao cachedao1 = sqlSession.getMapper(CacheDao.class);
        cachedao1.getPersonById(2);

        //开心操作
        cachedao1.updatePersonNoFlushCache(new Person().setName("玩笑而").setId(2));

        sqlSession.close();

        //开启第二个sqlSession
        SqlSession sqlSession2 = factory.openSession();
        CacheDao cacheDao2 = sqlSession2.getMapper(CacheDao.class);
        cacheDao2.getPersonById(2);
    }
    @Test
    public void testSecondCacheDemo3() {
        SqlSessionFactory factory = getSessionFactory();

        //开启一个sqlSession
        SqlSession sqlSession = factory.openSession();

        CacheDao cachedao1 = sqlSession.getMapper(CacheDao.class);
        cachedao1.getPersonById(2);

        //开心操作
       cachedao1.updatePersonNoFlushCache(new Person().setName("玩笑而").setId(7));
        cachedao1.getPersonById(2);

    }
}
