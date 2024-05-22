package Task15;

import net.bytebuddy.asm.Advice;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class GoogleSearchSeleniumScript
{
    public static void main(String[] args)
    {
        //Launch Browser
        WebDriver driver=new ChromeDriver();
        //Open URL
        driver.get("https://www.google.com/");
        //maximize the window
        driver.manage().window().maximize();
        // Find the search box element and enter a search term
        WebElement searchBox= driver.findElement(By.name("q"));
        searchBox.sendKeys("Selenium Browser Driver");
        // Submit the search by pressing Enter
        searchBox.sendKeys(Keys.ENTER);
        //assertion -> comparing the expected result with actual result
        String results =driver.getPageSource();
        boolean result = results.contains("Selenium");
        Assert.assertEquals(result,true);
        //close the browser window
        driver.quit();
    }
}
