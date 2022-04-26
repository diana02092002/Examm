package yandexmarket.Utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Properties;

public class ConfigFileReader {
    public static ConfigFileReader configFileReader = new ConfigFileReader();
    private Properties properties;
    private final String propertyFileName = "config.properties";

    private ConfigFileReader() {
        String propertyFilePath = getClass().getClassLoader().getResource(propertyFileName).getFile();
        try (BufferedReader reader = new BufferedReader(
                new FileReader(propertyFilePath.replaceAll("%20"," ")))) {
            properties = new Properties();
            properties.load(reader);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getDriverPath() {
        String driverPath = properties.getProperty("driverPath");
        if (driverPath != null) return driverPath;
        else throw new RuntimeException("driverPath not specified in the Configuration.properties file.");
    }

    public String getDriverAdapter(){
        String driverAdapter = properties.getProperty("driverAdapter");
        if (driverAdapter != null) return driverAdapter;
        else throw new RuntimeException("driverPath not specified in the Configuration.properties file.");
    }

    public String getApplicationUrl() {
        String url = properties.getProperty("url");
        if (url != null) return url;
        else throw new RuntimeException("url not specified in the Configuration.properties file.");
    }

    public String getLogin(){
        String login = properties.getProperty("login");
        if (login != null) return login;
        else throw new RuntimeException("url not specified in the Configuration.properties file.");
    }

    public String getPassword(){
        String password = properties.getProperty("password");
        if (password != null) return password;
        else throw new RuntimeException("url not specified in the Configuration.properties file.");
    }
    public String getDomain(){
        String domain = properties.getProperty("domain");
        if (domain != null) return domain;
        else throw new RuntimeException("url not specified in the Configuration.properties file.");
    }
    public String getEmail(){
        String email = properties.getProperty("email");
        if (email != null) return email;
        else throw new RuntimeException("url not specified in the Configuration.properties file.");
    }

    public int getTimeWait(){
        String timeWait = properties.getProperty("timeWait");
        if (timeWait != null) return Integer.parseInt(timeWait);
        else throw new RuntimeException("url not specified in the Configuration.properties file.");
    }

    public String getBrowserName(){
        String browserName = properties.getProperty("browserName");
        if (browserName != null) return browserName;
        else throw new RuntimeException("url not specified in the Configuration.properties file.");
    }

    public static void main(String[] args) {
        String login= configFileReader.getLogin();
        System.out.println(login);
    }
}
