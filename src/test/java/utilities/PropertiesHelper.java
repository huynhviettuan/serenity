package utilities;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Properties;

public class PropertiesHelper {

    public static Properties readProperties(String name) {
        Reader reader = null;
        Properties properties = null;
        try {
            reader = new FileReader("src/test/resources/" + name + ".properties");
            properties = new Properties();
            properties.load(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }
}