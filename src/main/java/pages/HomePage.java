package pages;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private final WebDriver driver = DriverFactory.getDriver();

    private final By myAccountMenu = By.linkText("My Account");
    public void clickMyAccount() {
        driver.findElement(myAccountMenu).click();
    }

    private final By registerLink = By.linkText("Register");
    public void clickRegister() {
        driver.findElement(registerLink).click();
    }

    private final By loginLink = By.linkText("Login");
    public void clickLogin() {
            driver.findElement(loginLink).click();
        }
    }
