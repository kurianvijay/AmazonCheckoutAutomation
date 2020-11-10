package functionLibrary;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class CommonFunctions {

    public static WebDriver driver;

    public void openBrowser()
    {
        String browser = "chrome";
        if ("chrome".equals(browser)) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if ("firefox".equals(browser)) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else {
            WebDriverManager.operadriver().setup();
            driver = new OperaDriver();
        }
    }

    public void closeBrowser()
    {
        driver.quit();
    }

    public String readPropertyFile(String key) throws IOException {

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

//    public static void screenShot(WebDriver driver, String filename)  {
//        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
//        File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
//        try{
//            FileUtils.copyFile(source, new File("/Users/vijaykurian/IdeaProjects/AmazonCheckoutAutomation/reports/screenshot.png"));
//        }catch (IOException e){
//            e.printStackTrace();
//        }
//     }


}
