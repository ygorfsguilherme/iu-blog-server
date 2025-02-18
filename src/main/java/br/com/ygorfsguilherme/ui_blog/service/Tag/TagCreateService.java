package br.com.ygorfsguilherme.ui_blog.service.Tag;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ygorfsguilherme.ui_blog.controller.tag.dto.TagRequest;
import br.com.ygorfsguilherme.ui_blog.controller.tag.dto.TagResponse;
import br.com.ygorfsguilherme.ui_blog.entity.TagEntity;
import br.com.ygorfsguilherme.ui_blog.exception.TagAlreadyExistsException;
import br.com.ygorfsguilherme.ui_blog.repository.TagRepository;

@Service
public class TagCreateService {
    @Autowired
    TagRepository tagRepository;

    public TagResponse create(TagRequest request) {
            this.tagAlreadyExists(request.getName());
            TagEntity tag = new TagEntity(request.getName());
            TagEntity tagS = tagRepository.save(tag);

            TagResponse tagResponse = new TagResponse(tagS.getId(), tagS.getName());
            
            return tagResponse;
    }

    private String tagAlreadyExists(String tagName) {
        Optional<TagEntity> tag = tagRepository.findByName(tagName);

        if (tag.isPresent()) {
            throw new TagAlreadyExistsException();
        }
    
        return tagName;
    }
}
