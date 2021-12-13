package com.example.springbootmydiaryserver.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

@Getter
@AllArgsConstructor
public class ApiException {

    private final String message;
    private final HttpStatus statusCode;
    private final ZonedDateTime timestamp;
}
