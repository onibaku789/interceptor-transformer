package com.example.interceptor;

public class LoggingInterceptor<T> implements DataInterceptor<T, T> {
    @Override
    public T intercept(T input) {
        System.out.println("LoggingInterceptor - Data: " + input);
        return input;
    }
}
