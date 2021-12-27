package com.sdetfasttrack.step_definitions;

import com.sdetfasttrack.pages.WikipediaPage;
import com.sdetfasttrack.utilities.ConfigurationReader;
import com.sdetfasttrack.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WikipediaStepDefinitions {

    WikipediaPage wikipediaPage = new WikipediaPage();


    @Given("user is on the wikipedia main page")
    public void user_is_on_the_wikipedia_main_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("wikiUrl"));
    }

    @When("user searches for Steve Jobs")
    public void user_searches_for_steve_jobs() {
        wikipediaPage.searchField.sendKeys("Steve Jobs");
    }
    @When("user clicks search button")
    public void user_clicks_search_button() {
        wikipediaPage.searchButton.click();
    }
    @Then("user should see Steve Jobs on the title")
    public void user_should_see_steve_jobs_on_the_title() {

        String actualTitle = Driver.getDriver().getTitle();
        System.out.println("actualTitle = " + actualTitle);
        String expectedTitle = "Steve Jobs";
        Assert.assertTrue("Title did not match", actualTitle.contains(expectedTitle));

    }

    @Then("user should see Steve Jobs on the main header")
    public void userShouldSeeSteveJobsOnTheMainHeader() {

        String actualHeader = wikipediaPage.headerTitle.getText();

        System.out.println("actualHeader = " + actualHeader);
        String expectedHeader = "Steve Jobs";

        Assert.assertEquals(expectedHeader,actualHeader);

    }

    @Then("user should see Steve Jobs on the image")
    public void userShouldSeeSteveJobsOnTheImage() {
        String actualImageTitle = wikipediaPage.imageTitle.getText();
        String expectedTitle = "Steve Jobs";


        Assert.assertEquals(expectedTitle,actualImageTitle);
    }


    @When("user searches for {string}")
    public void userSearchesFor(String name) {
        wikipediaPage.searchField.sendKeys(name);
        //wikipediaPage.searchButton.click();
    }

    @Then("user should see {string} on the main header")
    public void userShouldSeeOnTheMainHeader(String name) {
        String actualTitle= wikipediaPage.headerTitle.getText();
        String expectedTitle = name;

        Assert.assertEquals("Title does not match",expectedTitle,actualTitle);
    }
}
