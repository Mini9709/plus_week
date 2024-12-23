package com.example.demo.util;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class PasswordEncoderTest {

    @Test
    void matches() {
        String testPassword = "password";
        String encodedPassword = PasswordEncoder.encode(testPassword);

        assertTrue(PasswordEncoder.matches(testPassword, encodedPassword));
    }
}