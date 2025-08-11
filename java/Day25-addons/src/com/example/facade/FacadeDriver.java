package com.example.facade;

/**
 * Small demo client showing how to use BankFacade.
 */
public class FacadeDriver {
    public static void main(String[] args) {
        BankFacade facade = new BankFacade();
        String accountNo = "ACC12345";

        // Simple raw access: returns FdDetails object
        FdDetails fd = facade.getFdServiceDetails(accountNo);
        System.out.println(fd);

        // Friendly summary that combines info from multiple services
        String summary = facade.getFdSummary(accountNo);
        System.out.println(summary);
    }
}
