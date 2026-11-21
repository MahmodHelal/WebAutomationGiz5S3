package tests;

import baseTest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MainHeruPage;
import pages.formPackage.FormAuthenticationPage;
import pages.formPackage.SecureAreaPage;

public class FormAuthTest extends BaseTest {
    @Test(priority = 1)
    public void validLoinTest(){

        formAuthenticationPage = mainHeruPage.goToFormAuthentications(); //new FormAuthenticationPage(driver);
        formAuthenticationPage.enterUsername("tomsmith");
        formAuthenticationPage.enterPassword("SuperSecretPassword!");
        secureAreaPage = formAuthenticationPage.clickLoginButton();

        Assert.assertTrue(secureAreaPage.getActualMessage().contains(secureAreaPage.getExpectedMessage()));
        Assert.assertEquals(secureAreaPage.getActualTitleOfSecureAreaPage(), secureAreaPage.getExpectedTitleOfSecureAreaPage());
        Assert.assertTrue(driver.getCurrentUrl().contains("secure"));
        Assert.assertEquals(secureAreaPage.getLoggedInUserName(), "tomsmith");

    }
    @Test(priority = 2)
    public void InvalidLoginUsername(){
        formAuthenticationPage = mainHeruPage.goToFormAuthentications(); //new FormAuthenticationPage(driver);
        formAuthenticationPage.enterUsername("WrongUserName");
        formAuthenticationPage.enterPassword("SuperSecretPassword");
        secureAreaPage = formAuthenticationPage.clickLoginButton();

        Assert.assertTrue(formAuthenticationPage.getActualMessage().contains(formAuthenticationPage.getExpectedPasswordMessage()));
        Assert.assertEquals(driver.getCurrentUrl(), "https://the-internet.herokuapp.com/login");
    }
    @Test(priority = 3)
    public void InvalidLoginPassword(){
        formAuthenticationPage = mainHeruPage.goToFormAuthentications(); //new FormAuthenticationPage(driver);
        formAuthenticationPage.enterUsername("tomsmith");
        formAuthenticationPage.enterPassword("WrongPassword");
        secureAreaPage = formAuthenticationPage.clickLoginButton();

        Assert.assertTrue(formAuthenticationPage.getActualMessage().contains(formAuthenticationPage.getExpectedPasswordMessage()));
        Assert.assertEquals(driver.getCurrentUrl(), "https://the-internet.herokuapp.com/login");
    }
}
