package pages.waitingStratefies;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SecondDynamicPage {
    WebDriver driver;
    By titleOfPage = By.xpath("//div[@class=\"example\"]/h4");
    String expectedTitle = "Example 2: Element rendered after the fact";
    By startButton = By.cssSelector("#start > button");
    By finishText = By.cssSelector("#finish > h4");
    String expectedFinishText = "Hello World!";
    WebDriverWait wait;

    public SecondDynamicPage(WebDriver driver){
        this.driver = driver;
        wait =   new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public String getTitleOfPage(){

        return wait.until(ExpectedConditions.visibilityOf(driver.findElement(titleOfPage))).getText();
//        return driver.findElement(titleOfPage).getText();
    }
    public String getExpectedTitle(){
        return expectedTitle;
    }
    public void clickStartButton(){
        wait.until(ExpectedConditions.elementToBeClickable(startButton)).click();
//        driver.findElement(startButton).click();
    }
    public String getActualFinishText(){
//       return wait.until(ExpectedConditions.visibilityOf(driver.findElement(finishText))).getText();
        return wait.until(ExpectedConditions.presenceOfElementLocated(finishText)).getText();
//        return driver.findElement(finishText).getText();
    }
    public String getExpectedFinishText(){
        return expectedFinishText;
    }
}
