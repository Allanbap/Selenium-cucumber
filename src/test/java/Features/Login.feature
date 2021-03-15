Feature: LoginFeature
  this feature deals with the login funcionality of the application

  Scenario: Login with Correct username and password
    Given  I navigate to the login page
    And I enter the username:admin and password:pass
    And I click login  button
    Then I should see the userform page

