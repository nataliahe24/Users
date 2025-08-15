package com.powerup.user.users.application.services.impl;

import com.powerup.user.commons.configurations.utils.Constants;
import com.powerup.user.users.application.dto.request.LoginUserRequest;
import com.powerup.user.users.application.dto.response.LoginResponse;
import com.powerup.user.users.application.services.AuthService;
import com.powerup.user.users.domain.exceptions.CredentialsInvalidException;
import com.powerup.user.users.domain.model.UserModel;
import com.powerup.user.users.domain.ports.in.AuthServicePort;
import com.powerup.user.users.infrastructure.security.jwt.JwtUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final AuthServicePort authServicePort;
    private final JwtUtils jwUtils;

    @Override
    public LoginResponse loginUser(LoginUserRequest request) {
        String email = request.email();
        String password = request.password();


        UserModel user = authServicePort.login(email, password);
        if (user == null) {
            throw new CredentialsInvalidException(Constants.INVALID_USERS_RESPONSE_MESSAGE);
        }


        List<SimpleGrantedAuthority> authorities = Collections.singletonList(
            new SimpleGrantedAuthority(user.getRole().getName()));
        Authentication authentication = new UsernamePasswordAuthenticationToken(
            email, password, authorities);
            
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String accessToken = jwUtils.createToken(authentication);
        
        return new LoginResponse(user.getId(), user.getFirstName(), email, Constants.LOGIN_RESPONSE_MESSAGE, accessToken);
    }

    public Authentication authenticate(String email, String password) {

        UserModel user = authServicePort.login(email, password);
        if (user == null) {
            throw new CredentialsInvalidException(Constants.INVALID_USERS_RESPONSE_MESSAGE);
        }
        List<SimpleGrantedAuthority> authorities = Collections.singletonList(new SimpleGrantedAuthority(user.getRole().getName()));
        return new UsernamePasswordAuthenticationToken(email, password, authorities);
    }
}
