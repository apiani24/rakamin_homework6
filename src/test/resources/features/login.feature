Feature: Login functionality

  @LoginSauceDemo @Positive
  Scenario: Ensure user successfully login
    #precondition
    Given user is on SauceDemo homepage
    #steps
    When user input valid username
    And user input valid password
    And user click Login button
    #expected
    Then User is on Product Page

  @LoginSauceDemo @Negative
  Scenario: Ensure user failed login with invalid username
    #precondition
    Given user is on SauceDemo homepage
    #steps
    When user input invalid username
    And user input valid password
    And user click Login button
    #expected
    Then user get error message
