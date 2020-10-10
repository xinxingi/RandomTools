import java.io.*;
import java.util.Properties;

public class Utils {
    public static String getProperties(String key){

        Properties properties = new Properties();

        String propertiesPath = System.getProperties().getProperty("user.dir");
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(propertiesPath + "/random.properties");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        try {
            properties.load(bufferedReader);
        } catch (IOException e) {
            e.printStackTrace();
        }

        String value = properties.getProperty(key);

        return value;
    }

    public static void setProperties(String key, String value) {

        Properties properties = new Properties();

        String propertiesPath = System.getProperties().getProperty("user.dir");
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(propertiesPath + "/random.properties");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        try {
            properties.load(bufferedReader);
        } catch (IOException e) {
            e.printStackTrace();
        }

        properties.setProperty(key, value);
        FileOutputStream oFile = null;
        try {
             oFile = new FileOutputStream(propertiesPath + "/random.properties");
            properties.store(oFile, "");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                oFile.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}
