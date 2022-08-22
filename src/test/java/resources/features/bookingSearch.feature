Feature: Booking search

  Background:
    Given User is on "https://www.booking.com/searchresults.en-gb.html" page

  Scenario: Search for "Sphinx Aqua Park Beach Resort" in the Booking
    And The browser is maximized
    When User searches for "Sphinx Aqua Park Beach Resort"
    And Click on the search button
    Then "Sphinx Aqua Park Beach Resort" is the first search result
    And Search result contains the next characteristics
      | scored |
      | 7.4    |