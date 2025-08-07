package com.BuilderMethodDP;

public class MobileGadgetBuilder implements GadgetBuilder {

    private Mobile mobile;

    public MobileGadgetBuilder() {
        this.mobile = new Mobile();
    }

    @Override
    public GadgetBuilder buildStorage(int storage) {
        mobile.setStorage(storage);
        return this;
    }

    @Override
    public GadgetBuilder buildMemory(int memory) {
        mobile.setMemory(memory);
        return this;
    }

    @Override
    public Mobile build() {
        return mobile;
    }
}
