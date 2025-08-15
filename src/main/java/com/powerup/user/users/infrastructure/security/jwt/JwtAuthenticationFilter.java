package com.powerup.user.users.infrastructure.security.jwt;

import com.auth0.jwt.interfaces.DecodedJWT;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Collection;
import java.util.List;
@Slf4j
@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtUtils jwtUtils;

    public JwtAuthenticationFilter(JwtUtils jwtUtils) {
        this.jwtUtils = jwtUtils;
    }


    @Override
    protected void doFilterInternal(@NonNull  HttpServletRequest request,
                                    @NonNull HttpServletResponse response,
                                    @NonNull FilterChain filterChain)
            throws ServletException, IOException {

            String jwtToken = request.getHeader(HttpHeaders.AUTHORIZATION);

            if (jwtToken != null) {
                jwtToken = jwtToken.substring(7);

                DecodedJWT decodedJWT = jwtUtils.verifyToken(jwtToken);
                String email = jwtUtils.extractEmail(decodedJWT);
                String role = "ROLE_" + jwtUtils.getSpecificClaim(decodedJWT, "authorities").asString();

                Collection<GrantedAuthority> authorities = List.of(new SimpleGrantedAuthority(role));

                SecurityContext context = SecurityContextHolder.getContext();
                Authentication authentication = new UsernamePasswordAuthenticationToken(email, null, authorities);
                context.setAuthentication(authentication);
                SecurityContextHolder.setContext(context);
            }

            filterChain.doFilter(request, response);
        }
    }
