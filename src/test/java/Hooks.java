import com.cucumber.listener.Reporter;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import functionLibrary.CommonFunctions;
import org.junit.AfterClass;
import org.junit.Test;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;

import java.io.IOException;

public class Hooks extends CommonFunctions {

    @Before
    public void beforeTest() {
        openBrowser();
    }

    @After
    public void afterTest() {
        closeBrowser();
    }
//    public void afterTest(ITestResult result)  {
//        if(result.FAILURE==result.getStatus())
//        {
//            screenShot(driver, result.getName());
//        }
//        closeBrowser();
//    }
    @AfterClass
    public static void generateTestSummaryReport()
    {
        Reporter.loadXMLConfig("/Users/vijaykurian/IdeaProjects/AmazonCheckoutAutomation/src/main/resources/config/extent-config.xml");
    }
}
