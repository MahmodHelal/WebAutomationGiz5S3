package pages.waitingStratefies;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;



public class DynamicControlsPage {
    WebDriver driver;
    WebDriverWait wait;
    By titleOfPage = By.xpath("//div[@class='example']/h4[1]");
    String expectedTitle = "Dynamic Controls";
    By checkbox = By.id("checkbox");
    By checkboxButton = By.cssSelector("#checkbox-example button");
    By input = By.cssSelector("#input-example input");
    By inputButton = By.xpath("//button[@onclick=\"swapInput()\"]");
    By message = By.id("message");
    public DynamicControlsPage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver , Duration.ofSeconds(20));
    }
    public String getActualTitle(){
        return driver.findElement(titleOfPage).getText();
    }
    public String getExpectedTitle(){
        return expectedTitle;
    }
    public  boolean isCheckboxPresent(){
        return driver.findElements(checkbox).size() > 0;
    }
    public void removeCheckbox(){
        driver.findElement(checkboxButton).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(checkbox));
    }
    public void addCheckbox(){
        driver.findElement(checkboxButton).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(checkbox));
    }
    public  boolean isInputEnabled(){
        return driver.findElement(input).isEnabled();
    }
    public void enableInput(){
        driver.findElement(inputButton).click();
        wait.until(ExpectedConditions.elementToBeClickable(input));
    }
    public  void disableInput(){
        driver.findElement(inputButton).click();
        wait.until(ExpectedConditions.not(ExpectedConditions.elementToBeClickable(input)));
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    public  void typeText(String text){
        driver.findElement(input).sendKeys(text);
    }
    public String getText(){
        return driver.findElement(input).getAttribute("value");
    }

    public  String getMessage(){
        return driver.findElement(message).getText();
    }

}
