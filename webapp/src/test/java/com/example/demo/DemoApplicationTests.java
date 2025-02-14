package com.example.demo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(App.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class DemoApplicationTests {

    private App app;

    @BeforeEach
    public void setup(App app) {
        this.app = app;
    }

    @Test
    void contextLoads() {
    }

    @Test
    void userResourceReturnsUser() {
        String user = this.app.userResource().getUser(1);
        assertNotNull(user);
    }
}
