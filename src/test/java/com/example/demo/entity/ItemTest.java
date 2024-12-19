package com.example.demo.entity;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ItemTest {

    @Test
    @DisplayName("nullable = false 동작 테스트")
    void getStatus() {
        User user = new User();
        User owner = new User();
        Item item = new Item("이름", "설명", user, owner);

        assertNotNull(item.getStatus());
    }
}