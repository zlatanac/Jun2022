package Pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomepagePage {

        WebDriver driver;


        public HomepagePage(WebDriver driver) {
                this.driver = driver;
        }

        List<WebElement> cards = driver.findElements(By.className("card-body"));

        //----------------------------

        public void clickOnBookstoreApplication(){

                for(int i = 0; i < cards.size(); i++){
                        if(cards.get(i).getText().equals("Book Store Application")){
                                cards.get(i).click();
                                break;
                        }
                }
        }


}



