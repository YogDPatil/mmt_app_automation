package com.ui.stepdefinations;

import com.constant.ConfigConst;
import com.ui.pages.LoginPage;
import com.utils.TestUtil;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public final class LoginPageStepDef {
    private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
    @Given("user is on login page")
    public void user_is_on_login_page() {
        DriverFactory.getDriver().get(TestUtil.getValueFromPropertiesFile(ConfigConst.BASE_URL));
    }

    @When("user enters valid login cred")
    public void user_enters_valid_login_cred() {
        loginPage.doLogin(ConfigConst.EMAIL, ConfigConst.PASSWORD);
    }

    @Then("user should login successfully")
    public void user_should_login_successfully() {

    }
}
