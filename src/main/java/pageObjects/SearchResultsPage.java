package pageObjects;

import functionLibrary.CommonFunctions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultsPage extends CommonFunctions {

    public SearchResultsPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    private CommonFunctions commonObject1 = new CommonFunctions();

    @FindBy(xpath = "(//span[contains(text(),'Baby Proofing & Corner Cushion Protector Set')])[4]")
    public WebElement searchResultProduct;

    @FindBy(id = "add-to-cart-button")
    public WebElement addToBasket;

    public void clickSearchResultProduct(){
        commonObject1.explicitWait(searchResultProduct, 10);
        searchResultProduct.click();
    }

    public void addProductToBasket(){
        addToBasket.click();
    }
}
