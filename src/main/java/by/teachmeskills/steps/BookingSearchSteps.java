package by.teachmeskills.steps;

import by.teachmeskills.dto.Characteristics;
import by.teachmeskills.pages.BookingSearchPage;
import io.cucumber.java.DataTableType;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.Map;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.assertj.core.api.Assertions.assertThat;

public class BookingSearchSteps {

    BookingSearchPage searchPage = new BookingSearchPage();

    @Given("User is on {string} page")
    public void userIsOnPage(String pageAddress) {
        open(pageAddress);
    }

    @When("User searches for {string}")
    public void userSearchesFor(String searchText) {
        searchPage.searchInCatalog(searchText);
    }

    @Then("{string} is the first search result")
    public void isTheFirstSearchResult(String searchResultTitle) {
        String actualTitle = searchPage.getSearchResultProductTitles();
        assertThat(actualTitle).as("The first search result in incorrect").contains(searchResultTitle);
    }

    @And("The browser is maximized")
    public void theBrowserIsMaximized() {
        getWebDriver().manage().window().maximize();
    }

    @And("Click on the search button")
    public void clickSearch() {
        BookingSearchPage bookingSearchPage = new BookingSearchPage();
        bookingSearchPage.clickSearchButton();
    }

    @DataTableType
    public Characteristics characteristics(Map<String, String> entry) {
        return new Characteristics(
                entry.get("scored"));
    }

    @And("Search result contains the next characteristics")
    public void searchResultContainsTheNextCharacteristics(Characteristics characteristics) {
        String productDetails = searchPage.getSearchResultProductScore();
        assertThat(productDetails).as("The scored is invalid in description").contains(characteristics.getScored());
    }

}