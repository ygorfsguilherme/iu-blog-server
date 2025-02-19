package br.com.ygorfsguilherme.ui_blog.service.Post;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ygorfsguilherme.ui_blog.controller.post.dto.PostResponse;
import br.com.ygorfsguilherme.ui_blog.entity.PostEntity;
import br.com.ygorfsguilherme.ui_blog.repository.PostRepository;

@Service
public class PostGetAllService {
    @Autowired
    PostRepository postRepository;

    public PostGetAllService() {
    }

    public List<PostResponse> postGetAll() {
        List<PostEntity> entity = this.postRepository.findAllByOrderByCreatedAtDesc();
        List<PostResponse> response = entity.stream().map(e -> new PostResponse(
            e.getId(), 
            e.getTitle(), 
            e.getContent(), 
            e.getTags(), 
            e.getCreatedAt(), 
            e.getUpdatedAt())).toList();
            
        return response;
    }
}
