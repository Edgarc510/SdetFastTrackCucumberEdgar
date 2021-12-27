Feature: Wikipedia Search Feature

  Scenario: Wikipedia search title verification
    Given user is on the wikipedia main page
    When user searches for Steve Jobs
    And user clicks search button
    Then user should see Steve Jobs on the title

  Scenario: Wikipedia Search header verification
    Given user is on the wikipedia main page
    When user searches for Steve Jobs
    And user clicks search button
    Then user should see Steve Jobs on the main header

  Scenario: Wikipedia Search image verification
    Given user is on the wikipedia main page
    When user searches for Steve Jobs
    And user clicks search button
    Then user should see Steve Jobs on the image

  @wikipedia
  Scenario: Wikipedia Search header verification
    Given user is on the wikipedia main page
    When user searches for "Steve Jobs"
    And user clicks search button
    Then user should see "Steve Jobs" on the main header