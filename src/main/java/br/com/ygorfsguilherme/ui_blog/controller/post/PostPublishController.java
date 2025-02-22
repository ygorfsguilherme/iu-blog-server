package br.com.ygorfsguilherme.ui_blog.controller.post;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import br.com.ygorfsguilherme.ui_blog.service.Post.PostPublishService;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
public class PostPublishController {
    @Autowired
    PostPublishService service;

    public PostPublishController() {
    }

    @PatchMapping("/post/publish/{id}")
    public ResponseEntity<Void> publish(@PathVariable UUID id) {
        this.service.publishPost(id);
        return ResponseEntity.noContent().build();
    }

}
