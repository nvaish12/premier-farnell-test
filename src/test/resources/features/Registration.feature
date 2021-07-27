Feature: User registration
  As a new user
  I want to register on uk.farnell.com and choose whether my login details are remembered by the site
  so that i can login to the site

  @regdontremember
  Scenario: User registration without remember me option
    Given user is on the premier farnell site registration page
    When user has entered and submitted registration details with remember me check box turned "off"
#    Then user is logged in to the site


  @regremember
  Scenario: User registration with remember me option
    Given user is on the premier farnell site registration page
    When user has entered and submitted registration details with remember me check box turned "on"
#    Then user is logged in to the site

  @multipleRegistrationWithExamples
  Scenario Outline: Multiple user registration
    Given user is on the premier farnell site registration page
    When user enters Username as <UserName>, password as <UserPassword>, email as <UserEmail> and full name as <FullName> with remember me turned <RememberRegistration>
    Examples:
      | UserName    | UserPassword     | UserEmail             | FullName      | RememberRegistration |
      | "TestUser1" | "TestPassword@1" | "testuser1@gmail.com" | "Test user 1" | "on"                 |
      | "TestUser2" | "TestPassword@2" | "testuser2@gmail.com" | "Test user 2" | "off"                |

  @multipleRegistrationWithDataTableList
  Scenario: Multiple user registration
    Given user is on the premier farnell site registration page
    When user submits the following registration details
      | TestUser1 | TestPassword@1 | testuser1@gmail.com | Test user 1 | on  |
      | TestUser2 | TestPassword@2 | testuser2@gmail.com | Test user 2 | off |

  @multipleRegistrationWithDataTableMap
  Scenario: Multiple user registration
    Given user is on the premier farnell site registration page
    When user submits the following multiple registration details
      | UserName  | UserPassword   | UserEmail           | UserFullName | UserRegistration |
      | TestUser1 | TestPassword@1 | testuser1@gmail.com | Test user 1  | on               |
      | TestUser2 | TestPassword@2 | testuser2@gmail.com | Test user 2  | off              |