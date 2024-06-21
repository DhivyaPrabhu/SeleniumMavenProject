package DemoblazePages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AboutUsPage
{
    WebDriver driver;

    // Constructor to initialize WebDriver
    public AboutUsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Web elements using @FindBy
    @FindBy(xpath = "//h2[contains(text(),'About us')]")
    WebElement aboutUsHeader;

    // Method to get text of about us header
    public String getAboutUsHeaderText() {
        return aboutUsHeader.getText();
    }
}
