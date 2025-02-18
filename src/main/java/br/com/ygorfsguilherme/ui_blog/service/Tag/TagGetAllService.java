package br.com.ygorfsguilherme.ui_blog.service.Tag;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ygorfsguilherme.ui_blog.controller.tag.dto.TagResponse;
import br.com.ygorfsguilherme.ui_blog.entity.TagEntity;
import br.com.ygorfsguilherme.ui_blog.repository.TagRepository;

@Service
public class TagGetAllService {

    @Autowired
    TagRepository tagRepository;

    TagGetAllService() {}

    public List<TagResponse> getAll() {
        List<TagEntity> tagE = this.tagRepository.findAll();
    
        return tagE.stream()
            .map(entity -> new TagResponse(entity.getId(), entity.getName()))
            .toList();
    }

}
