package br.com.ygorfsguilherme.ui_blog.controller.post;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import br.com.ygorfsguilherme.ui_blog.controller.post.dto.PostResponse;
import br.com.ygorfsguilherme.ui_blog.service.Post.PostGetAllService;

import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class PostGetAllController {
    @Autowired
    PostGetAllService postGetAllService;

    @GetMapping("post")
    public ResponseEntity<List<PostResponse>> getAllService() {
        List<PostResponse> response = this.postGetAllService.postGetAll();
        return ResponseEntity.ok().body(response);
    }
    
}
