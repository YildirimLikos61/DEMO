@OneBook5
Feature: Get one book from API

    
    Background:
    Given I provided URI
    And I provide the ISBN "9781449325862" as the querry parameters
    
    
    Scenario: Get one book and validate the response
  
    When I make a GET call to the Get one book endpoint
    Then I validate that status code is 200
    And I validate taht the ISBN in the response body is "9781449325862"
    