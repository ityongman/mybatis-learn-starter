package com.ityongman.mybatis.experiment;

import com.ityongman.mybatis.dao.BlogMapper;
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
            BlogMapper blogMapper = session.getMapper(BlogMapper.class);
            Blog blog = blogMapper.selectBlog(id);

            log.debug(String.format("Query id=%s, Blog = %s", id, blog.toString()));
        }
    }
}
