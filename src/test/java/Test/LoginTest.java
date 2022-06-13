package Test;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @BeforeMethod
    public void pageSetUp() {
        driver.manage().window().maximize();
        driver.navigate().to("https://demoqa.com/");
    }

    public void goToLoginPage() {
        homepagePage.clickOnBookstoreApplication();
        sidebarPage.clickOnLoginButton();
    }

    @Test
    public void successfulLogin() throws InterruptedException {
        String validUsername = excelReader.getStringData("Login", 1, 0);
        String validPassword = excelReader.getStringData("Login", 1, 1);

        goToLoginPage();
        /*loginPage.insertUsername(validUsername);
        loginPage.insertPassword(validPassword);
        scrollIntoView(loginPage.getLoginButton());
        loginPage.clickOnLoginButton();
        Thread.sleep(2000);
        Assert.assertTrue(profilePage.getProfileName().isDisplayed());
        Assert.assertTrue(elementVisible(profilePage.getProfileName()));*/

        Thread.sleep(2000);
        scrollIntoView(logPage.username);
        logPage.insertUsername(validUsername);
        logPage.insertPassword(validPassword);
        logPage.clickOnLoginButton();
    }

    @Test
    public void unsuccessfulLoginWithInvalidUsername() throws InterruptedException {
        goToLoginPage();

        for (int i = 1; i < excelReader.getLastRow("Login"); i++) {
            String invalidUsername = excelReader.getStringData("Login", i,2);
            loginPage.insertUsername(invalidUsername);
            String validPassword = excelReader.getStringData("Login", 1,1);
            String invalidPassword = excelReader.getStringData("Login", i,3);
            loginPage.insertPassword(validPassword);
            scrollIntoView(loginPage.getLoginButton());
            loginPage.clickOnLoginButton();

            Thread.sleep(3000);

            Assert.assertFalse(elementVisibility(profilePage.getProfileName()));

            /*boolean check = false;
            try {
                check = profilePage.getProfileName().isDisplayed();
            } catch (Exception e) {

            }

            Assert.assertFalse(check);*/
        }


    }

}