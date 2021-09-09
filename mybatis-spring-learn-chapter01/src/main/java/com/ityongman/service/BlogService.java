package com.ityongman.service;

import com.ityongman.dao.domain.Blog;

/**
 * @Author shedunze
 * @Date 2021/9/9 11:42 下午
 * @Description
 */
public interface BlogService {
    Blog queryBlogById(Long id);
}
