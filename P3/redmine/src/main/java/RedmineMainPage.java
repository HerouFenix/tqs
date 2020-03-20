import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RedmineMainPage {
    WebDriver driver;

    @FindBy(linkText = "jonas_pistolas")
    private By jonasPistolas;

    @FindBy(linkText = "Sign out")
    private By logoutButton;

    public RedmineMainPage(WebDriver driver){
        this.driver = driver;
    }

    public By getSignUsername(){
        return jonasPistolas;
    }

    public RedmineHomePage clickLogout() {
        this.driver.findElement(this.logoutButton).click();
        return new RedmineHomePage(this.driver);
    }
}
