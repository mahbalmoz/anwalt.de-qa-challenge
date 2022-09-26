package com.anwaltde.utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {

    //This class will READ THE DATA FROM configuration.properties file!!!

    private static Properties properties;

    static {
        //path of the configuration.properties file
        String path = "configuration.properties";
        try {
            //Opening the configuration.properties file
            FileInputStream fileInputStream = new FileInputStream(path);
            //loading the file
            properties = new Properties();
            properties.load(fileInputStream);
            //closing the file
            fileInputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //This method will get the KEY and return to the VALUE
    public static String getProperty(String key){
        return properties.getProperty(key);
    }

}
