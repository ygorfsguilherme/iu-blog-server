package br.com.ygorfsguilherme.ui_blog.service.Auth;

import br.com.ygorfsguilherme.ui_blog.controller.auth.dto.LoginRequest;
import br.com.ygorfsguilherme.ui_blog.controller.auth.dto.LoginResponse;
import br.com.ygorfsguilherme.ui_blog.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class UserLoginService {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    TokenService tokenService;

    UserLoginService() {}

    public LoginResponse login(LoginRequest dto) {
        UsernamePasswordAuthenticationToken usernamePassword = new UsernamePasswordAuthenticationToken(
                dto.getUsername(),
                dto.getPassword()
        );

        Authentication auth = this.authenticationManager.authenticate(usernamePassword);

        String token = tokenService.generateToken((UserEntity) auth.getPrincipal());

        return new LoginResponse(token);
    }
}

