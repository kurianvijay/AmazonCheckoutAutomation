package pageObjects;

import functionLibrary.CommonFunctions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class LoginPage extends CommonFunctions {

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    HomePage homePage = new HomePage(driver);

    @FindBy(name = "email")
    public WebElement emailBox;

    @FindBy(id = "continue")
    public WebElement emailPageContinueButton;

    @FindBy(id = "ap_password")
    public WebElement passwordBox;

    @FindBy(id = "signInSubmit")
    public WebElement signInButton;

    @FindBy(xpath = "//div[@class='a-box']")
    public WebElement signInForm;

    public void getURL() throws IOException {
        driver.get(readPropertyFile("url"));
    }

    public void enterEmail() throws IOException {
        explicitWait(emailBox, 10);
        emailBox.sendKeys(readPropertyFile("email"));
    }

    public void clickEmailPageContinueButton() {
        emailPageContinueButton.click();
    }

    public void enterPassword() throws IOException {
        explicitWait(passwordBox, 10);
        passwordBox.sendKeys(readPropertyFile("password"));
    }

    public void clickSignInButton(){
        signInButton.click();
        explicitWait(homePage.searchBox,30);
    }


}
