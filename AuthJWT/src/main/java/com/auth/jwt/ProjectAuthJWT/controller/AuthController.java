package com.auth.jwt.ProjectAuthJWT.controller;

import com.auth.jwt.ProjectAuthJWT.dto.AuthUserDto;
import com.auth.jwt.ProjectAuthJWT.dto.TokenDto;
import com.auth.jwt.ProjectAuthJWT.entity.AuthUser;
import com.auth.jwt.ProjectAuthJWT.service.AuthUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthUserService authUserService;

    @PostMapping("/login")
    public ResponseEntity<TokenDto> login(@RequestBody AuthUserDto dto) {
        TokenDto tokenDto = authUserService.login(dto);
        if (tokenDto == null) return ResponseEntity.badRequest().build();
        else return ResponseEntity.ok(tokenDto);
    }

    @PostMapping("/validate")
    public ResponseEntity<TokenDto> validate(@RequestParam String token) {
        TokenDto tokenDto = authUserService.validate(token);
        if (tokenDto == null) return ResponseEntity.badRequest().build();
        else return ResponseEntity.ok(tokenDto);
    }

    public ResponseEntity<AuthUser> save(@RequestBody AuthUserDto dto) {
        AuthUser authUser = authUserService.save(dto);
        if (authUser == null) return ResponseEntity.badRequest().build();
        else return ResponseEntity.ok(authUser);
    }
}
