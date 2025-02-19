package br.com.ygorfsguilherme.ui_blog.controller.tag.dto;

import java.util.UUID;

public class TagResponse {
    UUID id;
    String name;

    public TagResponse() {
    }

    public TagResponse(UUID id, String name) {
        this.id = id;
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
