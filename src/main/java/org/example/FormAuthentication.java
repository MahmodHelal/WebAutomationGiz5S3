package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class FormAuthentication {
    WebDriver driver;
    @BeforeClass
    public void setup(){
         driver = new EdgeDriver();
        driver.manage().window().maximize();

    }
    @BeforeMethod
    public void OpenForAuth(){
        driver.get("https://the-internet.herokuapp.com/");
        WebElement formAuth = driver.findElement(By.linkText("Form Authentication"));
        formAuth.click();
    }
    @Test(priority = 1)
    public void validLogin(){
        WebElement userName = driver.findElement(By.cssSelector("input[id='username']"));
        userName.sendKeys("tomsmith");
        WebElement password = driver.findElement(By.xpath("//input[@type='password']"));
        password.sendKeys("SuperSecretPassword!");
        WebElement loginButton1 = driver.findElement(By.cssSelector(".fa.fa-2x.fa-sign-in"));
/*        WebElement loginButton2 = driver.findElement(By.cssSelector("i[class='fa fa-2x fa-sign-in']"));
        WebElement loginButton3 = driver.findElement(By.xpath("//i[@class='fa fa-2x fa-sign-in']"));*/
        loginButton1.click();
        String expectedMsg = "You logged into a secure area!";
        String actualMsg = driver.findElement(By.id("flash")).getText();
//        Assert.assertEquals(actualMsg,expectedMsg);
        Assert.assertTrue(actualMsg.contains(expectedMsg));
        Assert.assertTrue(driver.getCurrentUrl().contains("/secure"));
    }
    // invalidUsername
    @Test(priority = 2)
    public void invalidUserName(){
        WebElement userName = driver.findElement(By.cssSelector("input[id='username']"));
        userName.sendKeys("Wrong username");
        WebElement password = driver.findElement(By.xpath("//input[@type='password']"));
        password.sendKeys("SuperSecretPassword!");
        WebElement loginButton1 = driver.findElement(By.cssSelector(".fa.fa-2x.fa-sign-in"));
/*        WebElement loginButton2 = driver.findElement(By.cssSelector("i[class='fa fa-2x fa-sign-in']"));
        WebElement loginButton3 = driver.findElement(By.xpath("//i[@class='fa fa-2x fa-sign-in']"));*/
        loginButton1.click();
        String expectedMsg = "Your username is invalid!";
        String actualMsg = driver.findElement(By.id("flash")).getText();
        Assert.assertTrue(actualMsg.contains(expectedMsg));
        Assert.assertFalse(driver.getCurrentUrl().contains("/secure"));
    }

    // invalid Password
    @Test(priority = 3)
    public void invalidPassword(){
        WebElement userName = driver.findElement(By.cssSelector("input[id='username']"));
        userName.sendKeys("tomsmith");
        WebElement password = driver.findElement(By.xpath("//input[@type='password']"));
        password.sendKeys("Wrong");
        WebElement loginButton1 = driver.findElement(By.cssSelector(".fa.fa-2x.fa-sign-in"));
/*        WebElement loginButton2 = driver.findElement(By.cssSelector("i[class='fa fa-2x fa-sign-in']"));
        WebElement loginButton3 = driver.findElement(By.xpath("//i[@class='fa fa-2x fa-sign-in']"));*/
        loginButton1.click();
        String expectedMsg = "Your password is invalid!";
        String actualMsg = driver.findElement(By.id("flash")).getText();
        Assert.assertTrue(actualMsg.contains(expectedMsg));
        Assert.assertFalse(driver.getCurrentUrl().contains("/secure"));
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
// validLogin
