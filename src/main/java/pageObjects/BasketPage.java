package pageObjects;

import functionLibrary.CommonFunctions;
import org.junit.Assert;
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

    @FindBy(xpath = "(//span[contains(text(),'Baby Proofing & Corner Cushion Protector Set')])[1]")
    public WebElement itemDescription;

    @FindBy(xpath = "//span[@id='a-autoid-0-announce']")
    public WebElement quantity;

    @FindBy(xpath = "//select[@name='quantity']")
    public WebElement quantityDropDown;

    public void clickOnBasket() {
        explicitWait(basket, 10);
        basket.click();
    }

    public String getItemDescription(){
        explicitWait(basket, 10);
        String actualText = itemDescription.getText();
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

//    public void compareItemDescription() throws IOException {
//        BasketPage basketPageObject = new BasketPage(driver);
//        String text = basketPageObject.getItemDescription();
//        Assert.assertEquals(String basketPageObject.readPropertyFile("expectedText", text ));
//    "Baby Proofing & Corner Cushion Protector Set I Baby Safety Bumpers & Edge Guard to Child Proof Furniture & Tables I Pre-Taped Corners I Bumper Safe Protector I [6.2m + 8 Corner Guards] Coffee Brown"
//    }

}
