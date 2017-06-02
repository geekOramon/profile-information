Feature: Create an user
  Scenario: client call POST to /user
    When the client calls /user with POST
    Then the client receives an user created with the id 1