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

    Header header = new Header(driver);
    LoginPage loginPage = new LoginPage(driver);
    HomePage homePage = new HomePage(driver);
    SearchResultsPage searchResultsPage = new SearchResultsPage(driver);
    BasketPage basketPage = new BasketPage(driver);

    @Given("^that I am on the Amazon page$")
    public void that_I_am_on_the_Amazon_page() throws IOException {
       loginPage.getURL();
    }

    @When("^I login with my username and password$")
    public void i_login_with_my_username_and_password() throws IOException {
        header.clickOnSignInButton();
        loginPage.enterEmail();
        loginPage.clickEmailPageContinueButton();
        loginPage.enterPassword();
        loginPage.clickSignInButton();
    }

    @When("^I search for an item$")
    public void i_search_for_an_item() throws IOException {
        homePage.enterSearchTerm();
        homePage.clickSearchIcon();
    }

    @When("^I add it into my checkout basket$")
    public void i_add_it_into_my_checkout_basket() throws IOException {
        searchResultsPage.clickSearchResultProduct();
        searchResultsPage.addProductToBasket();
        basketPage.clickOnBasket();
    }

    @Then("^I should be able to see it in my checkout basket$")
    public void i_should_be_able_to_see_it_in_my_checkout_basket() throws IOException {
        String actualText = basketPage.getItemDescription();
        String partialExpectedText= readPropertyFile( "expectedText");
        Assert.assertTrue(actualText.contains(partialExpectedText));
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
        Assert.assertTrue(loginPage.signInForm.isDisplayed());
    }

}