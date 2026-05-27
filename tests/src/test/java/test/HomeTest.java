package test;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import page.HomePage;
import page.LoginPage;

public class HomeTest extends BaseTest {
    @Before
    public void setup() {
        super.setup();
        driver.get(config.getBaseUrl() + "/login");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(config.getUsername(), config.getPassword());
    }

    @Test
    public void testHoverLocation() {
        HomePage homePage = new HomePage(driver);
        homePage.hoverLocation();
    }

    @Test
    public void testPageTitle() {
        HomePage homePage = new HomePage(driver);
        String title = homePage.getPageTitle();
        assertTrue(title.contains("OpenMRS"));
    }

    @Test
    public void testLogOut() {
        HomePage homePage = new HomePage(driver);
        homePage.logout();
        homePage.waitUrlContains("/login");
    }
}