package com.example.interceptor;


@FunctionalInterface
public interface DataInterceptor<I, O> {
    O intercept(I input) throws Throwable;
}

