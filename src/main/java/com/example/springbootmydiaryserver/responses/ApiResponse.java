package com.example.springbootmydiaryserver.responses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.util.Map;

@Getter
@AllArgsConstructor
public class ApiResponse {

    private final Map<Object, Object> data;
    private final String message;
    private final HttpStatus status;
}
