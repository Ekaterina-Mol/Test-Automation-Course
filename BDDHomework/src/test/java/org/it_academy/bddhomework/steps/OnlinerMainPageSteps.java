package org.it_academy.bddhomework.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.it_academy.bddhomework.pageobject.HomePage;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class OnlinerMainPageSteps {
    private HomePage homePage = new HomePage();

    @Given("the user opens Onliner main page")
    public void userOpensHomePage() {
        this.homePage.navigateToHomePage(); }

    @When("the user hovers {string} menu item")
    public void userHoversMenuItem(String menuItem){ this.homePage.hoverMenuItem(menuItem); }

    @Then("context menu with categories is displayed")
    public void contextMenuDisplayedWithCategory() {
        assertThat(this.homePage.isContextMenuDisplayed())
                .as("Context menu is not displayed")
                .isTrue();
    }
}
