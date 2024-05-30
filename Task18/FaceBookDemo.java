package Task18;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FaceBookDemo

{
public static void main(String[] args) throws InterruptedException
    {   //Initialize webdriver
        WebDriver driver= new FirefoxDriver();
        //Navigate to facebook page
        driver.get("http://www.facebook.com/");
        //Maximize the window
        driver.manage().window().maximize();
        if(driver.getTitle().contains("Facebook"))
        {
            System.out.println("Successfully redirected to Facebook homepage.");
        }
        else
        {
            System.out.println("Failed to redirect to Facebook homepage.");
        }
        //// Click on "Create new account" button
        WebElement createAccountButton= driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']"));
        createAccountButton.click();
        Thread.sleep(3000);

        // Fill in sign-up form
        WebElement firstNameInput = driver.findElement(By.xpath("//input[@aria-label='First name']"));
        firstNameInput.sendKeys("Test");


        WebElement lastNameInput = driver.findElement(By.xpath("//input[@aria-label='Surname']"));
        lastNameInput.sendKeys("User");
        //Wait
        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.titleContains("Facebook"));

       WebElement emailInput = driver.findElement(By.xpath("//input[@aria-label='Mobile number or email address']"));
       emailInput.sendKeys("yalmozhi5319@gmail.com");

       WebElement reEnteremail=driver.findElement(By.xpath("//input[@aria-label='Re-enter email address']"));
       reEnteremail.sendKeys("yalmozhi5319@gmail.com");


       WebElement passwordInput = driver.findElement(By.xpath("//input[@id='password_step_input']"));
       passwordInput.sendKeys("StrongPassword123");

        // Select date of birth
        Select daySelect = new Select(driver.findElement(By.name("birthday_day")));
        daySelect.selectByVisibleText("10");

        Select monthSelect = new Select(driver.findElement(By.name("birthday_month")));
        monthSelect.selectByVisibleText("Mar");

        Select yearSelect = new Select(driver.findElement(By.name("birthday_year")));
        yearSelect.selectByVisibleText("1991");

       // Select gender
        WebElement genderRadio = driver.findElement(By.xpath("//input[@value='1']")); // Change value to '1' for Female
        genderRadio.click();

        // Click on "Sign Up" button
        WebElement signUpButton = driver.findElement(By.xpath("//button[@name='websubmit']"));
        signUpButton.click();

       // Verify successful registration
        if (driver.getTitle().contains("Facebook")) {
            System.out.println("Successfully registered on Facebook.");
        } else {
            System.out.println("Failed to register on Facebook.");
        }

        // Close the browser
        driver.quit();


    }
}
