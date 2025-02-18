package br.com.ygorfsguilherme.ui_blog.repository;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ygorfsguilherme.ui_blog.entity.TagEntity;

public interface TagRepository extends JpaRepository<TagEntity, UUID> {

    Optional<TagEntity> findByName(String tagName);
    
}
