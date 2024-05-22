package Task15;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxDriverService;
import org.openqa.selenium.firefox.FirefoxOptions;

public class FirefoxBrowserExample
{
    public static void main(String args[])
    {
        // Setting up Firefox options
        FirefoxOptions options = new FirefoxOptions();
        options.addPreference("dom.web driver.enabled", false);
        // Initialize the Firefox browser
        WebDriver driver = new FirefoxDriver(options);
        // Maximize the browser window
        driver.manage().window().maximize();

        // Navigate to Google
        driver.get("http://google.com");

        // Print the URL of the current page
        System.out.println("Current URL: " + driver.getCurrentUrl());

        // Reload the page
        driver.navigate().refresh();

        // Close the browser
        driver.quit();
    }
}
