Feature: User Registration for TutorialsNinja

  Scenario Outline: Verify successful user registration with valid details

    Given USER is on "TutorialsNinja" page
    When USER navigates to "Register" page from "My Account"
    And USER enters value "<firstName>" in "First Name"
    And USER enters value "<lastName>" in "Last Name"
    And USER generates a unique email address and enters it in "Email"
    And USER enters value "<telephone>" in "Telephone"
    And USER enters configured password in "Password"
    And USER enters configured password in "Password Confirm"
    And USER accepts the "Privacy Policy"
    And USER clicks on the button "Continue"
    Then USER validates "Account Created" page is displayed

    Examples:
      | firstName | lastName | telephone  |
      | Sumeet    | Padekar  | 1325456987 |