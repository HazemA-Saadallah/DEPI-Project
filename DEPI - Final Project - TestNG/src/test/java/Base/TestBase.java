package Base;

import Utilities.Screenshot;
import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.util.HashMap;
import java.util.Map;

import java.time.Duration;

public class TestBase {
    public WebDriver driver;

    public static Map<String, String> rand_vars() {
        Faker faker = new Faker();
        Map <String, String> vars = new HashMap<String, String>();
        vars.put("first_name", faker.name().firstName());
        vars.put("last_name", faker.name().lastName());
        vars.put("address", faker.address().country());
        vars.put("city", faker.address().city());
        vars.put("state", faker.address().state());
        vars.put("zip_code", faker.address().zipCode());
        vars.put("phone_number", faker.number().digits(12));
        vars.put("ssn", faker.idNumber().ssnValid());
        vars.put("username", faker.name().username());
        vars.put("password", faker.internet().password());
        vars.put("password_confirm", vars.get("password"));
        return vars;
    }

    @Parameters("browser")
    @BeforeClass
    public void preconditions(@Optional("chrome") String browser) {
        if (browser.equalsIgnoreCase("chrome")) driver = new ChromeDriver();
        else if (browser.equalsIgnoreCase("firefox")) driver = new FirefoxDriver();
        else if (browser.equalsIgnoreCase("edge")) driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Parameters("browser")
    @AfterMethod
    public void takeScreenShot(ITestResult test_result, @Optional("None") String browser_name) {
        if (ITestResult.FAILURE == test_result.getStatus()) Screenshot.take_screenshot(this.driver, test_result.getName(), browser_name);
        this.driver.manage().deleteAllCookies();
    }

    @AfterClass
    public void tearDown() { driver.quit(); }
}