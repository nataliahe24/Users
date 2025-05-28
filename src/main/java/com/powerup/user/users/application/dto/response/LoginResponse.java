package com.powerup.user.users.application.dto.response;

public record LoginResponse(Long id,String name, String email, String message, String accessToken, Long role) {
}
