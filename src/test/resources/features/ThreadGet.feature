@test
Feature: Thread get Page

  @thread
  Scenario Outline: Verify the GET request for thread
    Given I make a get api call to "<threadName>"
    Then I verify the response code is "<ResponseCode>"

    Examples:
      | threadName                       | ResponseCode |
      | http://127.0.0.1:8080/v1/dummy/1 | 200          |