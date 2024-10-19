package com.example.pipeline;

import com.example.interceptor.DataInterceptor;

import java.util.function.Function;

public class DataTransformationPipeline<I, O> {

    private final Function<I, O> function;

    private DataTransformationPipeline(Function<I, O> function) {
        this.function = function;
    }

    public static <T> DataTransformationPipeline<T, T> start() {
        return new DataTransformationPipeline<>(Function.identity());
    }

    public <NextO> DataTransformationPipeline<I, NextO> addInterceptor(DataInterceptor<O, NextO> interceptor) {
        Function<I, NextO> newFunction = function.andThen(input -> {
            try {
                return interceptor.intercept(input);
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        });
        return new DataTransformationPipeline<>(newFunction);
    }

    public O execute(I input) throws Exception {
        try {
            return function.apply(input);
        } catch (RuntimeException e) {
            if (e.getCause() instanceof Exception exception) {
                throw exception;
            } else {
                throw e;
            }
        }
    }
}
