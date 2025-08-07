package com.BuilderMethodDP;


public interface GadgetBuilder {
    GadgetBuilder buildStorage(int storage);
    GadgetBuilder buildMemory(int memory);
    Mobile build();
}



