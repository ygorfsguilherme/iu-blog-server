package br.com.ygorfsguilherme.ui_blog.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ygorfsguilherme.ui_blog.entity.PostEntity;

public interface PostRepository extends JpaRepository<PostEntity, UUID> {

}
