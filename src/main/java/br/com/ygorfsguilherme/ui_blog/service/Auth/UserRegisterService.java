package br.com.ygorfsguilherme.ui_blog.service.Auth;

import br.com.ygorfsguilherme.ui_blog.controller.auth.dto.RegisterRequest;
import br.com.ygorfsguilherme.ui_blog.entity.UserEntity;
import br.com.ygorfsguilherme.ui_blog.enums.UserRole;
import br.com.ygorfsguilherme.ui_blog.exception.UserAlreadyExistsException;
import br.com.ygorfsguilherme.ui_blog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserRegisterService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    UserRegisterService() {}

    public void register(RegisterRequest dto) {
        if (userRepository.findByUsername(dto.getUsername()) != null) {
            throw new UserAlreadyExistsException();
        }

        String encryptedPassword = passwordEncoder.encode(dto.getPassword());
        UserEntity newUser = new UserEntity(dto.getUsername(), encryptedPassword, UserRole.ADMIN);

        userRepository.save(newUser);
    }
}