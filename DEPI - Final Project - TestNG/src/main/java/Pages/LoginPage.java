package Pages;

import Utilities.JsonReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.Map;

public class LoginPage {
    WebDriver driver;
    WebDriverWait wait;
    Map<String, String> messages = JsonReader.read_data_file("src/test/resources/login_messages.json");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(5));
    }

    // Locators
    private final By username_textbox = By.xpath("//input[@name=\"username\"]");
    private final By password_textbox = By.xpath("//input[@name=\"password\"]");
    private final By login_button = By.xpath("//input[@value=\"Log In\"]");
    private final By error_box = By.id("rightPanel");

    // Actions
    public void navigate() { this.driver.get("https://parabank.parasoft.com/parabank/index.htm"); }
    public void enter_username(String username) { this.driver.findElement(username_textbox).sendKeys(username); }
    public void enter_password(String password) { this.driver.findElement(password_textbox).sendKeys(password); }
    public void click_login_button() { this.driver.findElement(login_button).click(); }
    public void  login(String username, String password) {
        this.enter_username(username);
        this.enter_password(password);
        this.click_login_button();
    }

    // Assertions
    public void validate_error_message(String message_key) { Assert.assertEquals(this.driver.findElement(this.error_box).getText(), "Error!\n"+this.messages.get(message_key)); }
    public void validate_successful_logout() {
        Assert.assertTrue(this.driver.findElement(this.username_textbox).isDisplayed());
        Assert.assertTrue(this.driver.findElement(this.password_textbox).isDisplayed());
        Assert.assertTrue(this.driver.findElement(this.login_button).isDisplayed());
    }
}