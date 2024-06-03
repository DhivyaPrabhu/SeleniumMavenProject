package Task21;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class IframeDemo
{
    public static void main(String[] args)
    {
        //launch WebDriver
        WebDriver driver=new ChromeDriver();

        //Maximize the Window
        driver.manage().window().maximize();

        //Navigate webpage
        driver.navigate().to("https://the-internet.herokuapp.com/iframe");

        //Close the notification
        WebElement closeButton= driver.findElement(By.xpath("//button[contains(@class,'tox-notification')]"));
        closeButton.click();

        //Switch to iFrame
        WebElement iframe= driver.findElement(By.xpath("//iframe[@title='Rich Text Area']"));
        driver.switchTo().frame(iframe);

        // Locate the "p" tag inside the iframe and write the text "Hello People"
        WebElement ptag = driver.findElement(By.xpath("/html/body/p"));

        // Clear existing text (if any) and send the required text
        //ptag.clear();
        //ptag.sendKeys("Hello People");//(The page is not working hence I used coding in command line )

        //quite the driver
        driver.quit();


    }
}
