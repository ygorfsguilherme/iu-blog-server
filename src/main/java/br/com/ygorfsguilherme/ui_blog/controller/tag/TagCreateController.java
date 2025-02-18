package br.com.ygorfsguilherme.ui_blog.controller.tag;

import org.springframework.web.bind.annotation.RestController;

import br.com.ygorfsguilherme.ui_blog.controller.tag.dto.TagRequest;
import br.com.ygorfsguilherme.ui_blog.controller.tag.dto.TagResponse;
import br.com.ygorfsguilherme.ui_blog.service.Tag.TagCreateService;
import jakarta.validation.Valid;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class TagCreateController {

    @Autowired
    TagCreateService tagCreateService;
    
    @PostMapping("tag")
    public ResponseEntity<TagResponse> tagCreate(@RequestBody @Valid TagRequest request) {
        TagResponse response = tagCreateService.create(request); 
        URI location = URI.create("/api/tag/" + response.getId());       
        return ResponseEntity.created(location).body(response);
    }
    
}
