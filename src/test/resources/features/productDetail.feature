Feature: Product Detail

  @DetailProductSauceDemo @Positive
  Scenario: user success view product detail
    Given user success access Product Page
    When user click on a product name
    Then User is on Product Detail Page
