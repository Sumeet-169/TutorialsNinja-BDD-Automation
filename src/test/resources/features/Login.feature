Feature: User Login

  Scenario: Verify successful user login with valid credentials

    Given USER is on "TutorialsNinja" page
    When USER navigates to "Login" page from "My Account"
    And USER enters value "test@example.com" in "Email"
    And USER enters configured login password in "Password"
    And USER clicks on the button "Login"
    Then USER validates "My Account" page is displayed