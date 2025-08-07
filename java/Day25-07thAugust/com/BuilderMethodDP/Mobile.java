package com.BuilderMethodDP;

public class Mobile {

    private int storage;
    private int memory;

    public int getStorage() {
        return storage;
    }

    public void setStorage(int storage) {
        this.storage = storage;
    }

    public int getMemory() {
        return memory;
    }

    public void setMemory(int memory) {
        this.memory = memory;
    }

    @Override
    public String toString() {
        return "Mobile{" +
                "storage=" + storage + "GB" +
                ", memory=" + memory + "GB" +
                '}';
    }
}
