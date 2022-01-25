@product @delete_product
Feature: Get a product

  Scenario: Get a product
    Given the path "find/{id}" to the endpoint of getting request
    When I perform request to get a product
    Then the status code "200" should return for getting request
    And the product is returned successfully with the provided Id