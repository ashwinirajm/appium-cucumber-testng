Feature: Login

  Scenario: Successful login
    Given user is on login screen
    When user logs in with valid credentials
    Then user should see home screen
