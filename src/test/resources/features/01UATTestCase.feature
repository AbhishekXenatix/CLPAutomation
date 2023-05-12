Feature: Verify the UAT Test case 01

  Scenario Outline: New User Registration
    Given user will navigate to the registration page
    When user will enter the personal information
    And user will select the title
    And user will enter the name "<FirstName>" and "<LastName>"
    And user will enter the "<Email>"
    And user will enter the password "<Password>" and "<CPassword>"
    And user will click on the check box
    Then user account created
    Examples:
      | FirstName | LastName | Email       | Password | CPassword |
      | Test      | LastTest | a@gmail.com | Test@123 | Test@123  |




  Scenario Outline: Login page to CLPdomeo
    Given user navigate to url "<url>"
    Then user on the login page
    When user enter username "<username>" and password "<password>"
    And click login button
    Then The user redirect to Dashboard page
    Examples:
      | url                          | username                     | password  |
      | https://www.clpdomeo.com/en/ | abhishektesting183@gmail.com | Master@07 |