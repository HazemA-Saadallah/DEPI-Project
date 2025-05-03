package Tests;

import Base.TestBase;
import Pages.AccountOverview;
import Pages.RegisterPage;
import jdk.jfr.Description;
import org.testng.annotations.Test;

import java.util.Map;

public class RegisterTest extends TestBase {

    private RegisterPage register_page;
    private AccountOverview account_overview_page;
    private Map<String, String> vars;

    @Test
    @Description("""
            Test Scenario ID: SC_Successful_register_01
            Test Case ID: TC_Register_01
            Title: Validate That new user registration is successful when registering a new customer
            """)
    public void TC_Register_01() {
        this.vars = TestBase.rand_vars();
        this.register_page = new RegisterPage(this.driver);
        this.account_overview_page = new AccountOverview(this.driver);
        this.register_page.navigate();
        this.register_page.register(
                this.vars.get("first_name"),
                this.vars.get("last_name"),
                this.vars.get("address"),
                this.vars.get("city"),
                this.vars.get("state"),
                this.vars.get("zip_code"),
                this.vars.get("phone_number"),
                this.vars.get("ssn"),
                this.vars.get("username"),
                this.vars.get("password"),
                this.vars.get("password_confirm")
        );
        register_page.validate_successful_register_message(this.vars.get("username"));
        account_overview_page.verify_welcome_message(this.vars.get("first_name"), this.vars.get("last_name"));
    }

    @Test
    @Description("""
            Test Scenario ID: SC_Already_registered_username_01
            Test Case ID: TC_Register_02
            Title: Validate that a user with an already existing username cannot be registered When registering a new customer
            """)
    public void TC_Register_02() throws InterruptedException {
        this.register_page = new RegisterPage(this.driver);
        this.account_overview_page = new AccountOverview(this.driver);
        this.register_page.navigate();
        this.register_page.register(
                this.vars.get("first_name"),
                this.vars.get("last_name"),
                this.vars.get("address"),
                this.vars.get("city"),
                this.vars.get("state"),
                this.vars.get("zip_code"),
                this.vars.get("phone_number"),
                this.vars.get("ssn"),
                this.vars.get("username"),
                this.vars.get("password"),
                this.vars.get("password_confirm")
        );
        register_page.validate_failed_register();
        register_page.validate_username_error_message("used_username_error");
    }

    @Test
    @Description("""
            Test Scenario ID: SC_First_Name_01
            Test Case ID: TC_Register_03
            Title: Validate That "First Name" cannot be blank When registering a new customer
            """)
    public void TC_Register_03() {
        this.vars = TestBase.rand_vars();
        this.register_page = new RegisterPage(this.driver);
        this.account_overview_page = new AccountOverview(this.driver);
        this.register_page.navigate();
        this.register_page.register(
                "",
                this.vars.get("last_name"),
                this.vars.get("address"),
                this.vars.get("city"),
                this.vars.get("state"),
                this.vars.get("zip_code"),
                this.vars.get("phone_number"),
                this.vars.get("ssn"),
                this.vars.get("username"),
                this.vars.get("password"),
                this.vars.get("password_confirm")
        );
        register_page.validate_failed_register();
        register_page.validate_first_name_error_message("missing_first_name_error");
    }

    @Test
    @Description("""
            Test Scenario ID: SC_First_Name_02
            Test Case ID: TC_Register_04
            Title: Validate That "First Name" has to contain only alphabetic character When registering a new customer""")
    public void TC_Register_04() {
        Map<String, String> vars = TestBase.rand_vars();
        this.register_page = new RegisterPage(this.driver);
        this.account_overview_page = new AccountOverview(this.driver);
        this.register_page.navigate();
        this.register_page.register(
                this.vars.get("first_name")+"1_-.",
                this.vars.get("last_name"),
                this.vars.get("address"),
                this.vars.get("city"),
                this.vars.get("state"),
                this.vars.get("zip_code"),
                this.vars.get("phone_number"),
                this.vars.get("ssn"),
                this.vars.get("username"),
                this.vars.get("password"),
                this.vars.get("password_confirm")
        );
        register_page.validate_failed_register();
        register_page.validate_first_name_error_message("first_name_non-alphabetic_character_error");
    }

