Feature: Add To Cart

  @AddToCartProduct @Positive
  Scenario: user success add to cart product
    Given user on Product Page
    When user click Add to Cart button
    Then Add To Cart button turn into Remove button
