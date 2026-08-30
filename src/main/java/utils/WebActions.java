package utils;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WebActions {
    public static WebDriver driver = DriverFactory.getDriver();

    // this will enters the given value into the element identified by the locator.
    public static void enterText(By locator, String value) {
        driver = DriverFactory.getDriver();
        // this will find the required element using the supplied locator
        WebElement element = driver.findElement(locator);

        // Clear any existing value from the field.
        element.clear();

        // Enter the required value.
        element.sendKeys(value);
    }
    // this will clicks the element identified by the locator.
    public static void click(By locator) {

        // Get the currently active WebDriver from DriverFactory.
        driver = DriverFactory.getDriver();

        // Find the required element and click it.
        WebElement element = driver.findElement(locator);
        element.click();
    }
}