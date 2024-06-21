package DemoblazePages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage
{
    WebDriver driver;

    // Constructor to initialize WebDriver
    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Web elements using @FindBy
    @FindBy(linkText = "Contact")
    WebElement contactLink;

    @FindBy(linkText = "About us")
    WebElement aboutUsLink;

    @FindBy(id="login2")
    WebElement loginLink;

    @FindBy(id="signin2")
    WebElement signupLink;

    // Methods to interact with Home Page web elements
    public void clickContactLink() {
        contactLink.click();
    }

    public void clickAboutUsLink() {
        aboutUsLink.click();
    }
    public void clickLoginLink() {
        loginLink.click();
    }
    public void clickSignupLink() {
        signupLink.click();
    }

}
