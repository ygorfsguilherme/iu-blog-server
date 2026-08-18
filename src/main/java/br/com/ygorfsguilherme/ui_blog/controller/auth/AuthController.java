package br.com.ygorfsguilherme.ui_blog.controller.auth;

import br.com.ygorfsguilherme.ui_blog.controller.auth.dto.LoginRequest;
import br.com.ygorfsguilherme.ui_blog.controller.auth.dto.LoginResponse;
import br.com.ygorfsguilherme.ui_blog.controller.auth.dto.RegisterRequest;
import br.com.ygorfsguilherme.ui_blog.service.Auth.UserLoginService;
import br.com.ygorfsguilherme.ui_blog.service.Auth.UserRegisterService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    UserRegisterService userRegisterService;

    @Autowired
    UserLoginService userLoginService;

    @PostMapping("/register")
    public ResponseEntity<Void> register(@RequestBody @Valid RegisterRequest dto) {
        userRegisterService.register(dto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody @Valid LoginRequest dto) {
        LoginResponse response = userLoginService.login(dto);
        return ResponseEntity.ok(response);
    }
}
