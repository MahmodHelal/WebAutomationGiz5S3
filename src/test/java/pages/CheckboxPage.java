package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CheckboxPage {
    WebDriver driver;
    By titleOfPageBy = By.tagName("h3");
    By firstCheck = By.xpath("//input[@type=\"checkbox\"][1]");
    By secondCheck = By.xpath("//input[@type=\"checkbox\"][2]");
    By allElmentsBy = By.cssSelector("input[type='checkbox']");

    public CheckboxPage(WebDriver driver) {
        this.driver = driver;
    }



    public void clickOnFirstCheckbox(){
        driver.findElement(firstCheck).click();
    }

    public void clickOnSecondCheckbox(){
        driver.findElement(secondCheck).click();
    }

    public void clickOnCheckboxByNumber(int number){
        List<WebElement> allElements = driver.findElements(allElmentsBy);
        allElements.get(number -1).click();
    }

    public WebElement getCheckboxNumber(int number){
        List<WebElement> allElements = driver.findElements(allElmentsBy);
       return allElements.get(number -1);
    }



}
