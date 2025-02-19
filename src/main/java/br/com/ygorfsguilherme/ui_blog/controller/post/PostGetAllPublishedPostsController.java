package br.com.ygorfsguilherme.ui_blog.controller.post;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import br.com.ygorfsguilherme.ui_blog.controller.post.dto.PostResponse;
import br.com.ygorfsguilherme.ui_blog.service.Post.PostGetAllPublishedPostsService;

import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class PostGetAllPublishedPostsController {
    @Autowired
    PostGetAllPublishedPostsService service;

    @GetMapping("post/published")
    public ResponseEntity<List<PostResponse>> getAllPublishedPosts() {
        List<PostResponse> response = this.service.getAllPublishedPosts();
        return ResponseEntity.ok().body(response);
    }
    
}
