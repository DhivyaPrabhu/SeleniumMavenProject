package DemoblazePages;
import DemoblazeTest.BaseTest;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class LoginPage extends BaseTest
{
    WebDriver driver;
    public String ActualText;

    // Constructor to initialize WebDriver
    public LoginPage(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    // Web elements using @FindBy annotation
    @FindBy(id="loginusername")
    WebElement UserNameInput;
    @FindBy(id="loginpassword")
    WebElement PasswordInput;
    @FindBy(xpath="//button[normalize-space()='Log in']")
    WebElement LoginButton;
    @FindBy(xpath = "//div[@id='logInModal']//button[@type='button'][normalize-space()='Close']")
    WebElement CloseButton;
    @FindBy(id="logout2")
    WebElement LogoutText;


    // Methods to interact with web elements
    public void EnterUserName(String username)
    {
        UserNameInput.sendKeys(username);
    }
    public void EnterPassword(String password)
    {
        PasswordInput.sendKeys(password);
    }
    public void ClickLoginButton()
    {
        LoginButton.click();
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
        wait.until(ExpectedConditions.textToBe(By.id("logout2"),"Log out"));
    }

    public void verifyLogin(String expectedText)
    {
        ActualText=LogoutText.getText();
        Assert.assertTrue(ActualText.contains(expectedText), "Login not successful.");
    }
}
