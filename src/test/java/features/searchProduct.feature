Feature: Search and Place the order for Products
  @OffersPage
  Scenario Outline: Search experience
    Given User is on GreenCart Landing page
    When User searched with shortname <Name> and extracted actual name of product
    Then User searched for same shortname <Name> in offers page
    And Validate product name in offers page matches with Landing Page
    Examples:
    | Name |
    | Tom  |
    | Beet |