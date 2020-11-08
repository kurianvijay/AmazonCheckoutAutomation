package functionLibrary;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class CommonFunctions {

    public static WebDriver driver;

    public void openBrowser()
    {
        String browser = "chrome";
        switch(browser){
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            default:
                WebDriverManager.operadriver().setup();
                driver = new OperaDriver();
                break;
        }

    }

    public void closeBrowser()
    {
        driver.quit();
    }

    public String readPropertyFile(String expectedText, String key) throws IOException {

        FileInputStream inputStream = null;

        try {
            inputStream = new FileInputStream("/Users/vijaykurian/IdeaProjects/AmazonCheckoutAutomation/src/main/resources/config.properties");
        }
        catch (Exception e) {
            System.out.println(e);
        }

        Properties properties = new Properties();
        properties.load(inputStream);
        String value = properties.getProperty(key);
        return value;
    }

    public void implicitWait(int time){
        driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
    }

    public void explicitWait(WebElement element, int maxTime){
        WebDriverWait wait = new WebDriverWait(driver, maxTime);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

}
