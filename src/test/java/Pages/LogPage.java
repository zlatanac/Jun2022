package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogPage extends BaseTest {

    public LogPage() {
        PageFactory.initElements(driver, this);
    }

    public @FindBy (id = "userName")
    WebElement username;

    public @FindBy (id = "password")
    WebElement password;

    public @FindBy (id = "login")
    WebElement loginButton;

    //-----------------------

    public void insertUsername(String name) {
        username.clear();
        username.sendKeys(name);
    }

    public void insertPassword(String pass) {
        password.clear();
        password.sendKeys(pass);
    }

    public void clickOnLoginButton() {
        loginButton.click();
    }

}