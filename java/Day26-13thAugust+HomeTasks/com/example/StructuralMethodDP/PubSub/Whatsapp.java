package com.example.StructuralMethodDP.PubSub;

// concrete publisher
public class Whatsapp implements Publisher {
    private Subscriber subscriber;

    @Override
    public void addPerson(Subscriber subscriber) {
        this.subscriber = subscriber;
    }

    @Override
    public void removePerson(Subscriber subscriber) {
        this.subscriber = subscriber;
    }

    @Override
    public void notify(String msg){
        this.subscriber = subscriber;
    }


    public void sendMsg(String msg) {
        this.notify(msg);
    }
}