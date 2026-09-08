package pages;
import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.WebActions;

    public class LoginPage {
        private final WebDriver driver = DriverFactory.getDriver();

        private final By emailField = By.name("email");

        public void enterEmail(String email) {
            WebActions.enterText(emailField, email);
        }

        private final By passwordField = By.name("password");

        public void enterPassword(String password) {
            WebActions.enterText(passwordField, password);
        }

        private final By loginButton = By.cssSelector("input[type='submit'][value='Login']");

        public void clickLogin() {
            WebActions.click(loginButton);
        }

        // Validates that the My Account page is displayed.
        public boolean isMyAccountPageDisplayed() {

            return driver.findElement(
                    By.xpath("//h2[normalize-space()='My Account']")
            ).isDisplayed();
        }
    }