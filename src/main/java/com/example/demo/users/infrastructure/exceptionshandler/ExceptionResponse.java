package com.example.demo.users.infrastructure.exceptionshandler;

import java.time.LocalDateTime;

public record ExceptionResponse(String message, LocalDateTime timeStamp) {
}
