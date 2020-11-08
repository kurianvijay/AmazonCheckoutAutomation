package pageObjects;

import functionLibrary.CommonFunctions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Header extends CommonFunctions {

    public Header(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    private Actions action = new Actions(driver);

    @FindBy(id="nav-link-accountList")
    public WebElement signInButton;

    @FindBy(xpath = "//span[contains(text(),'Hello, Vijay')]")
    public WebElement hoverElement;

    @FindBy(xpath = "//span[contains(text(),'Sign Out')]")
    public WebElement signOutButton;

    public void clickOnSignInButton() {
        signInButton.click();
    }

    public void hoverOverElement(){
        action.moveToElement(hoverElement).build().perform();
        explicitWait(hoverElement, 10);
    }

    public void clickOnSignoutButton(){
        signOutButton.click();
    }
}