    @Test
    @Description("""
            Test Scenario ID: SC_Last_Name_01
            Test Case ID: TC_Register_05
            Title: Validate That "Last Name" cannot be blank When registering a new customer""")
    public void TC_Register_05() {
        this.vars = TestBase.rand_vars();
        this.register_page = new RegisterPage(this.driver);
        this.account_overview_page = new AccountOverview(this.driver);
        this.register_page.navigate();
        this.register_page.register(
                this.vars.get("first_name"),
                "",
                this.vars.get("address"),
                this.vars.get("city"),
                this.vars.get("state"),
                this.vars.get("zip_code"),
                this.vars.get("phone_number"),
                this.vars.get("ssn"),
                this.vars.get("username"),
                this.vars.get("password"),
                this.vars.get("password_confirm")
        );
        register_page.validate_failed_register();
        register_page.validate_last_name_error_message("missing_last_name_error");
    }

    @Test
    @Description("""
            Test Scenario ID: SC_Last_Name_02
            Test Case ID: TC_Register_06
            Title: Validate That "Last Name" has to contain only alphabetic character When registering a new customer""")
    public void TC_Register_06() {
        this.vars = TestBase.rand_vars();
        this.register_page = new RegisterPage(this.driver);
        this.account_overview_page = new AccountOverview(this.driver);
        this.register_page.navigate();
        this.register_page.register(
                this.vars.get("first_name"),
                this.vars.get("last_name")+"1_-.",
                this.vars.get("address"),
                this.vars.get("city"),
                this.vars.get("state"),
                this.vars.get("zip_code"),
                this.vars.get("phone_number"),
                this.vars.get("ssn"),
                this.vars.get("username"),
                this.vars.get("password"),
                this.vars.get("password_confirm")
        );
        register_page.validate_failed_register();
        register_page.validate_last_name_error_message("last_name_non-alphabetic_character_error");
    }

    @Test
    @Description("""
            Test Scenario ID: SC_Address_01
            Test Case ID: TC_Register_07
            Title: Validate That "Address" cannot be blank When registering a new customer""")
    public void TC_Register_07() {
        this.vars = TestBase.rand_vars();
        this.register_page = new RegisterPage(this.driver);
        this.account_overview_page = new AccountOverview(this.driver);
        this.register_page.navigate();
        this.register_page.register(
                this.vars.get("first_name"),
                this.vars.get("last_name"),
                "",
                this.vars.get("city"),
                this.vars.get("state"),
                this.vars.get("zip_code"),
                this.vars.get("phone_number"),
                this.vars.get("ssn"),
                this.vars.get("username"),
                this.vars.get("password"),
                this.vars.get("password_confirm")
        );
        register_page.validate_failed_register();
        register_page.validate_address_error_message("missing_address_error");
    }

    @Test
    @Description("""
            Test Scenario ID: SC_City_01
            Test Case ID: TC_Register_08
            Title: Validate That "City" cannot be blank When registering a new customer""")
    public void TC_Register_08() {
        this.vars = TestBase.rand_vars();
        this.register_page = new RegisterPage(this.driver);
        this.account_overview_page = new AccountOverview(this.driver);
        this.register_page.navigate();
        this.register_page.register(
                this.vars.get("first_name"),
                this.vars.get("last_name"),
                this.vars.get("address"),
                "",
                this.vars.get("state"),
                this.vars.get("zip_code"),
                this.vars.get("phone_number"),
                this.vars.get("ssn"),
                this.vars.get("username"),
                this.vars.get("password"),
                this.vars.get("password_confirm")
        );
        register_page.validate_failed_register();
        register_page.validate_city_error_message("missing_city_error");
    }

