package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {
    private final By changeLocation = By.xpath("//header//div[contains(@data-extension-id, 'location')]");
    private final By tooltip = By.xpath("//header//div[@data-extension-id='location-changer']//span[@aria-hidden='false']");
    private final By profileButton = By.xpath("//header//div[@data-extension-id='user-menu-button']//button[@data-tutorial-target='user-settings']");
    private final By logoutButton = By.xpath("//div[@data-extension-id='logout-button']//li[last()]/a/button");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void hoverLocation() {
        hover(changeLocation);
        waitVisible(tooltip);
    }

    public void logout() {
        click(profileButton);
        click(logoutButton);
    }
}
