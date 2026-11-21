package pages.formPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SecureAreaPage {
    WebDriver driver;
    By messageBy = By.id("flash");
    By logoutButtonBy = By.cssSelector("a[class='button secondary radius']");
    By titleOfSecureAreaPageBy = By.cssSelector("h2");
    String expectedTitleOfSecureAreaPage = "Secure Area";
    By loggedInUserNameBy = By.id("username");


    String expectedMessage = "You logged into a secure area!";

    public SecureAreaPage(WebDriver driver){
        this.driver = driver;
    }

    public void  clickLogoutButton(){
/*        WebElement logoutButtonElement = driver.findElement(logoutButtonBy);
        logoutButtonElement.click();*/


        driver.findElement(logoutButtonBy).click();
    }

    public String getActualMessage(){
        return driver.findElement(messageBy).getText();
//        return messageElement.getText();
    }

    public String getExpectedMessage(){
        return expectedMessage;
    }
    public String getActualTitleOfSecureAreaPage(){
        return driver.findElement(titleOfSecureAreaPageBy).getText();
    }

    public String getExpectedTitleOfSecureAreaPage(){
        return expectedTitleOfSecureAreaPage;
    }

    public String getLoggedInUserName(){
        return driver.findElement(loggedInUserNameBy).getText();
    }
}
