package ua.stu.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReader {

    public Properties getProperties(String path) {
        FileInputStream fileInputStream;
        Properties properties = new Properties();
        try {
            fileInputStream = new FileInputStream(path);
            properties.load(fileInputStream);
            return properties;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
