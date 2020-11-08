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
import pageObjects.*;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class checkoutSteps extends CommonFunctions  {

    private Actions action = new Actions(driver);

    Header header = new Header(driver);
    LoginPage loginPage = new LoginPage(driver);
    HomePage homePage = new HomePage(driver);
    SearchResultsPage searchResultsPage = new SearchResultsPage(driver);
    BasketPage basketPage = new BasketPage(driver);

    @Given("^that I am on the Amazon page$")
    public void that_I_am_on_the_Amazon_page() throws IOException {
        driver.get(readPropertyFile("expectedText", "url"));
    }

    @Given("^I click on the Sign In button$")
    public void i_click_on_the_Sign_In_button() {
        header.clickOnSignInButton();
    }

    @When("^I add my email$")
    public void i_add_my_email() throws IOException  {
        loginPage.enterEmail();
    }

    @When("^I click the Continue button$")
    public void i_click_the_Continue_button() {
        loginPage.clickEmailPageContinueButton();
    }

    @When("^I enter my password$")
    public void i_enter_my_password() throws IOException {
        loginPage.enterPassword();
    }

    @When("^I click the Sign In button$")
    public void i_click_the_Sign_In_button()  {
        loginPage.clickSignInButton();
    }

    @When("^I search for an item$")
    public void i_search_for_an_item() throws IOException {
        homePage.enterSearchTerm();
    }

    @Then("^I click the search button$")
    public void i_click_the_search_button()  {
        homePage.clickSearchIcon();
    }

    @When("^I add it into my checkout basket$")
    public void i_add_it_into_my_checkout_basket()  {
        searchResultsPage.clickSearchResultProduct();
        searchResultsPage.addProductToBasket();
    }

    @When("^I go to my checkout basket$")
    public void i_go_to_my_checkout_basket()  {
        basketPage.clickOnBasket();
    }

    @Then("^I should be able to see it in my checkout basket$")
    public void i_should_be_able_to_see_it_in_my_checkout_basket() throws IOException {
        String actualText = basketPage.getItemDescription();
        Assert.assertEquals(readPropertyFile("expectedText", "expectedText"), actualText);
    }


    @Then("^I should be able to clear the contents of my basket$")
    public void i_should_be_able_to_clear_the_contents_of_my_basket()  {
        basketPage.clickQuantity();
        basketPage.selectFromQuantityDropDown();
    }

    @Then("^I should be able to logout$")
    public void i_should_be_able_to_logout()  {
        header.hoverOverElement();
        header.clickOnSignoutButton();
    }

}