package pages.formPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FormAuthenticationPage {
    private WebDriver driver;
    By usernameBy = By.id("username");
    By passwordBy = By.id("password");
    By loginButtonBy = By.cssSelector("button[type='submit']");
    By messageBy = By.id("flash");



     String expectedUserMessage = "Your username is invalid!";
     String expectedPasswordMessage = "Your password is invalid!";

public FormAuthenticationPage(WebDriver driver){
    this.driver = driver;
}
     public void enterUsername(String username){
         WebElement userNameElement  = driver.findElement(usernameBy);

         userNameElement.sendKeys(username);
     }
     public void enterPassword(String password){
         WebElement passwordElement = driver.findElement(passwordBy);
         passwordElement.sendKeys(password);
     }
     public SecureAreaPage  clickLoginButton(){
            WebElement loginButtonElement = driver.findElement(loginButtonBy);
         loginButtonElement.click();
            return new SecureAreaPage(driver);
     }
     public SecureAreaPage loginBy(String userName, String password){
         enterUsername(userName);
         enterPassword(password);
         clickLoginButton();
         return new SecureAreaPage(driver);
     }
     public  String getActualMessage(){
            WebElement messageElement = driver.findElement(messageBy);

         return messageElement.getText();
     }
     public String getExpectedUserMessage(){
            return expectedUserMessage;
     }
     public String getExpectedPasswordMessage(){
            return expectedPasswordMessage;
     }



}
