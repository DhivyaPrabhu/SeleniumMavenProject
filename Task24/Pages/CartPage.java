package DemoblazePages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CartPage
{
    WebDriver driver;

    // Web elements using @FindBy annotation
    @FindBy(xpath = "//table[@class='table']/tbody/tr")
    List<WebElement> cartItems;

    @FindBy(xpath = "//button[contains(text(), 'Place Order')]")
    WebElement placeOrderButton;

    // Constructor to initialize WebDriver and PageFactory
    public CartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Method to get all cart items
    public List<WebElement> getCartItems() {
        return cartItems;
    }

    // Method to click on Place Order button
    public void clickPlaceOrderButton() {
        placeOrderButton.click();
    }

    // Method to remove an item from cart
    public void removeItemFromCart(String itemName) {
        WebElement removeButton = driver.findElement(By.xpath("//td[text()='" + itemName + "']/following-sibling::td/button[text()='Delete']"));
        removeButton.click();
    }

    // Method to update quantity of an item in cart
    public void updateItemQuantity(String itemName, String newQuantity) {
        WebElement quantityInput = driver.findElement(By.xpath("//td[text()='" + itemName + "']/following-sibling::td/input[@type='number']"));
        quantityInput.clear();
        quantityInput.sendKeys(newQuantity);
        quantityInput.submit(); // Assuming updating triggers a submit action
    }

    // Method to check if cart is empty
    public boolean isCartEmpty() {
        return cartItems.isEmpty();
    }

    // Method to calculate total price in cart
    public double getTotalPrice() {
        double totalPrice = 0.0;
        for (WebElement item : cartItems) {
            String priceText = item.findElement(By.xpath(".//td[3]")).getText().replace("$", "").trim();
            double price = Double.parseDouble(priceText);
            totalPrice += price;
        }
        return totalPrice;
    }

    // Method to verify if an item is present in cart
    public boolean isItemInCart(String itemName) {
        for (WebElement item : cartItems) {
            String name = item.findElement(By.xpath(".//td[2]")).getText();
            if (name.equals(itemName)) {
                return true;
            }
        }
        return false;
    }

    // Method to handle alert messages that might appear after actions
    public String handleAlert() {
        Alert alert = driver.switchTo().alert();
        String alertMessage = alert.getText();
        alert.accept();
        return alertMessage;
    }


}
