package com.example.model;


import org.json.JSONObject;

public record DataObject(String name, int age, String email) {
    public DataObject {
        if (age < 0) {
            throw new IllegalArgumentException("Age cannot be negative");
        }
    }

    public DataObject(JSONObject jsonObject) {
        this(jsonObject.optString("name"), jsonObject.optInt("age"), jsonObject.optString("email"));
    }
}

