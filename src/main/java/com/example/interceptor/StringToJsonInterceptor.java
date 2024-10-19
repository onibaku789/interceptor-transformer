package com.example.interceptor;

import org.json.JSONObject;

public class StringToJsonInterceptor implements DataInterceptor<String, JSONObject> {
    @Override
    public JSONObject intercept(String input) {
        return new JSONObject(input);
    }
}
