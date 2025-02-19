package br.com.ygorfsguilherme.ui_blog.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.ygorfsguilherme.ui_blog.entity.PostEntity;

public interface PostRepository extends JpaRepository<PostEntity, UUID> {
    List<PostEntity> findAllByOrderByCreatedAtDesc();

    @Query(value = "SELECT * FROM posts WHERE posts.published = true ORDER BY posts.created_at DESC", nativeQuery = true)
    List<PostEntity> findAllPublishedPosts();

    @Query(value = "SELECT * FROM posts WHERE posts.published = false ORDER BY posts.created_at DESC", nativeQuery = true)
    List<PostEntity> findAllUnpublishedPosts();
}
