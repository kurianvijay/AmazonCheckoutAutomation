package pageObjects;

import functionLibrary.CommonFunctions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class SearchResultsPage extends CommonFunctions {

    public SearchResultsPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "add-to-cart-button")
    public WebElement addToBasket;

    public void clickSearchResultProduct() throws IOException{ String searchTerm= readPropertyFile("searchItem");
       WebElement searchResultProductName =
                driver.findElement(By.xpath("(//*[@id=\"search\"]//*//div[2]/h2/a/span[contains(text(),'"+searchTerm+"')])[1]"));
       explicitWait(searchResultProductName, 30);
       searchResultProductName.click();
    }

    public void addProductToBasket(){
        explicitWait(addToBasket, 30);
        addToBasket.click();
    }
}
