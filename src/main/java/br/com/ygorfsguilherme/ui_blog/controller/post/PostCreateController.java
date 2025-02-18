package br.com.ygorfsguilherme.ui_blog.controller.post;

import org.springframework.web.bind.annotation.RestController;

import br.com.ygorfsguilherme.ui_blog.controller.post.dto.CreatePostResponse;
import br.com.ygorfsguilherme.ui_blog.controller.post.dto.PostRequest;
import br.com.ygorfsguilherme.ui_blog.service.Post.PostCreateService;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class PostCreateController {

    @Autowired
    PostCreateService postCreateService;

    @PostMapping("post")
    public ResponseEntity<CreatePostResponse> postCreate(@RequestBody PostRequest request
    ) { 
        CreatePostResponse response = this.postCreateService.create(request);
        URI location = URI.create("/api/post/" + response.getId()); 
        return ResponseEntity.created(location).body(response);
    }
    
}
