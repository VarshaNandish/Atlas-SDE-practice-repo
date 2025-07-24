import java.util.*;

class Animal {
    void sound() {
        System.out.println("sounds of different animals");
    }

    @Override
    public String toString() {
        return "Generic Animal";
    }
}

class Cat extends Animal {
    @Override
    void sound() {
        System.out.println("Meow is the sound of cat");
    }

    @Override
    public String toString() {
        return "I am a Cat!";
    }
}

class Task02 {
    static void printList(List<?> list) {
        for (Object element : list) {
            System.out.println(element);
        }
    }

    public static void main(String[] args) {
        Animal obj = new Cat();
        obj.sound();

        List<Cat> clist = new ArrayList<>();
        clist.add(new Cat());

        printList(clist);
    }
}

