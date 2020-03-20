import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
    WebDriver driver;

    @FindBy(id = "username")
    private By username;

    @FindBy(id = "password")
    private By password;

    @FindBy(name = "login")
    private By loginButton;

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    public void setPassword(String password) {
        this.driver.findElement(this.password).sendKeys(password);
    }

    public void setUsername(String username) {
        this.driver.findElement(this.username).sendKeys(username);
    }

    public RedmineMainPage clickLogin() {
        this.driver.findElement(this.loginButton).click();
        return new RedmineMainPage(this.driver);
    }
}
