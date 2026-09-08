package stepDefinitions;

import driver.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.LoginPage;
import utils.ConfigReader;

public class LoginPageStepDefs {

    private final HomePage homePage = new HomePage();
    private final LoginPage loginPage = new LoginPage();


    @When("^USER enters configured login password in \"([^\"]*)\"$")
    public void userEntersConfiguredLoginPasswordIn(String fieldName) {
        String password = ConfigReader.getProperty("registration.password");

        if (fieldName.equalsIgnoreCase("Password")) {
            loginPage.enterPassword(password);
        } else {
            throw new IllegalArgumentException(
                    "Unsupported login password field: " + fieldName
            );
        }
    }
}