    @Test
    @Description("""
            Test Scenario ID: SC_City_02
            Test Case ID: TC_Register_09
            Title: Validate That "City" has to contain only alphabetic character When registering a new customer""")
    public void TC_Register_09() {
        this.vars = TestBase.rand_vars();
        this.register_page = new RegisterPage(this.driver);
        this.account_overview_page = new AccountOverview(this.driver);
        this.register_page.navigate();
        this.register_page.register(
                this.vars.get("first_name"),
                this.vars.get("last_name"),
                this.vars.get("address"),
                this.vars.get("city")+"1_-.",
                this.vars.get("state"),
                this.vars.get("zip_code"),
                this.vars.get("phone_number"),
                this.vars.get("ssn"),
                this.vars.get("username"),
                this.vars.get("password"),
                this.vars.get("password_confirm")
        );
        register_page.validate_failed_register();
        register_page.validate_city_error_message("city_non-alphabetic_character_error");
    }

    @Test
    @Description("""
            Test Scenario ID: SC_State_01
            Test Case ID: TC_Register_10
            Title: Validate That "State" cannot be blank When registering a new customer""")
    public void TC_Register_10() {
        this.vars = TestBase.rand_vars();
        this.register_page = new RegisterPage(this.driver);
        this.account_overview_page = new AccountOverview(this.driver);
        this.register_page.navigate();
        this.register_page.register(
                this.vars.get("first_name"),
                this.vars.get("last_name"),
                this.vars.get("address"),
                this.vars.get("city"),
                "",
                this.vars.get("zip_code"),
                this.vars.get("phone_number"),
                this.vars.get("ssn"),
                this.vars.get("username"),
                this.vars.get("password"),
                this.vars.get("password_confirm")
        );
        register_page.validate_failed_register();
        register_page.validate_state_error_message("missing_state_error");
    }

    @Test
    @Description("""
            Test Scenario ID: SC_State_02
            Test Case ID: TC_Register_11
            Title: Validate That "State" has to contain only alphabetic character When registering a new customer""")
    public void TC_Register_11() {
        this.vars = TestBase.rand_vars();
        this.register_page = new RegisterPage(this.driver);
        this.account_overview_page = new AccountOverview(this.driver);
        this.register_page.navigate();
        this.register_page.register(
                this.vars.get("first_name"),
                this.vars.get("last_name"),
                this.vars.get("address"),
                this.vars.get("city"),
                this.vars.get("state")+"1_-.",
                this.vars.get("zip_code"),
                this.vars.get("phone_number"),
                this.vars.get("ssn"),
                this.vars.get("username"),
                this.vars.get("password"),
                this.vars.get("password_confirm"));
        register_page.validate_failed_register();
        register_page.validate_state_error_message("state_non-alphabetic_character_error");
    }

    @Test
    @Description("""
            Test Scenario ID: SC_Zip_Code_01
            Test Case ID: TC_Register_12
            Title: Validate That "Zip Code" cannot be blank When registering a new customer""")
    public void TC_Register_12() {
        this.vars = TestBase.rand_vars();
        this.register_page = new RegisterPage(this.driver);
        this.account_overview_page = new AccountOverview(this.driver);
        this.register_page.navigate();
        this.register_page.register(
                this.vars.get("first_name"),
                this.vars.get("last_name"),
                this.vars.get("address"),
                this.vars.get("city"),
                this.vars.get("state"),
                "",
                this.vars.get("phone_number"),
                this.vars.get("ssn"),
                this.vars.get("username"),
                this.vars.get("password"),
                this.vars.get("password_confirm")
        );
        register_page.validate_failed_register();
        register_page.validate_zip_code_error_message("missing_zip_code_error");
    }

