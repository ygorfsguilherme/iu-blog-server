package br.com.ygorfsguilherme.ui_blog.service.Post;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ygorfsguilherme.ui_blog.entity.PostEntity;
import br.com.ygorfsguilherme.ui_blog.exception.PostNotFoundException;
import br.com.ygorfsguilherme.ui_blog.repository.PostRepository;

@Service
public class PostPublishService {
    @Autowired
    PostRepository repository;

    public PostPublishService() {
    }

    public void publishPost(UUID id){
        PostEntity entity = this.repository.findById(id)
                .orElseThrow(() -> new PostNotFoundException());

        entity.setPublished();

        this.repository.save(entity);
    }
    
}
