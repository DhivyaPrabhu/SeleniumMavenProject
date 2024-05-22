package Task15;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class OpeningWikipediaUsingChromeBrowser
{
    public static void main(String[] args) {
        // Initialize the Firefox browser
        WebDriver driver = new ChromeDriver();
        // Navigate to the demo website
        driver.get("http://www.wikipedia.org/");
        //Maximize the Browser Window
        driver.manage().window().maximize();
        // Find the search input field and enter the query
        WebElement searchInput = driver.findElement(By.id("searchInput"));
        searchInput.sendKeys("Artificial Intelligence");
        searchInput.submit();
        // Click on the "History" section in the search results
        WebElement historylink = driver.findElement(By.linkText("History"));
        historylink.click();
        // Print the title of the section
        WebElement sectionTitle = driver.findElement(By.id("firstHeading"));
        System.out.println("Title of the section: " + sectionTitle.getText());
        // Close the browser
        driver.quit();
    }
}
