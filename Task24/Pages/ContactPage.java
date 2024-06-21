package DemoblazePages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactPage
{
    WebDriver driver;

    // Constructor to initialize WebDriver
    public ContactPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Web elements using @FindBy
    @FindBy(id = "recipient-email")
    WebElement recipientEmailInput;

    @FindBy(id = "recipient-name")
    WebElement recipientNameInput;

    @FindBy(id = "message-text")
    WebElement messageTextInput;

    @FindBy(xpath = "//button[contains(text(),'Send message')]")
    WebElement sendMessageButton;

    // Methods to interact with web elements
    public void enterRecipientEmail(String email) {
        recipientEmailInput.sendKeys(email);
    }

    public void enterRecipientName(String name) {
        recipientNameInput.sendKeys(name);
    }

    public void enterMessageText(String message) {
        messageTextInput.sendKeys(message);
    }

    public void clickSendMessageButton() {
        sendMessageButton.click();
    }
}
