package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class AccountOverview {
    WebDriver driver;
    WebDriverWait wait;

    public AccountOverview(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(5));
    }

    // Locators
    private final By name_welcome = By.xpath("//p[@class=\"smallText\"]");
    private final By log_out_button = By.xpath("//a[text()=\"Log Out\"]");

    // Actions
    public void navigate() { this.driver.get("https://parabank.parasoft.com/parabank/overview.htm"); }
    public void log_out() {this.driver.findElement(log_out_button).click(); }

    // Assertions
    public void verify_welcome_message(String first_name, String last_name) {
        Assert.assertEquals(this.driver.findElements(name_welcome).getFirst().getText(), "Welcome "+first_name+" "+last_name);
    }

}