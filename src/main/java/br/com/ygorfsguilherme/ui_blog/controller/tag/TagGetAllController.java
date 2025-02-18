package br.com.ygorfsguilherme.ui_blog.controller.tag;

import org.springframework.web.bind.annotation.RestController;

import br.com.ygorfsguilherme.ui_blog.controller.tag.dto.TagResponse;
import br.com.ygorfsguilherme.ui_blog.service.Tag.TagGetAllService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class TagGetAllController {
    @Autowired
    TagGetAllService tagGetAllService;
    
    @GetMapping("tag")
    public List<TagResponse> getAll() {
        return tagGetAllService.getAll();
    }
    
}
