package com.saeed.demo32;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@SpringBootTest
@Testcontainers
class TestIntegrationTests {

    @Container
    @ServiceConnection
    static GenericContainer<?> activemq = new GenericContainer<>("symptoma/activemq");

    @DynamicPropertySource
    static void activemqProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.activemq.broker-url",
                () -> "tcp://%s:%d".formatted(activemq.getHost(), activemq.getMappedPort(61616)));
    }
}
