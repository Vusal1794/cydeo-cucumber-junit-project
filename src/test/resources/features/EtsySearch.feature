Feature: Etsy search functionality
  Agile Story: User should be able to type any keyword and see relevant information

  Scenario: Etsy Title Verification
    Given User is on Etsy homepage
    Then User should see title is as expected
    #ExpectedTitl: Etsy _ Shop for handmade, vintage, custom, and unique gifts for everyone

  Scenario: Etsy Search Functionality Title Verification (without parametrization)
    Given User is on Etsy homepage
    When User types Wooden Spoon in the search box
    And User clicks to Etsy search button
    Then User sees Wooden Spoon is in the title

  Scenario: Etsy Search Functionality Title Verification (with parametrization)
    Given User is on Etsy homepage
    When User types "Wooden Spoon" in the search box
    And User clicks to Etsy search button
    Then User sees "Wooden spoon - Etsy" is in the title