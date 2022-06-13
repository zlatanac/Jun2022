package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage extends BaseTest {

    public Homepage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy (className = "card-body")
    WebElement card;

    //-----------------

    public void clickOnCard() {
        card.click();
    }

}