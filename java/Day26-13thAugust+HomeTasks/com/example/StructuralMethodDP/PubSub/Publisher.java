package com.example.StructuralMethodDP.PubSub;

// publisher
public interface Publisher {
    void addPerson(Subscriber subscriber);
    void removePerson(Subscriber subscriber);
    void notify(String msg);
}
