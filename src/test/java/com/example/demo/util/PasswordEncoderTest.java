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

        assertNotNull(encodedPassword);
        assertNotEquals(testPassword, encodedPassword);
        assertTrue(PasswordEncoder.matches(testPassword, encodedPassword));
    }

    @Test
    void encodedPasswordsAreDifferent() {
        String testPassword = "password";
        String encodedPassword1 = PasswordEncoder.encode(testPassword);
        String encodedPassword2 = PasswordEncoder.encode(testPassword);

        assertNotEquals(encodedPassword1, encodedPassword2);
    }

    @Test
    void notEqualsPassword() {
        String testPassword1 = "password";
        String testPassword2 = "password2";

        String encodedPassword1 = PasswordEncoder.encode(testPassword1);

        assertFalse(PasswordEncoder.matches(testPassword2, encodedPassword1));
    }
}