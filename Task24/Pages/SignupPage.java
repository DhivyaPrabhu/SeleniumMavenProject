package DemoblazePages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class SignupPage
{
    WebDriver driver;
    String Alertmessage;
    Alert myalert;

    //Constructor to initialize WebDriver
    public SignupPage(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    //Web elements using @FindBy annotation
    @FindBy(id="sign-username")
    WebElement UserNameInput;
    @FindBy(id="sign-password")
    WebElement PasswordInput;
    @FindBy(xpath = "//button[normalize-space()='Sign up']")
    WebElement SignUpButton;
    @FindBy(xpath="//div[@id='signInModal']//button[text()='Close']")
    WebElement CloseButton;

    // Methods to interact with web elements
    public void EnterUserName(String username)
    {
        UserNameInput.sendKeys(username);
    }
    public void EnterPassword(String password)
    {
        PasswordInput.sendKeys(password);
    }
    public void ClickSignUpButton()
    {
        SignUpButton.click();
        WebDriverWait mywait=new WebDriverWait(driver,Duration.ofSeconds(10));

        // Handle alert
            mywait.until(ExpectedConditions.alertIsPresent());
            myalert=driver.switchTo().alert();
            Alertmessage=myalert.getText();
            myalert.accept();// Accept the alert (close it)

    }
    public void verifySignUp(String expectedMessage)
    {
       //Assert.assertEquals(Alertmessage,expectedMessage);//True
        Assert.assertTrue(Alertmessage.contains(expectedMessage), "Signup not successful.");
    }

}
