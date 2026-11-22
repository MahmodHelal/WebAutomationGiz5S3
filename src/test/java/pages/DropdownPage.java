package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DropdownPage {
    WebDriver driver;
    By dropdownBy = By.id("dropdown");

    public DropdownPage(WebDriver driver) {
        this.driver = driver;
    }



    public void selectOptionByText(String option){
        Select select = new Select(driver.findElement(dropdownBy));
        select.selectByVisibleText(option);
    }


    public String getSelectedItem(){
        Select select = new Select(driver.findElement(dropdownBy));
        return select.getFirstSelectedOption().getText();
    }
}
