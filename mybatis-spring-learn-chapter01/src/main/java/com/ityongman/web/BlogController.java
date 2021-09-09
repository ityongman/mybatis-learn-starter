package com.ityongman.web;

import com.ityongman.dao.domain.Blog;
import com.ityongman.service.BlogService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author shedunze
 * @Date 2021/9/9 11:40 下午
 * @Description
 */
@RestController()
@RequestMapping("/blog/")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class BlogController {

    private final BlogService blogService ;

    @RequestMapping("/{id}")
    public ResponseEntity<Blog> queryBlogById(@PathVariable("id") Long id){
        return ResponseEntity.ok(blogService.queryBlogById(id));
    }
}
