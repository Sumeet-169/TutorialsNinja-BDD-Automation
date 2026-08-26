package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private static Properties properties;

    static {
        loadProperties();
    }

    // It Reads the config.properties file and loads all properties.
    private static void loadProperties() {

        // Properties object to hold configuration values.
        properties = new Properties();
        String filePath = "src/test/resources/config/config.properties";

        try (FileInputStream fileInputStream = new FileInputStream(filePath)) {
            properties.load(fileInputStream);

        } catch (IOException e) {

            // Stop test execution if configuration cannot be loaded.
            throw new RuntimeException(
                    "Unable to load configuration file: " + filePath, e
            );
        }
    }

    // Returns the value associated with the given configuration key.
    public static String getProperty(String key) {

        return properties.getProperty(key);
    }
}