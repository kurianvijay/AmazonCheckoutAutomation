package functionLibrary;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class CommonFunctions {

    public  static WebDriver driver;

    public void openBrowser()
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    public void closeBrowser()
    {
        driver.quit();
    }

    public String readPropertyFile(String key) throws IOException {

        FileInputStream inputStream = null;

        try {
            inputStream = new FileInputStream("/Users/vijaykurian/IdeaProjects/AmazonCheckoutAutomation/src/main/resources/config.properties");
        } catch (Exception e) {
            System.out.println(e);
        }
        Properties properties = new Properties();
        properties.load(inputStream);
        String value = properties.getProperty(key);
        return value;
    }
}
