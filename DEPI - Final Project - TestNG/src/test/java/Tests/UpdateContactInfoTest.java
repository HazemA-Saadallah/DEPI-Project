package Tests;

import Base.TestBase;
import Pages.AccountOverview;
import Pages.LoginPage;
import Pages.RegisterPage;
import Pages.UpdateContactInfoPage;
import jdk.jfr.Description;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

public class UpdateContactInfoTest extends TestBase {
    private static final Logger log = LoggerFactory.getLogger(UpdateContactInfoTest.class);
    private RegisterPage register_page;
    private LoginPage login_page;
    private AccountOverview account_overview_page;
    private UpdateContactInfoPage update_contact_info_page;
    private Map<String, String> vars;

    @Test
    @Description("""
            Test Scenario ID: SC_Verify_User_Info_01
            Test Case ID: TC_Update_Contact_Info_01
            Title: Validate That all user data in the "Update Contact info" tab is correct and is the registered one When logged-in
            """)
    public void TC_Update_Contact_Info_01() {
        this.vars = TestBase.rand_vars();
        this.register_page = new RegisterPage(this.driver);
        this.register_page.navigate();
        this.register_page.register(this.vars);
        this.update_contact_info_page = new UpdateContactInfoPage(this.driver);
        this.update_contact_info_page.navigate();
        this.update_contact_info_page.validate_info(
                this.vars.get("first_name"),
                this.vars.get("last_name"),
                this.vars.get("address"),
                this.vars.get("city"),
                this.vars.get("state"),
                this.vars.get("zip_code"),
                this.vars.get("phone_number")
        );
    }

    @Test
    @Description("""
            Test Scenario ID: SC_Update_First_name_01
            Test Case ID: TC_Update_Contact_Info_02
            Title: Validate That user can edit "First Name" in the "Update Contact info" tab When logged-in
            """)
    public void TC_Update_Contact_Info_02() throws InterruptedException {
        this.vars = TestBase.rand_vars();
        this.register_page = new RegisterPage(this.driver);
        this.update_contact_info_page = new UpdateContactInfoPage(this.driver);
        this.register_page.navigate();
        this.register_page.register(this.vars);
        this.update_contact_info_page.navigate();
        this.update_contact_info_page.update_first_name("NewFirstName");
        this.update_contact_info_page.validate_profile_update_message(List.of("first name"));
    }

    @Test
    @Description("""
            Test Scenario ID: SC_Update_Last_name_01
            Test Case ID: TC_Update_Contact_Info_03
            Title: Validate That user can edit "Last Name" in the "Update Contact info" tab When logged-in
            """)
    public void TC_Update_Contact_Info_03() {
        this.vars = TestBase.rand_vars();
        this.register_page = new RegisterPage(this.driver);
        this.update_contact_info_page = new UpdateContactInfoPage(this.driver);
        this.register_page.navigate();
        this.register_page.register(this.vars);
        this.update_contact_info_page.navigate();
        this.update_contact_info_page.update_last_name("NewListName");
        this.update_contact_info_page.validate_profile_update_message(List.of("last name"));
    }

    @Test
    @Description("""
            Test Scenario ID: SC_Update_Address_01
            Test Case ID: TC_Update_Contact_Info_04
            Title: Validate That user can edit "Address" in the "Update Contact info" tab When logged-in
            """)
    public void TC_Update_Contact_Info_04() {
        this.vars = TestBase.rand_vars();
        this.register_page = new RegisterPage(this.driver);
        this.update_contact_info_page = new UpdateContactInfoPage(this.driver);
        this.register_page.navigate();
        this.register_page.register(this.vars);
        this.update_contact_info_page.navigate();
        this.update_contact_info_page.update_address("NewAddress");
        this.update_contact_info_page.validate_profile_update_message(List.of("address"));
    }

    @Test
    @Description("""
            Test Scenario ID: SC_Update_City_01
            Test Case ID: TC_Update_Contact_Info_05
            Title: Validate That user can edit "City" in the "Update Contact info" tab When logged-in
            """)
    public void TC_Update_Contact_Info_05() {
        this.vars = TestBase.rand_vars();
        this.register_page = new RegisterPage(this.driver);
        this.update_contact_info_page = new UpdateContactInfoPage(this.driver);
        this.register_page.navigate();
        this.register_page.register(this.vars);
        this.update_contact_info_page.navigate();
        this.update_contact_info_page.update_city("NewCity");
        this.update_contact_info_page.validate_profile_update_message(List.of("city"));
    }

    @Test
    @Description("""
            Test Scenario ID: SC_Update_State_01
            Test Case ID: TC_Update_Contact_Info_06
            Title: Validate That user can edit "State" in the "Update Contact info" tab When logged-in
            """)
    public void TC_Update_Contact_Info_06() {
        this.vars = TestBase.rand_vars();
        this.register_page = new RegisterPage(this.driver);
        this.update_contact_info_page = new UpdateContactInfoPage(this.driver);
        this.register_page.navigate();
        this.register_page.register(this.vars);
        this.update_contact_info_page.navigate();
        this.update_contact_info_page.update_state("NewState");
        this.update_contact_info_page.validate_profile_update_message(List.of("state"));
    }

    @Test
    @Description("""
            Test Scenario ID: SC_Update_Zip_Code_01
            Test Case ID: TC_Update_Contact_Info_07
            Title: Validate That user can edit "Zip Code" in the "Update Contact info" tab When logged-in
            """)
    public void TC_Update_Contact_Info_07() {
        this.vars = TestBase.rand_vars();
        this.register_page = new RegisterPage(this.driver);
        this.update_contact_info_page = new UpdateContactInfoPage(this.driver);
        this.register_page.navigate();
        this.register_page.register(this.vars);
        this.update_contact_info_page.navigate();
        this.update_contact_info_page.update_zip_code("123123123");
        this.update_contact_info_page.validate_profile_update_message(List.of("zip code"));
    }

    @Test
    @Description("""
            Test Scenario ID: SC_Update_Phone_Number_01
            Test Case ID: TC_Update_Contact_Info_08
            Title: Validate That user can edit "Phone #" in the "Update Contact info" tab When logged-in
            """)
    public void TC_Update_Contact_Info_08() {
        this.vars = TestBase.rand_vars();
        this.register_page = new RegisterPage(this.driver);
        this.update_contact_info_page = new UpdateContactInfoPage(this.driver);
        this.register_page.navigate();
        this.register_page.register(this.vars);
        this.update_contact_info_page.navigate();
        this.update_contact_info_page.update_phone_number("123123123");
        this.update_contact_info_page.validate_profile_update_message(List.of("phone number"));
    }
}