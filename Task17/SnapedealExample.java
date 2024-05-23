package Task17;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.time.Duration;

public class SnapedealExample
{
    public static void main(String args[])
    {
        //Initialise Webdriver
        WebDriver driver=new FirefoxDriver();
        //Maximize the window
        driver.manage().window().maximize();
        // Navigate to snapdeal website
        driver.get("https://www.snapdeal.com");
        //Locate the cursor to sigin button and hold
       WebElement signInButton= driver.findElement(By.className("accountUserName"));
        Actions actions = new Actions(driver);
        actions.moveToElement(signInButton).perform();

        // Navigate to Snapdeal login page
        driver.get("https://www.snapdeal.com/login");

        // Locate email field and enter email
        WebElement emailField = driver.findElement(By.id("userName"));
        emailField.sendKeys("ammu3391@gmail.com");

        // Locate password field and enter password
        WebElement passwordField = driver.findElement(By.id("j_password_login_uc"));
        passwordField.sendKeys("XXXXXXXXX");

        // Click on the login button
        WebElement login = driver.findElement(By.xpath("//button[contains(text(),'Login')]"));
        login.click();

        // Verify login success and print message to console
        WebElement welcomeMessage = driver.findElement(By.xpath("//span[@class='userAccount col-xs-12 reset-padding']"));
        if (welcomeMessage.getText().contains("Hi,")) {
            System.out.println("Login successful!");
        } else {
            System.out.println("Login failed!");
        }

        // Close the browser
        driver.quit();

    }
}
//Note:
/* After entering the email id , we have to provide OTP
hence we unable to perform this Task. As per mentor instruction we done our task up to this.
 */