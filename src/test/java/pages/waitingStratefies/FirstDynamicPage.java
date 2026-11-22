package pages.waitingStratefies;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FirstDynamicPage {
    WebDriver driver;

    By titleOfPage = By.xpath("//div[@class=\"example\"]/h4");
    String expectedTitle = "Example 1: Element on page that is hidden";
    By startButton = By.cssSelector("#start > button");
    By finishText = By.cssSelector("#finish > h4");
    String expectedFinishText = "Hello World!";
    WebDriverWait wait;


    public FirstDynamicPage(WebDriver driver){
        wait =   new WebDriverWait(driver, Duration.ofSeconds(10));
        this.driver = driver;
    }

    public String getTitleOfPage(){
        return wait.until(ExpectedConditions.visibilityOf(driver.findElement(titleOfPage))).getText();
    }
    public String getExpectedTitle(){
        return expectedTitle;
    }
    public void clickStartButton(){
        wait.until(ExpectedConditions.elementToBeClickable(startButton)).click();
    }
    public String getActualFinishText(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement finishTextElement = wait.until(ExpectedConditions.visibilityOfElementLocated(finishText));
        return finishTextElement.getText();
    }
    public String getExpectedFinishText(){
        return expectedFinishText;
    }




}
