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

    @FindBy(name = "email")
    public WebElement emailBox;

    @FindBy(id = "continue")
    public WebElement emailPageContinueButton;

    @FindBy(id = "ap_password")
    public WebElement passwordBox;

    @FindBy(id = "signInSubmit")
    public WebElement signInButton;


    public void enterEmail() throws IOException {
        explicitWait(emailBox, 10);
        emailBox.sendKeys(readPropertyFile("expectedText", "email"));
    }

    public void clickEmailPageContinueButton() {
        emailPageContinueButton.click();
    }

    public void enterPassword() throws IOException {
        explicitWait(passwordBox, 10);
        passwordBox.sendKeys(readPropertyFile("expectedText", "password"));
    }

    public void clickSignInButton( ){
        signInButton.click();
    }
}
