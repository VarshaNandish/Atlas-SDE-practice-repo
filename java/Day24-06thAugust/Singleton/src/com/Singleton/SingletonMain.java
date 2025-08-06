package com.Singleton;

public class SingletonMain {

    public static void main(String[] args) {
        // Get singleton instance
        SingletonDPConfigManager configManager = SingletonDPConfigManager.getConfigManagerInstance();

        // Read properties from config.prop
        String dbUrl = configManager.getProperty("db.url");
        String dbUser = configManager.getProperty("db.user");
        String dbPassword = configManager.getProperty("db.password");

        // Print the values
        System.out.println("Database URL: " + dbUrl);
        System.out.println("Database User: " + dbUser);
        System.out.println("Database Password: " + dbPassword);
    }
}

