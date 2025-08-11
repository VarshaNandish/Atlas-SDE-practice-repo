package com.example.proxy;

/**
 * Demo / client that uses the proxy through the DBExecutor interface.
 */
public class ProxyDriver {
    public static void main(String[] args) {
        // ADMIN user
        DBExecutor adminExecutor = new DBProxy("ADMIN");
        adminExecutor.runQuery("READ");
        adminExecutor.runQuery("UPDATE");
        adminExecutor.runQuery("DELETE");

        System.out.println();

        // MANAGER user (no DELETE permission)
        DBExecutor managerExecutor = new DBProxy("MANAGER");
        managerExecutor.runQuery("READ");
        managerExecutor.runQuery("UPDATE");
        managerExecutor.runQuery("DELETE");
    }
}
