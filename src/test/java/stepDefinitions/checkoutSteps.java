package stepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import functionLibrary.CommonFunctions;
import org.junit.Assert;
import org.openqa.selenium.By;

import java.util.concurrent.TimeUnit;

public class checkoutSteps extends CommonFunctions {

    @Given("^that I am on the Amazon page \"([^\"]*)\"$")
    public void that_I_am_on_the_Amazon_page(String url)  {
        driver.get(url);
    }

    @Given("^I click on the Sign In button$")
    public void i_click_on_the_Sign_In_button() {
        driver.findElement(By.id("nav-link-accountList")).click();
    }

    @When("^I add my email \"([^\"]*)\"$")
    public void i_add_my_email(String email)  {
        driver.findElement(By.name("email")).sendKeys(email);
    }

    @When("^I click the Continue button$")
    public void i_click_the_Continue_button() {
        driver.findElement(By.id("continue")).click();
    }

    @When("^I enter my password \"([^\"]*)\"$")
    public void i_enter_my_password(String password)  {
        driver.findElement(By.id("ap_password")).sendKeys(password);
    }

    @When("^I click the Sign In button$")
    public void i_click_the_Sign_In_button()  {
        driver.findElement(By.id("signInSubmit")).click();
    }

    @When("^I search for an item \"([^\"]*)\"$")
    public void i_search_for_an_item(String searchItem)  {
        driver.findElement(By.name("field-keywords")).sendKeys(searchItem);
    }

    @Then("^I click the search button$")
    public void i_click_the_search_button()  {
        driver.findElement(By.xpath("//*[@id=\"nav-search\"]/form/div[2]/div/input")).click();
    }

    @When("^I add it into my checkout basket$")
    public void i_add_it_into_my_checkout_basket()  {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//*[@id=\"search\"]/div[1]/div[2]/div/span[3]/div[2]/div[7]/div/span/div/div/div[2]/h2/a/span")).click();
        driver.findElement(By.id("add-to-cart-button")).click();
    }

    @When("^I go to my checkout basket$")
    public void i_go_to_my_checkout_basket()  {
        driver.findElement(By.id("hlb-view-cart-announce")).click();
    }

    @Then("^I should be able to see it in my checkout basket \"([^\"]*)\"$")
    public void i_should_be_able_to_see_it_in_my_checkout_basket(String expectedText)  {
        String actualText = driver.findElement(By.xpath("//*[@id=\"sc-item-Cfe76a032-8663-4236-9d12-43307e495086\"]/div[4]/div/div[1]/div/div/div[2]/ul/li[1]/span/a/span[1]")).getText();

        Assert.assertEquals(expectedText, actualText);
    }

}
