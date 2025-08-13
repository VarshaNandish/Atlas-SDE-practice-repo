package com.example.StructuralMethodDP.PubSub;

public class PubSubMain {
    public static void main(String[] args) {
        System.out.println("Publisher Subscriber Design Pattern - messaging Pattern");

        //publishers
        Whatsapp whatsApp = new Whatsapp();

        //subscribers

        Person p1 = new Person("Prasunamba");
        Person p2 = new Person("Meher");

        // subscribe persons to Whatsapp
        whatsApp.addPerson(p1);
        whatsApp.addPerson(p2);

        whatsApp.sendMsg("welcome guys");

        whatsApp.removePerson(p2);

        whatsApp.sendMsg("Good Luck guys");

    }
}