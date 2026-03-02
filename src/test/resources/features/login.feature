Feature: User Login
  As a user
  I want to login to the application
  So that I can access protected features

  Background:
    Given the user is on the login page

  Scenario: Successful login with valid credentials
    When the user enters username "testuser"
    And the user enters password "testpassword"
    And the user clicks the login button
    Then the user should be successfully logged in

  Scenario: Login fails with invalid credentials
    When the user enters username "testuser"
    And the user enters password "wrongpassword"
    And the user clicks the login button
    Then an error message should be displayed

  Scenario: Username field is visible
    Then the username input field should be visible
    And the password input field should be visible
    And the login button should be visible

  Scenario Outline: Login with multiple credentials
    When the user enters username "<username>"
    And the user enters password "<password>"
    And the user clicks the login button
    Then the login result should be "<result>"

    Examples:
      | username | password    | result  |
      | user1    | pass123     | success |
      | user2    | wrongpass   | failure |
      | admin    | adminpass   | success |
