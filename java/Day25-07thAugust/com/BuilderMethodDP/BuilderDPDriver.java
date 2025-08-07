package com.BuilderMethodDP;

public class BuilderDPDriver {
    public static void main(String[] args) {

        GadgetBuilder builder = new MobileGadgetBuilder();

        GadgetDirector director = new GadgetDirector(builder);

        Mobile mobile = director.constructGadget();

        System.out.println("Mobile Configuration: " + mobile);
    }
}

