package com.ityongman.dao.mapper;

import com.ityongman.dao.domain.Blog;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Map;

/**
 * @Author shedunze
 * @Date 2021/8/3 9:46 下午
 * @Description
 */
@Mapper
public interface BlogMapper {
    /**
     * 根据id查询文章
     * @param id
     * @return
     * @description annotation @Select 和 BlogMapper.xml 中方法名不能重复, 不然会提示下面的错误信息
     * Mapped Statements collection already contains value for com.ityongman.mybatis.dao.BlogMapper.selectBlog.
     * please check com/ityongman/mybatis/dao/BlogMapper.xml and com/ityongman/mybatis/dao/BlogMapper.java (best guess)
     */
    Blog selectBlog(@Param("id") Long id) ;

    /**
     * 使用注解声明sql的方式进行数据查询
     * @param id
     * @return
     */
    @Select("select id, name, author_id as authorId from Blog where id = #{id}")
    Blog selectBlogByAnnotation(@Param("id") Long id) ;

    Map selectByOccupy(@Param("id") Long id) ;

    Map selectBySql(@Param("id") Long id);
}
