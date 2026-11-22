package pages.waitingStratefies;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DynamicLoadingPage {
    //Thread.sleep(5000); fixed wait for 5 seconds
    // Different Wait St
    // -> Implicit Wait
    // -> Explicit Wait  --> WebDriverWait
    // -> Fluent Wait


    WebDriver driver;
    By titleOfPage = By.tagName("h3");
    String expectedTitle = "Dynamically Loaded Page Elements";
    By firstExampleLink = By.partialLinkText("Example 1:");
    By secondExampleLink = By.partialLinkText("Example 2:");



    public DynamicLoadingPage(WebDriver driver) {
        this.driver = driver;
    }
     public String getExpectedTitle(){
        return expectedTitle;
     }

     public String getActualTitle(){
        return driver.findElement(titleOfPage).getText();
     }

     public FirstDynamicPage clickOnFirstExample(){
        driver.findElement(firstExampleLink).click();
        return new FirstDynamicPage(driver);
     }

     public SecondDynamicPage clickOnSecondExample(){
        driver.findElement(secondExampleLink).click();
        return new SecondDynamicPage(driver);
    }







}
