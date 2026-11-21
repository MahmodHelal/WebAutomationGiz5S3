package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.formPackage.FormAuthenticationPage;

public class MainHeruPage {
    WebDriver driver;
    public MainHeruPage(WebDriver driver) {
        this.driver = driver;
    }
    public FormAuthenticationPage goToFormAuthentications(){
        WebElement formAuth = driver.findElement(By.linkText("Form Authentication"));
        formAuth.click();
        return  new FormAuthenticationPage(driver);
    }

    public CheckboxPage goToCheckboxesPage(){
        WebElement checkboxLink = driver.findElement(By.linkText("Checkboxes"));
        checkboxLink.click();
        return new CheckboxPage(driver);
    }

}
