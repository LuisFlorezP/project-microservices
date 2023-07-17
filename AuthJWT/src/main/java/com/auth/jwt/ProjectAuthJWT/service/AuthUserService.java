package com.auth.jwt.ProjectAuthJWT.service;

import com.auth.jwt.ProjectAuthJWT.dto.AuthUserDto;
import com.auth.jwt.ProjectAuthJWT.dto.TokenDto;
import com.auth.jwt.ProjectAuthJWT.entity.AuthUser;
import com.auth.jwt.ProjectAuthJWT.repository.AuthUserRepository;
import com.auth.jwt.ProjectAuthJWT.security.JwtProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthUserService {

    @Autowired
    private AuthUserRepository authUserRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JwtProvider jwtProvider;

    public AuthUser save(AuthUserDto dto) {
        Optional<AuthUser> authUser = authUserRepository.findByUserName(dto.getUserName());
        if (authUser.isPresent()) return null;
        String password = passwordEncoder.encode(dto.getPassword());
        AuthUser user = AuthUser.builder()
                .userName(dto.getUserName())
                .password(dto.getPassword())
                .build();
        return authUserRepository.save(user);
    }

    public TokenDto login(AuthUserDto dto) {
        Optional<AuthUser> authUser = authUserRepository.findByUserName(dto.getUserName());
        if (!authUser.isPresent()) return null;
        else if (passwordEncoder.matches(dto.getPassword(), authUser.get().getPassword())) return new TokenDto(jwtProvider.createToken(authUser.get()));
        else return null;
    }

    public TokenDto validate(String token) {
        if (!jwtProvider.validate(token)) return null;
        String userName = jwtProvider.getUserNameFromToken(token);
        if (!authUserRepository.findByUserName(userName).isPresent()) return null;
        else return new TokenDto(token);
    }
}
