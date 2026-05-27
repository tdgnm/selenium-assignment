package test;

import utils.Config;

import java.net.URI;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class BaseTest {
    protected Config config;
    protected WebDriver driver;

    @Before
    public void setup() {
        try {
            config = new Config();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--start-maximized");
            options.addArguments("--window-size=1920,1080");
            options.addArguments("--disable-notifications");
            driver = new RemoteWebDriver(new URI("http://selenium:4444/wd/hub").toURL(), options);
            driver.manage().window().maximize();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @After
    public void close() {
        if (driver != null) {
            driver.quit();
        }
    }
}
