package com.ityongman.mybatis.web;

import com.ityongman.mybatis.dao.BlogMapper03;
import com.ityongman.mybatis.util.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import java.util.Map;

/**
 * @Author shedunze
 * @Date 2021/8/3 11:41 下午
 * @Description
 */
public class Test03 {
    private static final Logger log = Logger.getLogger(Test03.class);

    public static void main(String[] args) {

        try(SqlSession session = SqlSessionFactoryUtil.openSession()){
            Long id = 1L ;
            BlogMapper03 blogMapper03 = session.getMapper(BlogMapper03.class);
            Map blogMap= blogMapper03.selectByOccupy(id);

            log.debug(String.format("Query001 id=%s, blogMap = %s", id, blogMap.toString()));
        }
    }
}