    @Test
    @Description("""
            Test Scenario ID: SC_Zip_Code_02
            Test Case ID: TC_Register_13
            Title: Validate That "Zip Code" has to contain only numeric character When registering a new customer""")
    public void TC_Register_13() {
        this.vars = TestBase.rand_vars();
        this.register_page = new RegisterPage(this.driver);
        this.account_overview_page = new AccountOverview(this.driver);
        this.register_page.navigate();
        this.register_page.register(
                this.vars.get("first_name"),
                this.vars.get("last_name"),
                this.vars.get("address"),
                this.vars.get("city"),
                this.vars.get("state"),
               this.vars.get("zip_code")+"a_-.",
                this.vars.get("phone_number"),
                this.vars.get("ssn"),
                this.vars.get("username"),
                this.vars.get("password"),
                this.vars.get("password_confirm")
        );
        register_page.validate_failed_register();
        register_page.validate_zip_code_error_message("zip_code_non-alphabetic_character_error");
    }

    @Test
    @Description("""
            Test Scenario ID: SC_Phone_Num_01
            Test Case ID: TC_Register_14
            Title: Validate That "Phone #" cannot be blank When registering a new customer""")
    public void TC_Register_14() {
        this.vars = TestBase.rand_vars();
        this.register_page = new RegisterPage(this.driver);
        this.account_overview_page = new AccountOverview(this.driver);
        this.register_page.navigate();
        this.register_page.register(
                this.vars.get("first_name"),
                this.vars.get("last_name"),
                this.vars.get("address"),
                this.vars.get("city"),
                this.vars.get("state"),
                this.vars.get("zip_code"),
               "",
                this.vars.get("ssn"),
                this.vars.get("username"),
                this.vars.get("password"),
                this.vars.get("password_confirm")
        );
        register_page.validate_failed_register();
        register_page.validate_phone_number_error_message("missing_phone_number_error");
    }

    @Test
    @Description("""
            Test Scenario ID: SC_Phone_Num_02
            Test Case ID: TC_Register_15
            Title: Validate That "Phone number" has to contain only numeric character When registering a new customer""")
    public void TC_Register_15() {
        this.vars = TestBase.rand_vars();
        this.register_page = new RegisterPage(this.driver);
        this.account_overview_page = new AccountOverview(this.driver);
        this.register_page.navigate();
        this.register_page.register(
                this.vars.get("first_name"),
                this.vars.get("last_name"),
                this.vars.get("address"),
                this.vars.get("city"),
                this.vars.get("state"),
                this.vars.get("zip_code"),
                this.vars.get("phone_number")+"a_-.",
                this.vars.get("ssn"),
                this.vars.get("username"),
                this.vars.get("password"),
                this.vars.get("password_confirm")
        );
        register_page.validate_failed_register();
        register_page.validate_phone_number_error_message("phone_number_non-alphabetic_character_error");
    }

    @Test
    @Description("""
            Test Scenario ID: SC_SSN_01
            Test Case ID: TC_Register_16
            Title: Validate That "SSN" cannot be blank When registering a new customer""")
    public void TC_Register_16() {
        this.vars = TestBase.rand_vars();
        this.register_page = new RegisterPage(this.driver);
        this.account_overview_page = new AccountOverview(this.driver);
        this.register_page.navigate();
        this.register_page.register(
                this.vars.get("first_name"),
                this.vars.get("last_name"),
                this.vars.get("address"),
                this.vars.get("city"),
                this.vars.get("state"),
                this.vars.get("zip_code"),
                this.vars.get("phone_number"),
               "",
                this.vars.get("username"),
                this.vars.get("password"),
                this.vars.get("password_confirm")
        );
        register_page.validate_failed_register();
        register_page.validate_ssn_error_message("missing_ssn_error");
    }

    @Test
    @Description("""
            Test Scenario ID: SC_SSN_02
            Test Case ID: TC_Register_17
            Title: Validate That "SSN" has to contain only numeric character When registering a new customer""")
    public void TC_Register_17() {
        this.vars = TestBase.rand_vars();
        this.register_page = new RegisterPage(this.driver);
        this.account_overview_page = new AccountOverview(this.driver);
        this.register_page.navigate();
        this.register_page.register(
                this.vars.get("first_name"),
                this.vars.get("last_name"),
                this.vars.get("address"),
                this.vars.get("city"),
                this.vars.get("state"),
                this.vars.get("zip_code"),
                this.vars.get("phone_number"),
                this.vars.get("ssn")+"a_-.",
                this.vars.get("username"),
                this.vars.get("password"),
                this.vars.get("password_confirm")
        );
        register_page.validate_failed_register();
        register_page.validate_ssn_error_message("ssn_non-alphabetic_character_error");
    }

