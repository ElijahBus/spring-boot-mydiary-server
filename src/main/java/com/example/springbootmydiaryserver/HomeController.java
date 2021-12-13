package com.example.springbootmydiaryserver;

import com.example.springbootmydiaryserver.exceptions.ApiRequestException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    public String index() {
        return "Welcome to my diary server";
    }

    @GetMapping("/e")
    public String testException() {
        throw new ApiRequestException("Successfully configured custom exception");
    }
}
