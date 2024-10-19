package com.example.interceptor;

import java.nio.charset.StandardCharsets;

public class ByteArrayToStringInterceptor implements DataInterceptor<byte[], String> {
    @Override
    public String intercept(byte[] input) {
        return new String(input, StandardCharsets.UTF_8);
    }
}
