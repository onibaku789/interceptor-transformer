package com.example.interceptor;

import com.example.model.DataObject;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class JsonToDataObjectInterceptorTest {

    @Test
    public void testIntercept() {
        JsonToDataObjectInterceptor interceptor = new JsonToDataObjectInterceptor();
        JSONObject input = new JSONObject()
                .put("name", "Bob")
                .put("age", 35)
                .put("email", "bob@example.com");

        DataObject result = interceptor.intercept(input);

        assertThat(result).isNotNull();
        assertThat(result.name()).isEqualTo("Bob");
        assertThat(result.age()).isEqualTo(35);
        assertThat(result.email()).isEqualTo("bob@example.com");
    }
}
