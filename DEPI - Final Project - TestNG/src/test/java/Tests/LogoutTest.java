package Tests;

import Base.TestBase;
import Pages.AccountOverview;
import Pages.LoginPage;
import Pages.RegisterPage;
import jdk.jfr.Description;
import org.testng.annotations.Test;

import java.util.Map;

public class LogoutTest extends TestBase {
    RegisterPage register_page;
    LoginPage login_page;
    AccountOverview account_overview_page;
    private Map<String, String> vars;

    @Test
    @Description("""
            Test Scenario ID: SC_logout_01
            Test Case ID: TC_Logout_01
            Title: Validate That a user can logout When the user is logged-in""")
    public void TC_Logout_01() {
        this.vars = TestBase.rand_vars();
        this.register_page = new RegisterPage(this.driver);
        this.login_page = new LoginPage(this.driver);
        this.account_overview_page = new AccountOverview(this.driver);
        this.register_page.navigate();
        this.register_page.register(this.vars);
        this.account_overview_page.log_out();
        this.login_page.validate_successful_logout();
    }
}