package com.example;


public class User {
    private String firstName;
    private int age;
    private boolean isPremiumUser;


    public User(String firstName, int age, boolean isPremiumUser) {
        this.firstName = firstName;
        this.age = age;
        this.isPremiumUser = isPremiumUser;
    }


    public String getFirstName() {
        return firstName;
    }


    public int getAge() {
        return age;
    }


    public boolean isPremiumUser() {
        return isPremiumUser;
    }
}

