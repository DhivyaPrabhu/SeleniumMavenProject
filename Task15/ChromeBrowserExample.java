package Task15;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeBrowserExample
{
    public static void main(String[] args)
    {
        // Initialize the Firefox browser
        WebDriver driver=new ChromeDriver();
       // Navigate to the demo website
        driver.get("http://www.demoblaze.com");
        //Maximize the Browser Window
        driver.manage().window().maximize();
        // Verify if the title of the page is "STORE"
        if (driver.getTitle().equals("STORE"))
        {
            System.out.println("Page landed on correct website");
        }
        else
        {
            System.out.println("Page not landed on correct website");
        }

        // Close the browser
        driver.quit();
    }
}
