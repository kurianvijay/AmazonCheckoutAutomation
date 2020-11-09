package pageObjects;

import functionLibrary.CommonFunctions;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.io.IOException;

public class BasketPage extends CommonFunctions {

    public BasketPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[@id='nav-cart-count']")
    public WebElement basket;

    @FindBy(xpath = "//span[@id='a-autoid-0-announce']")
    public WebElement quantity;

    @FindBy(xpath = "//select[@name='quantity']")
    public WebElement quantityDropDown;

    public void clickOnBasket() {
        explicitWait(basket, 10);
        basket.click();
    }

    public String getItemDescription() throws IOException {
        explicitWait(basket, 10);
        String searchTerm= readPropertyFile("searchItem");
        String actualText =
                driver.findElement(By.xpath("(*//span[@class='a-list-item']/a/span[contains(text(),'"+searchTerm+"')])[1]")).getText();
        return actualText;
    }

    public void clickQuantity(){
        explicitWait(quantity, 10);
        quantity.click();
    }

    public void selectFromQuantityDropDown(){
        explicitWait(quantityDropDown, 10);
        Select dropDown = new Select(quantityDropDown);
        dropDown.selectByVisibleText("0 (Delete)");
    }

}
