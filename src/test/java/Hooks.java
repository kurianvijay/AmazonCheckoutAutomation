import com.cucumber.listener.Reporter;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import functionLibrary.CommonFunctions;
import org.junit.AfterClass;
import org.junit.Test;

public class Hooks extends CommonFunctions {

    CommonFunctions commonObject = new CommonFunctions();

    @Before
    public void beforeTest() {
        commonObject.openBrowser();
    }

    @Test

    @After
    public void afterTest() {
        commonObject.closeBrowser();
    }

    @AfterClass
    public static void generateTestSummaryReport()
    {
        Reporter.loadXMLConfig("https://stackoverflow.com/questions/6642146/maven-failed-to-read-artifact-descriptor");
    }
}
