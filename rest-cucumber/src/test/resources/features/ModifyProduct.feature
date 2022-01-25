@product @update_product
Feature: Update a product

  Scenario: Update a product
    Given the path "update" to the endpoint of updating request
    And the payload of the updating request with BrandName as "ASUS", Features as "32GB RAM,1TB Hard Drive", LaptopName as "Vivobook"
    When I perform request to update a product
    Then the status code "200" should return for updating request
    And the product is updated successfully with new information