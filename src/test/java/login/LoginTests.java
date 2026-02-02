package login;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
public class LoginTests extends BaseTest {

    @Test
    public void verifyValidLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");

        Assert.assertTrue(
                driver.getCurrentUrl().contains("inventory.html"),
                "Valid login failed"
        );
    }

    @Test
    public void verifyInvalidLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("wrong_user", "wrong_pass");

        String error = loginPage.getErrorMessage();
        Assert.assertTrue(
                error.contains("Username and password do not match"),
                "Error message not correct for invalid login"
        );
    }

    @Test
    public void verifyLoginWithoutPassword() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "");

        String error = loginPage.getErrorMessage();
        Assert.assertTrue(
                error.contains("Password is required"),
                "Error message not correct for empty password"
        );
    }
}
