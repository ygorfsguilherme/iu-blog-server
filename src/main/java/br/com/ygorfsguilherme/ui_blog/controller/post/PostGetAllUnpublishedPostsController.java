package br.com.ygorfsguilherme.ui_blog.controller.post;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import br.com.ygorfsguilherme.ui_blog.controller.post.dto.PostResponse;
import br.com.ygorfsguilherme.ui_blog.service.Post.PostGetAllUnpublishedPostsService;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class PostGetAllUnpublishedPostsController {

    @Autowired
    PostGetAllUnpublishedPostsService postGetAllUnpublishedPostsService;

    public PostGetAllUnpublishedPostsController() {
    }

    @GetMapping("post/unpublished")
    public ResponseEntity<List<PostResponse>> getAllUnpublishedPosts() {
        List<PostResponse> response = postGetAllUnpublishedPostsService.execute();
        return ResponseEntity.ok().body(response);
    }
    
}
