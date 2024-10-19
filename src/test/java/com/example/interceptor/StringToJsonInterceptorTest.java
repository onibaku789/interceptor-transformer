package com.example.interceptor;

import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class StringToJsonInterceptorTest {

    @Test
    public void testIntercept() {
        StringToJsonInterceptor interceptor = new StringToJsonInterceptor();
        String input = "{ \"key\": \"value\" }";
        JSONObject result = interceptor.intercept(input);

        assertThat(result).isNotNull();
        assertThat(result.getString("key")).isEqualTo("value");
    }
}
