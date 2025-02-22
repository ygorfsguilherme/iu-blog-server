package br.com.ygorfsguilherme.ui_blog.service.Post;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ygorfsguilherme.ui_blog.controller.post.dto.PostRequest;
import br.com.ygorfsguilherme.ui_blog.controller.post.dto.PostResponse;
import br.com.ygorfsguilherme.ui_blog.entity.PostEntity;
import br.com.ygorfsguilherme.ui_blog.entity.TagEntity;
import br.com.ygorfsguilherme.ui_blog.exception.PostNotFoundException;
import br.com.ygorfsguilherme.ui_blog.repository.PostRepository;
import br.com.ygorfsguilherme.ui_blog.repository.TagRepository;

@Service
public class PostUpdateService {
    @Autowired
    PostRepository repository;

    @Autowired
    TagRepository tagRepository;

    public PostUpdateService() {
    }

    public PostResponse update(PostRequest request, UUID id) {
        PostEntity entity = this.repository.findById(id)
            .orElseThrow(() -> new PostNotFoundException());

        entity.setTitle(request.getTitle());
        entity.setContent(request.getContent());
        entity.onUpdate();

        List<TagEntity> tags = this.tagRepository.findAllById(request.getTags());
        entity.setTags(tags); 

        this.repository.save(entity);

        return new PostResponse(
                entity.getId(),
                entity.getTitle(),
                entity.getContent(),
                entity.getTags(),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
    }
}
