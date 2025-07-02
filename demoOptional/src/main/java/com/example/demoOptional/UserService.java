package com.example.demoOptional;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    public  Optional<String> findNameById(Long id) {
        if (id == 1L) {
            return Optional.of("Namnd");
        } else {
            return Optional.empty();
        }
    }
}
