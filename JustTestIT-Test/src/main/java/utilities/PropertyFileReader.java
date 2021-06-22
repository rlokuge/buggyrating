/**
* Support class to manage and read the values from config.properties file
*
* @author  Rumesh Lokuge
* @version 1.0
* @since   2021-06-20
*/
package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

public class PropertyFileReader {

    Properties properties;
    private final Logger logger = (Logger) LogManager.getLogger(PropertyFileReader.class); 
    InputStream inputStream = null;

    public PropertyFileReader() {
        properties = new Properties();
        loadProperties();
    }

    private void loadProperties() {
        try {
            inputStream = new FileInputStream("src/test/resources/config.properties");
            properties.load(inputStream);
        } catch (IOException e) {
            logger.error("Unable to load config.properties file");
        }
    }

    public String readProperty(String key) {
        return properties.getProperty(key);
    }
}