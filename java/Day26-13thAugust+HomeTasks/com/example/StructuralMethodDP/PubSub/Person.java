package com.example.StructuralMethodDP.PubSub;

public class Person implements Subscriber {
    private String name;

    Person(String name) {
        this.name = name;
    }

    @Override
    public void recieveMsg(String msg) {
        System.out.println(msg + "recieved from "+ name);
    }
}
