package br.com.ygorfsguilherme.ui_blog.service.Post;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ygorfsguilherme.ui_blog.controller.post.dto.CreatePostResponse;
import br.com.ygorfsguilherme.ui_blog.controller.post.dto.PostRequest;
import br.com.ygorfsguilherme.ui_blog.entity.PostEntity;
import br.com.ygorfsguilherme.ui_blog.entity.TagEntity;
import br.com.ygorfsguilherme.ui_blog.repository.PostRepository;
import br.com.ygorfsguilherme.ui_blog.repository.TagRepository;

@Service
public class PostCreateService {
    
    @Autowired
    PostRepository postRepository;

    @Autowired
    TagRepository tagRepository;

    PostCreateService () {}

    public CreatePostResponse create(PostRequest dto) {

        PostEntity entity = new PostEntity();
        entity.setTitle(getTitleFromDto(dto.title()));
        entity.setContent(dto.content());
        entity.setTags(getTagsFromDto(dto.tags()));

        PostEntity entitySave = postRepository.save(entity);

        return new CreatePostResponse(
            entitySave.getId(), 
            entitySave.getTitle(), 
            entitySave.getContent(), 
            entitySave.getTags(), 
            entitySave.getCreatedAt(), 
            entitySave.getUpdatedAt()
        );
    }

    private List<TagEntity> getTagsFromDto(List<UUID> tagIds) {
        return (tagIds != null && !tagIds.isEmpty())
                ? tagRepository.findAllById(tagIds)
                : List.of();
    }

    private String getTitleFromDto(String title) {
        return (title == null || title.isBlank()) ? "Sem titulo" : title;
    }
}
