package br.com.ygorfsguilherme.ui_blog.controller.tag.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class TagRequest {
    
    @NotBlank(message = "O nome da tag não pode estar em branco.")
    @Size(min = 2, message = "É necessário que tenha no mínimo 2 caracteres.")
    private String name;

    public TagRequest() {
    }

    public TagRequest(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
