package by.teachmeskills.pages;

import static com.codeborne.selenide.Selenide.$x;

public class BookingSearchPage {
    public void searchInCatalog(String searchText) {
        $x("//div[text()='Destination/property name:']//following::input[@name='ss']").sendKeys(searchText);
    }

    public String getSearchResultProductTitles() {
        return $x("//div[@data-testid=\"property-card\"]//following::div[@data-testid=\"title\"]").getText();
    }

    public String getSearchResultProductScore() {
        return $x("//div[@data-testid='property-card']//following::div[contains(@aria-label, 'Scored')]").getText();
    }

    public void clickSearchButton() {
        $x("//span[text()='Search']//ancestor::button").click();
    }
}