package com.ityongman.mybatis.entity;

import lombok.Data;

/**
 * @Author shedunze
 * @Date 2021/8/3 9:50 下午
 * @Description
 */
@Data
public class Blog {
    /**
     * 博客id
     */
    private Long id ;

    /**
     * 博客名称
     */
    private String name ;

    /**
     * 作者id
     */
    private Long authorId ;
}
