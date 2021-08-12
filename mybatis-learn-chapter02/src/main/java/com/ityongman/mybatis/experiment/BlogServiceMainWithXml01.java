package com.ityongman.mybatis.experiment;

import com.ityongman.mybatis.dao.BlogMapper;
import com.ityongman.mybatis.entity.Blog;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Author shedunze
 * @Date 2021/8/3 10:08 下午
 * @Description
 */
public class BlogServiceMainWithXml01 {
    public static void main(String[] args) throws IOException {
        /**
         * 创建SqlSessionFactory方式
         * 方法一、直接从xml文件中 加载mybatis 配置信息
         */
        String source = "mybatis-config.xml" ;
        InputStream inputStream = Resources.getResourceAsStream(source);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        /**
         * 方法二、根据
         * SqlSessionFactoryBuilder、SqlSessionFactory、SqlSession作用域情况创建相应对象
         * 具体逻辑查看 BlogServiceMainWithScope
         */
        //方式一、通过 SqlSession 实例来直接执行已映射的 SQL 语句
        try(SqlSession session = sqlSessionFactory.openSession()) {
            Long id = 2L ;
            Blog blog = session.selectOne("com.ityongman.mybatis.dao.BlogMapper.selectBlog", id);
            System.out.println(String.format("Query id=%s, Blog = %s", id, blog.toString()));
        }

        //方式二、通过 SqlSession 实例来直接执行已映射的 SQL 语句
        try(SqlSession session = sqlSessionFactory.openSession()){
            Long id = 1L ;
            BlogMapper blogMapper = session.getMapper(BlogMapper.class);
            Blog blog = blogMapper.selectBlog(id);
            System.out.println(String.format("Query id=%s, Blog = %s", id, blog.toString()));
        }


        //方式三、通过 注解方式 执行已映射的 SQL 语句
        try(SqlSession session = sqlSessionFactory.openSession()){
            Long id = 1L ;
            BlogMapper blogMapper = session.getMapper(BlogMapper.class);
            Blog blog = blogMapper.selectBlogByAnnotation(id);
            System.out.println(String.format("Query id=%s, Blog = %s", id, blog.toString()));
        }
    }
}
