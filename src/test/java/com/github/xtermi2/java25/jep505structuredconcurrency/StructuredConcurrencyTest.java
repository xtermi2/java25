package com.github.xtermi2.java25.jep505structuredconcurrency;

import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutionException;

import static org.assertj.core.api.Assertions.*;

class StructuredConcurrencyTest {
    private final StructuredConcurrency underTest = new StructuredConcurrency();

    @Test
    void executeStructuredConcurrently() throws InterruptedException {
        final StructuredConcurrency.Response response = underTest.executeStructuredConcurrently();

        assertThat(response.user())
                .isEqualTo("User 1");
        assertThat(response.order())
                .isEqualTo("Order 1");
    }

    @Test
    void executeClassicConcurrently() throws ExecutionException, InterruptedException {
        final StructuredConcurrency.Response response = underTest.executeClassicConcurrently();

        assertThat(response.user())
                .isEqualTo("User 1");
        assertThat(response.order())
                .isEqualTo("Order 1");
    }
}