package com.example.interceptor;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

import java.nio.charset.StandardCharsets;

class ByteArrayToStringInterceptorTest {

    @Test
    public void testIntercept() {
        ByteArrayToStringInterceptor interceptor = new ByteArrayToStringInterceptor();
        byte[] input = "Hello, World!".getBytes(StandardCharsets.UTF_8);
        String result = interceptor.intercept(input);

        assertThat(result).isEqualTo("Hello, World!");
    }
}
