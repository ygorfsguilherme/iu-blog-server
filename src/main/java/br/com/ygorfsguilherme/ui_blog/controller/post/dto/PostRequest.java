package br.com.ygorfsguilherme.ui_blog.controller.post.dto;
import java.util.List;
import java.util.UUID;

public class PostRequest {
    private String title = "Rascunho";
    private String content;
    private List<UUID> tags;

    public PostRequest() {
    }

    public PostRequest(
        String title,
        String content,
        List<UUID> tags
    ) {
        this.title = (title == null || title.trim().isEmpty()) ? "Rascunho" : title;
        this.content = content;
        this.tags = tags;
    }

    // Getters
    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public List<UUID> getTags() {
        return tags;
    }

    // Setters
    public void setTitle(String title) {
        this.title = (title == null || title.trim().isEmpty()) ? "Rascunho" : title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setTags(List<UUID> tags) {
        this.tags = tags;
    }
}
