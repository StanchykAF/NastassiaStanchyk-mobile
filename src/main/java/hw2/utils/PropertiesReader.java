package hw2.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReader {

    private static final Properties properties = new Properties();

    public static String readProperty(String propertyName) {
        if (properties.isEmpty()) {
            System.out.println("Try to read property file");
            try (FileInputStream fileInputStream = new FileInputStream(
                    "src/test/resources/config.properties")) {
                properties.load(fileInputStream);
            } catch (IOException e) {
                throw new RuntimeException("Property file not found");
            }
        }
        System.out.println("Property file was read");
        return properties.getProperty(propertyName);
    }
}
