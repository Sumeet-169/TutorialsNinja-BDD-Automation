package stepDefinitions;

import driver.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.RegistrationPage;
import utils.ConfigReader;

public class RegisterPageStepDefs {

    private final RegistrationPage registrationPage = new RegistrationPage();
    private String generatedEmail;
    private final HomePage homePage = new HomePage();

    @Given("^USER is on \"([^\"]*)\" page$")
    public void userIsOnPage(String pageName) {
        DriverFactory.getDriver().get(ConfigReader.getProperty("baseUrl"));
    }

    @When("^USER navigates to \"([^\"]*)\" page from \"([^\"]*)\"$")
    public void userNavigatesToPageFrom(String targetPage, String menuName) {
        homePage.clickMyAccount();
        homePage.clickRegister();
    }

    @When("^USER enters value \"([^\"]*)\" in \"([^\"]*)\"$")
    public void userEntersValue(String value, String fieldName) {
        switch (fieldName) {

            case "First Name":
                registrationPage.enterFirstName(value);
                break;

            case "Last Name":
                registrationPage.enterLastName(value);
                break;

            case "Telephone":
                registrationPage.enterTelephone(value);
                break;

            default:
                throw new IllegalArgumentException("Unsupported registration field: " + fieldName);
        }
    }

    @When("^USER generates a unique email address and enters it in \"([^\"]*)\"$")
    public void userGeneratesUniqueEmailAddressAndEntersItIn(String fieldName) {
        generatedEmail ="sumeet" + System.currentTimeMillis() + "@gmail.com";
//        System.out.println("Generated Email: " + generatedEmail);
        registrationPage.enterEmail(generatedEmail);
    }

    @When("^USER enters configured password in \"([^\"]*)\"$")
    public void userEntersConfiguredPasswordIn(String fieldName) {
        String password = ConfigReader.getProperty("registration.password");
        switch (fieldName) {

            case "Password":
                registrationPage.enterPassword(password);
                break;

            case "Password Confirm":
                registrationPage.enterConfirmPassword(password);
                break;

            default:
                throw new IllegalArgumentException(
                        "Unsupported password field: " + fieldName
                );
        }
    }

    @When("^USER accepts the \"([^\"]*)\"$")
    public void userAcceptsThe(String policyName) {

        if (!policyName.equalsIgnoreCase("Privacy Policy")) {
            throw new IllegalArgumentException("Unsupported policy: " + policyName);
        }
        registrationPage.acceptPrivacyPolicy();
    }

    @When("^USER clicks on the button \"([^\"]*)\"$")
    public void userClicksOnTheButton(String buttonName) {

        if (!buttonName.equalsIgnoreCase("Continue")) {
            throw new IllegalArgumentException("Unsupported button: " + buttonName);
        }
        registrationPage.clickContinue();
    }

    @Then("^USER validates \"([^\"]*)\" page is displayed$")
    public void userValidatesPageIsDisplayed(String pageName) {

        if (!pageName.equalsIgnoreCase("Account Created")) {
            throw new IllegalArgumentException("Unsupported validation page: " + pageName);
        }
        boolean isDisplayed =registrationPage.isAccountCreatedPageDisplayed();
        if (!isDisplayed) {
            throw new AssertionError("Account Created page is not displayed.");
        }
    }
}