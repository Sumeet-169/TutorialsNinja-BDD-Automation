package pages;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    // Get the active WebDriver instance from DriverFactory.
    private final WebDriver driver = DriverFactory.getDriver();

    // My Account menu.
    private final By myAccountMenu = By.linkText("My Account");

    // Register option under My Account.
    private final By registerLink = By.linkText("Register");


    // Clicks the My Account menu.
    public void clickMyAccount() {

        // Click My Account on the TutorialsNinja home page.
        driver.findElement(myAccountMenu).click();
    }


    // Clicks the Register option.
    public void clickRegister() {

        // Click Register from the My Account menu.
        driver.findElement(registerLink).click();
    }
}