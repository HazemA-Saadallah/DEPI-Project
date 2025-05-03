package Pages;

import Utilities.JsonReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.Map;

public class RegisterPage {
    WebDriver driver;
    WebDriverWait wait;
    Map<String, String> messages = JsonReader.read_data_file("src/test/resources/register_messages.json");

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(5));
    }

    // Locators
    private final By first_name_textbox = By.id("customer.firstName");
    private final By last_name_textbox = By.id("customer.lastName");
    private final By address_textbox = By.id("customer.address.street");
    private final By city_textbox = By.id("customer.address.city");
    private final By state_textbox = By.id("customer.address.state");
    private final By zip_code_textbox = By.id("customer.address.zipCode");
    private final By phone_number_textbox = By.id("customer.phoneNumber");
    private final By ssn_textbox = By.id("customer.ssn");
    private final By username_textbox = By.id("customer.username");
    private final By password_textbox = By.id("customer.password");
    private final By password_confirm_textbox = By.id("repeatedPassword");
    private final By register_button = By.xpath("//input[@value=\"Register\"]");
    private final By successful_register_message = By.id("rightPanel");

    private final By first_name_error_message = By.id("customer.firstName.errors");
    private final By last_name_error_message = By.id("customer.lastName.errors");
    private final By address_error_message = By.id("customer.address.street.errors");
    private final By city_error_message = By.id("customer.address.city.errors");
    private final By state_error_message = By.id("customer.address.state.errors");
    private final By zip_code_error_message = By.id("customer.address.zipCode.errors");
    private final By phone_number_error_message = By.id("customer.phoneNumber.errors");
    private final By ssn_error_message = By.id("customer.ssn.errors");
    private final By username_error_message = By.id("customer.username.errors");
    private final By password_error_message = By.id("customer.password.errors");
    private final By password_confirm_error_message = By.id("repeatedPassword.errors");

    // Actions
    public void enter_first_name(String first_name) { this.driver.findElement(first_name_textbox).sendKeys(first_name); }
    public void enter_last_name(String last_name) { this.driver.findElement(last_name_textbox).sendKeys(last_name); }
    public void enter_address(String address) { this.driver.findElement(address_textbox).sendKeys(address); }
    public void enter_city(String city) { this.driver.findElement(city_textbox).sendKeys(city); }
    public void enter_state(String state) { this.driver.findElement(state_textbox).sendKeys(state); }
    public void enter_zip_code(String zip_code) { this.driver.findElement(zip_code_textbox).sendKeys(zip_code); }
    public void enter_phone_number(String phone_number) { this.driver.findElement(phone_number_textbox).sendKeys(phone_number); }
    public void enter_ssn(String ssn) { this.driver.findElement(ssn_textbox).sendKeys(ssn); }
    public void enter_username(String username) { this.driver.findElement(username_textbox).sendKeys(username); }
    public void enter_password(String password) { this.driver.findElement(password_textbox).sendKeys(password); }
    public void enter_password_confirm(String password_confirm) { this.driver.findElement(password_confirm_textbox).sendKeys(password_confirm); }
    public void click_register_button() { this.driver.findElement(register_button).click(); }


    public void navigate() { this.driver.get("https://parabank.parasoft.com/parabank/register.htm"); }

    public void register(String first_name, String last_name, String address, String city, String state,
                         String zip_code, String phone_number, String ssn, String username, String password, String password_confirm) {
        this.enter_first_name(first_name);
        this.enter_last_name(last_name);
        this.enter_address(address);
        this.enter_city(city);
        this.enter_state(state);
        this.enter_zip_code(zip_code);
        this.enter_phone_number(phone_number);
        this.enter_ssn(ssn);
        this.enter_username(username);
        this.enter_password(password);
        this.enter_password_confirm(password_confirm);
        this.click_register_button();
    }

    // Assertions
    public void validate_successful_register_message(String username) { Assert.assertEquals(this.driver.findElement(successful_register_message).getText(), "Welcome "+username+"\nYour account was created successfully. You are now logged in."); }
    public void validate_failed_register() { Assert.assertFalse(this.driver.findElement(successful_register_message).getText().contains("Welcome")); }

    public void validate_first_name_error_message(String message_key) {Assert.assertEquals(this.driver.findElement(this.first_name_error_message).getText(), this.messages.get(message_key)); }
    public void validate_last_name_error_message(String message_key) { Assert.assertEquals(this.driver.findElement(this.last_name_error_message).getText(), this.messages.get(message_key)); }
    public void validate_address_error_message(String message_key) { Assert.assertEquals(this.driver.findElement(this.address_error_message).getText(), this.messages.get(message_key)); }
    public void validate_city_error_message(String message_key) { Assert.assertEquals(this.driver.findElement(this.city_error_message).getText(), this.messages.get(message_key)); }
    public void validate_state_error_message(String message_key) { Assert.assertEquals(this.driver.findElement(this.state_error_message).getText(), this.messages.get(message_key)); }
    public void validate_zip_code_error_message(String message_key) { Assert.assertEquals(this.driver.findElement(this.zip_code_error_message).getText(), this.messages.get(message_key)); }
    public void validate_phone_number_error_message(String message_key) { Assert.assertEquals(this.driver.findElement(this.phone_number_error_message).getText(), this.messages.get(message_key)); }
    public void validate_ssn_error_message(String message_key) { Assert.assertEquals(this.driver.findElement(this.ssn_error_message).getText(), this.messages.get(message_key)); }
    public void validate_username_error_message(String message_key) { Assert.assertEquals(this.driver.findElement(this.username_error_message).getText(), this.messages.get(message_key)); }
    public void validate_password_error_message(String message_key) { Assert.assertEquals(this.driver.findElement(this.password_error_message).getText(), this.messages.get(message_key)); }
    public void validate_password_confirm_error_message(String message_key) { Assert.assertEquals(this.driver.findElement(this.password_confirm_error_message).getText(), this.messages.get(message_key)); }
}