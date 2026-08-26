package utils;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WebActions {

    // Enters the given value into the element identified by the locator.
    public static void enterText(By locator, String value) {

        // Get the currently active WebDriver from DriverFactory.
        WebDriver driver = DriverFactory.getDriver();

        // Find the required element using the supplied locator.
        WebElement element = driver.findElement(locator);

        // Clear any existing value from the field.
        element.clear();

        // Enter the required value.
        element.sendKeys(value);
    }
}