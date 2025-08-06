package com.Singleton;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;



public class SingletonDPConfigManager {

    private static SingletonDPConfigManager ConfigManagerInstance;

    private Properties properties;

    private  SingletonDPConfigManager() {

        properties = new Properties();

        try (InputStream input = getClass().getClassLoader().getResourceAsStream("config.prop")) {
            if (input == null) {
                System.out.println("we cant find config properties");
                return;
            }
            properties.load(input);
        }catch (IOException ioexp) {
            ioexp.printStackTrace();
        }
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }

    public static synchronized SingletonDPConfigManager getConfigManagerInstance() {
        if (ConfigManagerInstance == null) {
            ConfigManagerInstance = new SingletonDPConfigManager();
        }
        return ConfigManagerInstance;
    }

}


