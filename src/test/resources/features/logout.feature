Feature: Logout

  @LogoutSauceDemo @Positive
  Scenario: user success logout
    Given user is already login
    When user click on hamburger button
    And user click on logout
    Then User successfully logout
