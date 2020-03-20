import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RedmineHomePage {
    WebDriver driver;

    @FindBy(linkText = "Sign in")
    private By signIn;

    public RedmineHomePage(WebDriver driver){
        this.driver = driver;
    }

    public By getSignInButton(){
        return this.signIn;
    }

    public LoginPage clickSignIn() {
        this.driver.findElement(this.signIn).click();
        return new LoginPage(this.driver);
    }
}
