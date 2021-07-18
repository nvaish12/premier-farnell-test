Feature: User registration
  As a new user
  I want to register on uk.farnell.com and choose whether my login details are remembered by the site
  so that i can login to the site

  @regdontremember
  Scenario: User registration without remember me option
    Given user is on the premier farnell site registration page
    When user has entered and submitted registration details with remember me check box turned "off"
    Then user is logged in to the site


  @regremember
  Scenario: User registration with remember me option
    Given user is on the premier farnell site registration page
    When user has entered and submitted registration details with remember me check box turned "on"
    Then user is logged in to the site