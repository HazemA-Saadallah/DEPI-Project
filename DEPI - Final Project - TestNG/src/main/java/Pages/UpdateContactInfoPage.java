package Pages;

import Utilities.JsonReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;
import java.util.Map;

public class UpdateContactInfoPage {
    WebDriver driver;
    WebDriverWait wait;
    Map<String, String> messages = JsonReader.read_data_file("src/test/resources/update_contact_info_messages.json");

    public UpdateContactInfoPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(5));
    }
    // support functions
    private String make_update_message(List<String> update_items) {
        assert !update_items.isEmpty();
        String value;

        if (update_items.size() == 1) value = update_items.get(0);
        else if (update_items.size() == 2) value = update_items.get(0) + " and " + update_items.get(1);
        else {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < update_items.size() - 1; i++) sb.append(update_items.get(i)).append(", ");
            sb.append("and ").append(update_items.get(update_items.size() - 1));
            value = sb.toString();
        }
        return "Profile Updated\nYour updated " + value.toLowerCase() + " have been added to the system.";
    }

    // Locators
    private final By first_name_textbox = By.id("customer.firstName");
    private final By last_name_textbox = By.id("customer.lastName");
    private final By address_textbox = By.id("customer.address.street");
    private final By city_textbox = By.id("customer.address.city");
    private final By state_textbox = By.id("customer.address.state");
    private final By zip_code_textbox = By.id("customer.address.zipCode");
    private final By phone_number_textbox = By.id("customer.phoneNumber");
    private final By update_profile_button = By.xpath("//input[@value=\"Update Profile\"]");

    private final By first_name_error = By.id("firstName-error");
    private final By last_name_error = By.id("lastName-error");
    private final By address_error = By.id("street-error");
    private final By city_error = By.id("city-error");
    private final By state_error = By.id("state-error");
    private final By zip_code_error = By.id("zipCode-error");
    private final By phone_number_error = By.id("phoneNumber-error");

    private final By update_profile_message = By.id("updateProfileResult");

    // Actions
    public void navigate() { this.driver.get("https://parabank.parasoft.com/parabank/updateprofile.htm"); }
    public void enter_first_name(String first_name) {
        this.driver.findElement(first_name_textbox).clear();
        this.driver.findElement(first_name_textbox).sendKeys(first_name);
    }

    public void enter_last_name(String last_name) {
        this.driver.findElement(last_name_textbox).clear();
        this.driver.findElement(last_name_textbox).sendKeys(last_name);
    }

    public void enter_address(String address) {
        this.driver.findElement(address_textbox).clear();
        this.driver.findElement(address_textbox).sendKeys(address);
    }

    public void enter_city(String city) {
        this.driver.findElement(city_textbox).clear();
        this.driver.findElement(city_textbox).sendKeys(city);
    }

    public void enter_state(String state) {
        this.driver.findElement(state_textbox).clear();
        this.driver.findElement(state_textbox).sendKeys(state);
    }

    public void enter_zip_code(String zip_code) {
        this.driver.findElement(zip_code_textbox).clear();
        this.driver.findElement(zip_code_textbox).sendKeys(zip_code);
    }

    public void enter_phone_number(String phone_number) {
        this.driver.findElement(phone_number_textbox).clear();
        this.driver.findElement(phone_number_textbox).sendKeys(phone_number);
    }

    public void click_update_profile_button() { this.driver.findElement(update_profile_button).click();}
    public void update_contact_info (String first_name, String last_name, String address,
                                     String city, String state, String zip_code, String phone_number) {
        this.enter_first_name(first_name);
        this.enter_last_name(last_name);
        this.enter_address(address);
        this.enter_city(city);
        this.enter_state(state);
        this.enter_zip_code(zip_code);
        this.enter_phone_number(phone_number);
        this.click_update_profile_button();
    }

    public void validate_first_name_value(String value) {
        wait.until(check_element -> !this.driver.findElement(first_name_textbox).getAttribute("value").isEmpty());
        Assert.assertEquals(this.driver.findElement(first_name_textbox).getAttribute("value"), value);
    }

    public void validate_last_name_value(String value) {
        wait.until(check_element -> !this.driver.findElement(last_name_textbox).getAttribute("value").isEmpty());
        Assert.assertEquals(this.driver.findElement(last_name_textbox).getAttribute("value"), value);
    }

    public void validate_address_value(String value) {
        wait.until(check_element -> !this.driver.findElement(address_textbox).getAttribute("value").isEmpty());
        Assert.assertEquals(this.driver.findElement(address_textbox).getAttribute("value"), value);
    }

    public void validate_city_value(String value) {
        wait.until(check_element -> !this.driver.findElement(city_textbox).getAttribute("value").isEmpty());
        Assert.assertEquals(this.driver.findElement(city_textbox).getAttribute("value"), value);
    }

    public void validate_state_value(String value) {
        wait.until(check_element -> !this.driver.findElement(state_textbox).getAttribute("value").isEmpty());
        Assert.assertEquals(this.driver.findElement(state_textbox).getAttribute("value"), value);
    }

    public void validate_zip_code_value(String value) {
        wait.until(check_element -> !this.driver.findElement(zip_code_textbox).getAttribute("value").isEmpty());
        Assert.assertEquals(this.driver.findElement(zip_code_textbox).getAttribute("value"), value);
    }

    public void validate_phone_number_value(String value) {
        wait.until(check_element -> !this.driver.findElement(phone_number_textbox).getAttribute("value").isEmpty());
        Assert.assertEquals(this.driver.findElement(phone_number_textbox).getAttribute("value"), value);
    }
    public void validate_info(String first_name, String last_name, String address,
                              String city, String state, String zip_code, String phone_number) {
        this.validate_first_name_value(first_name);
        this.validate_last_name_value(last_name);
        this.validate_address_value(address);
        this.validate_city_value(city);
        this.validate_state_value(state);
        this.validate_zip_code_value(zip_code);
        this.validate_phone_number_value(phone_number);
    }

    public void update_first_name(String first_name) {
        wait.until(check_element -> !this.driver.findElement(first_name_textbox).getAttribute("value").isEmpty());
        this.enter_first_name(first_name);
        this.click_update_profile_button();
    }

    public void update_last_name(String last_name) {
        wait.until(check_element -> !this.driver.findElement(last_name_textbox).getAttribute("value").isEmpty());
        this.enter_first_name(last_name);
        this.click_update_profile_button();
    }

    public void update_address(String address) {
        wait.until(check_element -> !this.driver.findElement(address_textbox).getAttribute("value").isEmpty());
        this.enter_first_name(address);
        this.click_update_profile_button();
    }

    public void update_city(String city) {
        wait.until(check_element -> !this.driver.findElement(city_textbox).getAttribute("value").isEmpty());
        this.enter_first_name(city);
        this.click_update_profile_button();
    }

    public void update_state(String state) {
        wait.until(check_element -> !this.driver.findElement(state_textbox).getAttribute("value").isEmpty());
        this.enter_first_name(state);
        this.click_update_profile_button();
    }

    public void update_zip_code(String zip_code) {
        wait.until(check_element -> !this.driver.findElement(zip_code_textbox).getAttribute("value").isEmpty());
        this.enter_first_name(zip_code);
        this.click_update_profile_button();
    }

    public void update_phone_number(String phone_number) {
        wait.until(check_element -> !this.driver.findElement(phone_number_textbox).getAttribute("value").isEmpty());
        this.enter_first_name(phone_number);
        this.click_update_profile_button();
    }

    // Assertions
    public void validate_profile_update_message(List<String> update_items) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(update_profile_message));
        Assert.assertEquals(this.driver.findElement(update_profile_message).getText(), this.make_update_message(update_items));
    }
}