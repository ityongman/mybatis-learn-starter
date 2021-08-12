package com.ityongman.mybatis.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;

import java.io.InputStream;
import java.util.Objects;

/**
 * @Author shedunze
 * @Date 2021/8/3 11:19 下午
 * @Description
 */
public class SqlSessionFactoryUtil {
    private static final Logger log = Logger.getLogger(SqlSessionFactoryUtil.class);
    /**
     * 锁对象
     */
    private static  final Class CLASS_LOCK = SqlSessionFactoryUtil.class ;

    /**
     * mybatis-config.xml 文件路径
     */
    private final static String MYBATIS_CONFIG_PATH = "mybatis-config.xml" ;

    /**
     * SqlSessionFactory
     */
    private static SqlSessionFactory sqlSessionFactory = null ;

    /**
     * 创建SqlSession
     */
    public static SqlSession openSession() {
        if (Objects.isNull(sqlSessionFactory)){
            initSqlSessionFactory();
        }
        return sqlSessionFactory.openSession();
    }

    private static SqlSessionFactory initSqlSessionFactory() {
        InputStream inputStream = null ;
        //1. 加载资源
        try{
            inputStream = Resources.getResourceAsStream(MYBATIS_CONFIG_PATH);
        } catch (Exception e) {
            log.error("Resource load throw exception !!!", e) ;
        }

        //2. 创建SqlSessionFactory
        synchronized (CLASS_LOCK) {
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        }

        return sqlSessionFactory ;
    }

}
