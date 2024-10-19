package com.example.interceptor;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

class LoggingInterceptorTest {

    @Test
    public void testIntercept() {
        LoggingInterceptor<String> interceptor = new LoggingInterceptor<>();

        String input = "Test Data";

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        String result = interceptor.intercept(input);

        System.setOut(System.out);

        assertThat(result).isEqualTo(input);

        String expectedOutput = "LoggingInterceptor - Data: " + input + System.lineSeparator();
        assertThat(outContent.toString()).isEqualTo(expectedOutput);
    }
}
