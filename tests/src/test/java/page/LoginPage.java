package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    private final By usernameInput = By.xpath("//div[contains(@class, 'cds--tile')]//form//input[@id='username' and @type='text']");
    private final By passwordInput = By.xpath("//div[contains(@class, 'cds--tile')]//form//input[@id='password' and @type='password']");
    private final By locationInput = By.xpath("//fieldset//div[2]/label[@for='ba685651-ed3b-4e63-9b35-78893060758a']");
    private final By loginButton = By.xpath("//div[contains(@class, 'cds--form-item')]/following-sibling::button[@type='submit']");
    private final By error = By.xpath("//div[@class='cds--inline-notification__title']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }
    
    public void login(String username, String password) {
        writeText(usernameInput, username);
        click(loginButton);
        writeText(passwordInput, password);
        click(loginButton);
        click(locationInput);
        click(loginButton);
    }

    public void tryLogin(String username, String password) {
        writeText(usernameInput, username);
        click(loginButton);
        writeText(passwordInput, password);
        click(loginButton);
    }

    public String getError() {
        return getText(error);
    }
}
