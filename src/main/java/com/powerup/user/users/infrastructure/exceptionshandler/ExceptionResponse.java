package com.powerup.user.users.infrastructure.exceptionshandler;

import java.time.LocalDateTime;

public record ExceptionResponse(String message, LocalDateTime timeStamp) {
}
