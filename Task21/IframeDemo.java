package Task21;

import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class IframeDemo
{
    public static void main(String[] args)throws InterruptedException
    {
        //launch WebDriver
        WebDriver driver=new ChromeDriver();

        //Maximize the Window
        driver.manage().window().maximize();

        //Navigate webpage
        driver.navigate().to("https://the-internet.herokuapp.com/iframe");

        //Adding implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //Close the notification
        WebElement closeButton= driver.findElement(By.xpath("//button[contains(@class,'tox-notification')]"));
        closeButton.click();

        //Switch to iFrame
        WebElement iframe= driver.findElement(By.xpath("//iframe[@title='Rich Text Area']"));
        driver.switchTo().frame(iframe);

        // Locate the "p" tag inside the iframe and write the text "Hello People"
        WebElement ptag = driver.findElement(By.xpath("/html/body/p"));

        //send hello people inside the tag
        JavascriptExecutor jse=(JavascriptExecutor) driver;
        jse.executeScript("arguments[0].innerText= 'Hello People';",ptag);

        //To show the Modified Ptag used Thread.sleep wait method
        Thread.sleep(3000);

        //verify the Result
        String result=ptag.getText();
        System.out.println("The Sent Text is : " +result);

        //quite the driver
        driver.quit();


    }
}
