package com.ityongman.service.impl;

import com.ityongman.dao.domain.Blog;
import com.ityongman.dao.mapper.BlogMapper;
import com.ityongman.service.BlogService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author shedunze
 * @Date 2021/9/9 11:43 下午
 * @Description
 */
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class BlogServiceImpl implements BlogService {

    private final BlogMapper blogMapper ;

    @Override
    public Blog queryBlogById(Long id) {
        return blogMapper.selectBlog(id);
    }
}
