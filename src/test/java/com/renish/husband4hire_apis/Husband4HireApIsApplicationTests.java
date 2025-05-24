package com.renish.husband4hire_apis;

import jakarta.activation.DataSource;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest
@TestPropertySource(locations = "classpath:application-test.properties")
@ContextConfiguration(classes = Husband4HireApIsApplicationTests.TestConfig.class)
class Husband4HireApIsApplicationTests {

    @Test
    void contextLoads() {
    }

    @Configuration
    static class TestConfig {

        @Bean
        public DataSource dataSource() {
            return Mockito.mock(DataSource.class);
        }

    }
}
