package com.example.mydemo.user;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/users")
public class MyUserController {

    UserRepository userRepository;

    @Autowired // Optional, constructor injection is automatically wired in Spring Boot 2.2+
    public MyUserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @GetMapping
    public ResponseEntity<Map<String,String>> test()
    {
        return ResponseEntity.ok().body(Map.of("resting", "everything ok"));
    }
}
