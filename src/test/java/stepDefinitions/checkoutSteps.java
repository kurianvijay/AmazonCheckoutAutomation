package stepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import functionLibrary.CommonFunctions;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class checkoutSteps extends CommonFunctions  {

    private Actions action = new Actions(driver);

    @Given("^that I am on the Amazon page$")
    public void that_I_am_on_the_Amazon_page() throws IOException {
        driver.get(readPropertyFile("url"));
    }

    @Given("^I click on the Sign In button$")
    public void i_click_on_the_Sign_In_button() {
        driver.findElement(By.id("nav-link-accountList")).click();
    }

    @When("^I add my email$")
    public void i_add_my_email() throws IOException  {
        driver.findElement(By.name("email")).sendKeys(readPropertyFile("email"));
    }

    @When("^I click the Continue button$")
    public void i_click_the_Continue_button() {
        driver.findElement(By.id("continue")).click();
    }

    @When("^I enter my password$")
    public void i_enter_my_password() throws IOException {

        driver.findElement(By.id("ap_password")).sendKeys(readPropertyFile("password"));
    }

    @When("^I click the Sign In button$")
    public void i_click_the_Sign_In_button()  {
        driver.findElement(By.id("signInSubmit")).click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @When("^I search for an item \"([^\"]*)\"$")
    public void i_search_for_an_item(String searchItem)  {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys(searchItem);
    }

    @Then("^I click the search button$")
    public void i_click_the_search_button()  {
        driver.findElement(By.xpath("//*[@id=\"nav-search-submit-text\"]/input")).click();
    }

    @When("^I add it into my checkout basket$")
    public void i_add_it_into_my_checkout_basket()  {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//        driver.findElement(By.xpath("(//span[contains(text(),'Baby Proofing & Corner Cushion Protector Set')])[2]")).click();
        driver.findElement(By.xpath("(//span[contains(text(),'Baby Proofing & Corner Cushion Protector Set')])[4]")).click();
        driver.findElement(By.id("add-to-cart-button")).click();
    }

    @When("^I go to my checkout basket$")
    public void i_go_to_my_checkout_basket()  {
        driver.findElement(By.id("//span[@id='nav-cart-count']")).click();
    }

    @Then("^I should be able to see it in my checkout basket \"([^\"]*)\"$")
    public void i_should_be_able_to_see_it_in_my_checkout_basket(String expectedText)  {
        String actualText = driver.findElement(By.xpath("(//span[contains(text(),'Baby Proofing & Corner Cushion Protector Set')])[1]")).getText();

        Assert.assertEquals(expectedText, actualText);
    }

    @Then("^I should be able to clear the contents of my basket$")
    public void i_should_be_able_to_clear_the_contents_of_my_basket()  {
        Select basketQuantity = new Select(driver.findElement(By.xpath("//span[@id='a-autoid-0-announce']")));
        basketQuantity.selectByVisibleText("Delete");
    }

    @Then("^I should be able to logout$")
    public void i_should_be_able_to_logout()  {
        WebElement hoverElement = driver.findElement(By.xpath("//span[contains(text(),'Hello, Vijay')]"));
        action.moveToElement(hoverElement).build().perform();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//span[contains(text(),'Sign Out')]")).click();
//        action.moveToElement((WebElement) By.id("nav-link-accountList")).build().perform();


    }


}