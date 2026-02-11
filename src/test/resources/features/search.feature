@Search @Smoke
Feature: Product search on Decathlon website

  Scenario: Search multiple products using excel data
    Given User is on Decathlon home page
    When User performs product search using excel data
    Then Search results should be displayed for all products
