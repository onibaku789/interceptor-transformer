package com.example.model;

public final class DataObject {
    private String name;
    private int age;
    private String email;

    // Constructors
    public DataObject() {
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public DataObject setName(String name) {
        this.name = name;
        return this;
    }

    public int getAge() {
        return age;
    }

    public DataObject setAge(int age) {
        this.age = age;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public DataObject setEmail(String email) {
        this.email = email;
        return this;
    }

    // toString Method
    @Override
    public String toString() {
        return "DataObject{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                '}';
    }
}