    @Test
    @Description("""
            Test Scenario ID: SC_Username_01
            Test Case ID: TC_Register_18
            Title: Validate That "Username" cannot be blank When registering a new customer""")
    public void TC_Register_18() {
        this.vars = TestBase.rand_vars();
        this.register_page = new RegisterPage(this.driver);
        this.account_overview_page = new AccountOverview(this.driver);
        this.register_page.navigate();
        this.register_page.register(
                this.vars.get("first_name"),
                this.vars.get("last_name"),
                this.vars.get("address"),
                this.vars.get("city"),
                this.vars.get("state"),
                this.vars.get("zip_code"),
                this.vars.get("phone_number"),
                this.vars.get("ssn"),
               "",
                this.vars.get("password"),
                this.vars.get("password_confirm")
        );
        register_page.validate_failed_register();
        register_page.validate_username_error_message("missing_username_error");
    }

    @Test
    @Description("""
            Test Scenario ID: SC_Password_01
            Test Case ID: TC_Register_19
            Title: Validate That "Password" cannot be blank When registering a new customer""")
    public void TC_Register_19() {
        this.vars = TestBase.rand_vars();
        this.register_page = new RegisterPage(this.driver);
        this.account_overview_page = new AccountOverview(this.driver);
        this.register_page.navigate();
        this.register_page.register(
                this.vars.get("first_name"),
                this.vars.get("last_name"),
                this.vars.get("address"),
                this.vars.get("city"),
                this.vars.get("state"),
                this.vars.get("zip_code"),
                this.vars.get("phone_number"),
                this.vars.get("ssn"),
                this.vars.get("username"),
               "",
                this.vars.get("password_confirm")
        );
        register_page.validate_failed_register();
        register_page.validate_password_error_message("missing_password_error");
    }

    @Test
    @Description("""
            Test Scenario ID: SC_Password_Confirmation_01
            Test Case ID: TC_Register_20
            Title: Validate That "Password Confirmation" cannot be blank When registering a new customer""")
    public void TC_Register_20() {
        this.vars = TestBase.rand_vars();
        this.register_page = new RegisterPage(this.driver);
        this.account_overview_page = new AccountOverview(this.driver);
        this.register_page.navigate();
        this.register_page.register(
                this.vars.get("first_name"),
                this.vars.get("last_name"),
                this.vars.get("address"),
                this.vars.get("city"),
                this.vars.get("state"),
                this.vars.get("zip_code"),
                this.vars.get("phone_number"),
                this.vars.get("ssn"),
                this.vars.get("username"),
                this.vars.get("password"),
               ""
        );
        register_page.validate_failed_register();
        register_page.validate_password_confirm_error_message("missing_confirm_password_error");
    }

    @Test
    @Description("""
            Test Scenario ID: SC_Password_Confirmation_02
            Test Case ID: TC_Register_21
            Title: Validate That "Password Confirmation" has to match the "Password" When registering a new customer""")
    public void TC_Register_21() {
        this.vars = TestBase.rand_vars();
        this.register_page = new RegisterPage(this.driver);
        this.account_overview_page = new AccountOverview(this.driver);
        this.register_page.navigate();
        this.register_page.register(
                vars.get("first_name"),
                vars.get("last_name"),
                vars.get("address"),
                vars.get("city"),
                vars.get("state"),
                vars.get("zip_code"),
                vars.get("phone_number"),
                vars.get("ssn"),
                vars.get("username"),
                vars.get("password"),
                vars.get("password")+"_InVaLiD"
        );
        register_page.validate_failed_register();
        register_page.validate_password_confirm_error_message("wrong_confirm_password_error");
    }
}