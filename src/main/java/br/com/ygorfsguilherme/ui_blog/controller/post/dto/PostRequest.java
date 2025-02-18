package br.com.ygorfsguilherme.ui_blog.controller.post.dto;
import java.util.List;
import java.util.UUID;

public record PostRequest(
    String title,
    String content,
    List<UUID> tags
) {}