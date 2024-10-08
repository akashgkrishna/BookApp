package celebi.config;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

/**
 * The Config class loads configuration properties from a file and provides
 * methods to access those properties.
 */

public class Config {
    private static final Properties properties = new Properties();

    static {
        String env = System.getProperty("env", "prod");
        try (InputStream input = new FileInputStream("config/movie/" + env + ".properties")) {
            properties.load(input);
        } catch (Exception ex) {
            System.out.println("Error loading   properties file for environment '" + env + "': " + ex.getMessage());
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }

    public static String getBaseUrl() {
        return getProperty("base.url");
    }

    public static String getEndpoint(String key) {
        return getProperty(key + ".endpoint");
    }
}
