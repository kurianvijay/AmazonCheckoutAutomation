package pageObjects;

import functionLibrary.CommonFunctions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class HomePage extends CommonFunctions {

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@id='twotabsearchtextbox']")
    public WebElement searchBox;

    @FindBy(xpath = "//*[@id=\"nav-search-submit-text\"]/input")
    public WebElement searchIcon;

    public void enterSearchTerm() throws IOException {
        explicitWait(searchBox, 10);
        searchBox.sendKeys(readPropertyFile("expectedText", "searchItem"));
    }

    public void clickSearchIcon(){
        searchIcon.click();
    }
}
