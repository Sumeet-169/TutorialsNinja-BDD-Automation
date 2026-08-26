package pages;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.WebActions;

public class RegistrationPage {

    private final WebDriver driver = DriverFactory.getDriver();

    private final By firstNameField = By.name("firstname");
    public void enterFirstName(String firstName) {
        WebActions.enterText(firstNameField, firstName);
    }

    private final By lastNameField = By.name("lastname");
    public void enterLastName(String lastName) {
        WebActions.enterText(lastNameField, lastName);
    }

    private final By emailField = By.name("email");
    public void enterEmail(String email) {
        WebActions.enterText(emailField, email);
    }

    private final By telephoneField = By.name("telephone");
    // Enters the telephone number.
    public void enterTelephone(String telephone) {
        WebActions.enterText(telephoneField, telephone);
    }

    private final By passwordField = By.name("password");
    public void enterPassword(String password) {
        WebActions.enterText(passwordField, password);
    }

    private final By confirmPasswordField = By.name("confirm");
    public void enterConfirmPassword(String password) {
        WebActions.enterText(confirmPasswordField, password);
    }

    private final By privacyPolicyCheckbox = By.name("agree");
    public void acceptPrivacyPolicy() {
        driver.findElement(privacyPolicyCheckbox).click();
    }

    private final By continueButton =
            By.cssSelector("input[type='submit'][value='Continue']");
    public void clickContinue() {
        driver.findElement(continueButton).click();
    }

    private final By accountCreatedHeading =
            By.xpath("//h1[normalize-space()='Your Account Has Been Created!']");

    public boolean isAccountCreatedPageDisplayed() {
        return driver.findElement(accountCreatedHeading).isDisplayed();
    }
   }