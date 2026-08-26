package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import utils.ConfigReader;

public class DriverFactory {

    // Stores the WebDriver instance.
    // The driver is private so other classes cannot directly modify it.
    // Static allows the DriverFactory to maintain a shared driver reference.
    private static WebDriver driver;

    // Initializes the browser based on the browser value
    // provided in the config.properties file.
    public static WebDriver initializeDriver() {

        // Initialize the browser only if a driver does not already exist.
        if (driver == null) {

            // Read the browser name from config.properties.
            String browser = ConfigReader.getProperty("browser");

            // Initialize Chrome based on the configured browser.
            if (browser.equalsIgnoreCase("chrome")) {

                driver = new ChromeDriver();

            }
           else if (browser.equalsIgnoreCase("edge")) {

                driver = new EdgeDriver();

            }else {

                // Throw an exception if an unsupported browser is configured.
                throw new IllegalArgumentException(
                        "Unsupported browser: " + browser
                );
            }

            // Maximize the browser window.
            driver.manage().window().maximize();
        }

        // Return the initialized WebDriver instance.
        return driver;
    }

    // Returns the currently initialized WebDriver instance.
    public static WebDriver getDriver() {
        return driver;
    }

    // Closes the browser and clears the WebDriver instance.
    public static void quitDriver() {

        // Check whether a WebDriver instance exists.
        if (driver != null) {

            // Close the browser and end the WebDriver session.
            driver.quit();

            // Clear the driver reference.
            driver = null;
        }
    }
}