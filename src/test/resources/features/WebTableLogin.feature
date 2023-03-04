Feature: Web table app login functionality
  Agile Story: User should be able to login with correct credentials

  Scenario: Positive login scenario
    Given User is on the Web Table app login page
    When User enters correct username
    And User enters correct password
    And User user clicks to login button
    Then User should see order word in URL

  Scenario: Positive login scenario
    Given User is on the Web Table app login page
    When User enters "Test" username and   "Tester" password
    And User user clicks to login button
    Then User should see order word in URL

  Scenario: Positive login scenario
    Given User is on the Web Table app login page
    When User enters below correct credentials
      | username | Test   |
      | password | Tester |
    And User user clicks to login button
    Then User should see order word in URL