package com.example.model;

import com.google.common.base.Preconditions;
import org.json.JSONObject;

public record DataObject(String name, int age, String email) {
    public DataObject {
        Preconditions.checkNotNull(name, "Name cannot be null");
        Preconditions.checkArgument(!name.isBlank(), "Name cannot be empty or blank");
        Preconditions.checkArgument(age >= 0, "Age cannot be negative");
        Preconditions.checkNotNull(email, "Email cannot be null");
        Preconditions.checkArgument(!email.isBlank(), "Email cannot be empty or blank");
    }

    public static DataObject fromJson(JSONObject jsonObject) {
        return new DataObject(
                jsonObject.optString("name"),
                jsonObject.optInt("age"),
                jsonObject.optString("email")
        );
    }
}
