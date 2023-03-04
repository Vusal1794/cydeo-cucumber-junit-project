package com.cydeo.step_definitions;

import com.cydeo.pages.WT_LoginPage;
import com.cydeo.pages.WT_OrderPage;
import com.cydeo.pages.WT_ViewAllOrdersPage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;

import java.util.List;
import java.util.Map;

public class WebTable_StepDefinitions {
    @Given("User is on the Web Table app login page")
    public void user_is_on_the_web_table_app_login_page() {
        Driver.getDriver().get("https://web-table-2.cydeo.com/login");
    }
    WT_LoginPage wtLoginPage = new WT_LoginPage();
    @When("User enters correct username")
    public void user_enters_correct_username() {
        wtLoginPage.inputUsername.sendKeys("Test");
    }
    @When("User enters correct password")
    public void user_enters_correct_password() {
        wtLoginPage.inputPassword.sendKeys("Tester");
    }
    @When("User user clicks to login button")
    public void user_user_clicks_to_login_button() {
        wtLoginPage.loginButton.click();
    }
    @Then("User should see order word in URL")
    public void user_should_see_order_word_in_url() {
        String actualURL = Driver.getDriver().getCurrentUrl();
        String expectedInURL = "order";

        Assert.assertTrue(actualURL.contains(expectedInURL));

    }

    @When("User enters {string} username and   {string} password")
    public void userEntersUsernameAndPassword(String username, String password) {
        wtLoginPage.inputUsername.sendKeys(username);
        wtLoginPage.inputPassword.sendKeys(password);
    }

    @When("User enters below correct credentials")
    public void userEntersBelowCorrectCredentials(Map<String, String> credentials) {
        wtLoginPage.inputUsername.sendKeys(credentials.get("username"));
        wtLoginPage.inputPassword.sendKeys(credentials.get("password"));

    }

    @Given("user is already logged in to The Web Table app")
    public void user_is_already_logged_in_to_the_web_table_app() {
        Driver.getDriver().get("https://web-table-2.cydeo.com/login");
        wtLoginPage.login();

    }

    WT_OrderPage orderPage =new WT_OrderPage();
    @When("user is on the Order page")
    public void user_is_on_the_order_page() {
        orderPage.orderLink.click();
    }
    @Then("user sees below options under product dropdown")
    public void user_sees_below_options_under_product_dropdown(List<String> expectedOptions) {
        List<String> actualOptions =BrowserUtils.dropdownOptions_as_STRING(orderPage.productDropdown);

        Assert.assertEquals(actualOptions,expectedOptions);

    }

    @Then("user sees Visa as enabled option")
    public void userSeesVisaAsEnabledOption() {
        Assert.assertTrue(orderPage.visaRadioButton.isEnabled());
    }

    @Then("user sees MasterCard as enabled option")
    public void userSeesMasterCardAsEnabledOption() {
        Assert.assertTrue(orderPage.masterCardRadioButton.isEnabled());
    }

    @Then("user sees American Express as enabled option")
    public void userSeesAmericanExpressAsEnabledOption() {
        Assert.assertTrue(orderPage.americanExpressRadioButton.isEnabled());
    }

    @And("user enters quantity {string}")
    public void userEntersQuantity(String quantity) {
        orderPage.inputQuantity.sendKeys(Keys.BACK_SPACE);
        //orderPage.inputQuantity.clear();
        orderPage.inputQuantity.sendKeys("2");
    }

    @Then("user clicks to the calculate button")
    public void userClicksToTheCalculateButton() {
        orderPage.calculateButton.click();

    }

    @And("user enter customer name {string}")
    public void userEnterCustomerName(String name) {
        orderPage.inputName.sendKeys(name);

    }

    @Then("user enter street {string}")
    public void userEnterStreet(String street) {
        orderPage.inputStreet.sendKeys(street);
    }

    @And("user enters city {string}")
    public void userEntersCity(String city) {
        orderPage.inputCity.sendKeys(city);
    }

    @Then("user enters state {string}")
    public void userEntersState(String state) {
        orderPage.inputState.sendKeys(state);
    }

    @Then("user enters zip {string}")
    public void userEntersZip(String zip) {
        orderPage.inputZip.sendKeys(zip);
    }

    @Then("user selects payment option {string}")
    public void userSelectsPaymentOption(String expectedCardType) {
        BrowserUtils.clickRadioButton(orderPage.cardTypes, expectedCardType);
    }

    @Then("user enters card number {string}")
    public void userEntersCardNumber(String cardNumber) {
        orderPage.inputCreditCard.sendKeys(cardNumber);
    }

    @Then("user enters expiration date {string}")
    public void userEntersExpirationDate(String expirationDate) {
        orderPage.inputExpirationDate.sendKeys(expirationDate);
    }

    @And("user clicks process order button")
    public void userClicksProcessOrderButton() {
        orderPage.processOrderButton.click();
    }
    WT_ViewAllOrdersPage viewAllOrdersPage =new WT_ViewAllOrdersPage();
    @And("user should see {string} in the first row of the web table")
    public void userShouldSeeInTheFirstRowOfTheWebTable(String expectedName) {
        String actualName = viewAllOrdersPage.newCustomer.getText();
        Assert.assertEquals(actualName, expectedName);
    }
}
