package com.ityongman.mybatis.web;

import com.ityongman.mybatis.dao.BlogMapper03;
import com.ityongman.mybatis.entity.Blog;
import com.ityongman.mybatis.util.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

/**
 * @Author shedunze
 * @Date 2021/8/3 11:41 下午
 * @Description
 */
public class BlogServiceMainWithScope02 {
    private static final Logger log = Logger.getLogger(BlogServiceMainWithScope02.class);

    public static void main(String[] args) {

        try(SqlSession session = SqlSessionFactoryUtil.openSession()){
            Long id = 1L ;
            BlogMapper03 blogMapper03 = session.getMapper(BlogMapper03.class);
            Blog blog = blogMapper03.selectBlog(id);

            log.debug(String.format("Query001 id=%s, Blog = %s", id, blog.toString()));

            /**
             * 测试缓存 开关
             * 1. <setting name="localCacheScope" value="STATEMENT"/> 每次请求都会从DB查询数据
             * 2. <setting name="localCacheScope" value="SESSION"/> 同一个会话中, 相同sql只会在最初时查询一次DB
             */

            BlogMapper03 blogMapper0302 = session.getMapper(BlogMapper03.class);
            Blog blog02 = blogMapper03.selectBlog(id);

            log.debug(String.format("Query002 id=%s, Blog = %s", id, blog02.toString()));
        }
    }
}
