package Tests;

import Base.TestBase;
import Pages.AccountOverview;
import Pages.LoginPage;
import Pages.RegisterPage;
import com.github.javafaker.Faker;
import jdk.jfr.Description;
import org.testng.annotations.Test;
import java.util.Map;

public class LoginTest extends TestBase {
    LoginPage login_page;
    RegisterPage register_page;
    AccountOverview account_overview_page;
    Faker faker = new Faker();
    private Map<String, String> vars;

    @Test
    @Description("""
            Test Scenario ID: SC_Successful_login_01
            Test Case ID: TC_Login_01
            Title: Validate That a user login is successful When a user is using a valid username and password to login""")
    public void TC_Login_01() {
        this.vars = TestBase.rand_vars();
        this.login_page = new LoginPage(this.driver);
        this.register_page = new RegisterPage(this.driver);
        this.account_overview_page = new AccountOverview(this.driver);
        this.register_page.navigate();
        this.register_page.register(this.vars);
        this.driver.manage().deleteAllCookies();
        this.login_page.navigate();
        this.login_page.login(vars.get("username"), vars.get("password"));
        this.account_overview_page.verify_welcome_message(vars.get("first_name"), vars.get("last_name"));
    }

    @Test
    @Description("""
            Test Scenario ID: SC_Blank_Username_Login_01
            Test Case ID: TC_Login_02
            Title: Validate That a user cannot login When username filed is blank regardless of the password""")
    public void TC_Login_02() {
        this.login_page = new LoginPage(this.driver);
        this.account_overview_page = new AccountOverview(this.driver);
        this.login_page.navigate();
        this.login_page.login("", vars.get("password"));
        this.login_page.validate_error_message("missing_credentials_error");
    }

    @Test
    @Description("""
            Test Scenario ID: SC_Wrong_Username_Login_01
            Test Case ID: TC_Login_03
            Title: Validate That a user cannot login When the provided username is not registered""")
    public void TC_Login_03() {
        this.login_page = new LoginPage(this.driver);
        this.login_page.navigate();
        this.login_page.login(faker.number().digits(9), this.vars.get("password"));
        this.login_page.validate_error_message("wrong_credentials_error");
    }

    @Test
    @Description("""
            Test Scenario ID: SC_Blank_Password_Login_01
            Test Case ID: TC_Login_04
            Title: Validate That a user cannot login When password filed is blank""")
    public void TC_Login_04() {
        this.login_page = new LoginPage(this.driver);
        this.login_page.navigate();
        this.login_page.login(this.vars.get("username"), "");
        this.login_page.validate_error_message("missing_credentials_error");
    }

    @Test
    @Description("""
            Test Scenario ID: SC_Wrong_Password_Login_01
            Test Case ID: TC_Login_05
            Title: Validate That a user cannot login When the provided password is wrong""")
    public void TC_Login_05() {
        this.login_page = new LoginPage(this.driver);
        this.login_page.navigate();
        this.login_page.login(this.vars.get("username"), faker.number().digits(9));
        this.login_page.validate_error_message("missing_credentials_error");
    }

    @Test
    @Description("""
            Test Scenario ID: SC_Wrong_Credential_Login_01
            Test Case ID: TC_Login_06
            Title: Validate That a user cannot login When wrong credential""")
    public void TC_Login_06() {
        this.login_page = new LoginPage(this.driver);
        this.login_page.navigate();
        this.login_page.login(faker.number().digits(9), faker.number().digits(9));
        this.login_page.validate_error_message("wrong_credentials_error");
    }
}