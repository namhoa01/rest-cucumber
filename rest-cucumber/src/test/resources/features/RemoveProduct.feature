@product @delete_product
Feature: Delete a product

  Scenario: Delete a product
    Given the path "delete/{id}" to the endpoint of deleting request
    When I perform request to delete a product
    Then the status code "200" should return for deleting request