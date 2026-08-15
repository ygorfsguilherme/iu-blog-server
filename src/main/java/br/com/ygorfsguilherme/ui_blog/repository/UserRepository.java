package br.com.ygorfsguilherme.ui_blog.repository;

import br.com.ygorfsguilherme.ui_blog.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.UUID;

public interface UserRepository extends JpaRepository<UserEntity, UUID> {

    UserDetails findByUsername(String username);
}
