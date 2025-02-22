package br.com.ygorfsguilherme.ui_blog.controller.post;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import br.com.ygorfsguilherme.ui_blog.controller.post.dto.PostRequest;
import br.com.ygorfsguilherme.ui_blog.controller.post.dto.PostResponse;
import br.com.ygorfsguilherme.ui_blog.service.Post.PostUpdateService;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
public class PostUpdateController {
    @Autowired
    PostUpdateService service;

    @PutMapping("/post/update/{id}")
    public ResponseEntity<PostResponse> postUpdate(@PathVariable UUID id, @RequestBody PostRequest request) {
        PostResponse response = this.service.update(request, id);
        return ResponseEntity.ok().body(response);
    }
}
