package test;

import static org.junit.Assert.assertTrue;

import org.junit.Before;

import page.HomePage;
import page.LoginPage;
import utils.RandomData;

import org.junit.Test;

public class LoginTest extends BaseTest {
    @Before
    public void setup() {
        super.setup();
        driver.get(config.getBaseUrl() + "/login");
    }

    @Test
    public void testValidLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(config.getUsername(), config.getPassword());
        HomePage homePage = new HomePage(driver);
        homePage.waitUrlContains("/home");
    }

    @Test
    public void testInvalidLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.tryLogin(RandomData.getUsername(), RandomData.getPassword());
        assertTrue(loginPage.getError().contains("Error"));
    }
}
