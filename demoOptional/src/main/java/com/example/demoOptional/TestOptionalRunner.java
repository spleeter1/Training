package com.example.demoOptional;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class TestOptionalRunner implements CommandLineRunner {
    private final UserService userService;

    public TestOptionalRunner(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void run(String... args) {

        System.out.println("--- Test trường hợp có giá trị ---");
        String name = userService.findNameById(1L).orElse("không có");
        System.out.println("Tìm thấy: "+ name);


        System.out.println("--- Test trường hợp không có giá trị ---");
        String t = userService.findNameById(2L).orElse("không có");
        System.out.println(t);
    }
}
