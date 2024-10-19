package com.example.pipeline;

import com.example.interceptor.*;
import com.example.model.DataObject;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

import java.nio.charset.StandardCharsets;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class DataTransformationPipelineTest {

    @Test
    public void testPipeline() throws Exception {
        DataInterceptor<byte[], String> interceptor1 = new ByteArrayToStringInterceptor();
        DataInterceptor<String, JSONObject> interceptor2 = new StringToJsonInterceptor();
        DataInterceptor<JSONObject, DataObject> interceptor3 = new JsonToDataObjectInterceptor();
        DataInterceptor<String, String> loggingInterceptor = new LoggingInterceptor<>();
        DataInterceptor<JSONObject, JSONObject> loggingInterceptor2 = new LoggingInterceptor<>();
        DataInterceptor<DataObject, DataObject> loggingInterceptor3 = new LoggingInterceptor<>();

        DataTransformationPipeline<byte[], DataObject> pipeline = DataTransformationPipeline.<byte[]>start()
                .addInterceptor(interceptor1)
                .addInterceptor(loggingInterceptor)
                .addInterceptor(interceptor2)
                .addInterceptor(loggingInterceptor2)
                .addInterceptor(interceptor3)
                .addInterceptor(loggingInterceptor3);

        byte[] rawData = "{ \"name\": \"Carol\", \"age\": 42, \"email\": \"carol@example.com\" }"
                .getBytes(StandardCharsets.UTF_8);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        DataObject result = pipeline.execute(rawData);

        System.setOut(originalOut);

        assertThat(result).isNotNull();
        assertThat(result.getName()).isEqualTo("Carol");
        assertThat(result.getAge()).isEqualTo(42);
        assertThat(result.getEmail()).isEqualTo("carol@example.com");

        String expectedLogs = String.join(System.lineSeparator(),
                "LoggingInterceptor - Data: { \"name\": \"Carol\", \"age\": 42, \"email\": \"carol@example.com\" }",
                "LoggingInterceptor - Data: {\"name\":\"Carol\",\"age\":42,\"email\":\"carol@example.com\"}",
                "LoggingInterceptor - Data: DataObject{name='Carol', age=42, email='carol@example.com'}",
                "");

        assertThat(outContent).hasToString(expectedLogs);
    }
}
