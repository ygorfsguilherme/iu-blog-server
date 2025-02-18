package br.com.ygorfsguilherme.ui_blog.entity;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;

@Entity
@Table(name = "posts")
public class PostEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false, length = 100)
    private String title;

    @Column(nullable = true, columnDefinition = "TEXT")
    private String content;

    @ManyToMany
    @JoinTable(
      name = "post_tags", 
      joinColumns = @JoinColumn(name = "post_id"), 
      inverseJoinColumns = @JoinColumn(name = "tag_id"))
    private List<TagEntity> tags;

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(nullable = false)
    private LocalDateTime updatedAt;

    @Column(nullable = false)
    private boolean published;

    @Column(nullable = false)
    private boolean deleted;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = createdAt;
        deleted = false;
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }

    public PostEntity() {}

    public PostEntity(String title, String content, List<TagEntity> tags) {
        this.title = title;
        this.content = content;
        this.tags = tags;
    }

    public UUID getId() { return id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }

    public List<TagEntity> getTags() { return tags; }
    public void setTags(List<TagEntity> tags) { this.tags = tags; }

    public LocalDateTime getCreatedAt() { return createdAt; }

    public LocalDateTime getUpdatedAt() { return updatedAt; }

    public boolean isPublished() { return published; }
    public void setPublished() { this.published = !this.published; }

    public boolean isDeleted() { return deleted; }
    public void setDeleted() { this.deleted = !this.deleted; }
}
