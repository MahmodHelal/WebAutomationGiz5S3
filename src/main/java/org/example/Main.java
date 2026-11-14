package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws InterruptedException {

/*        WebDriver driver = new EdgeDriver();

        driver.manage().window().maximize();

        driver.get("https://www.google.com/");

        System.out.println("Current Title is : " + driver.getTitle() );
        System.out.println("Current URL is : "+ driver.getCurrentUrl());
        String expectedTitle = "Google";
        String expectedURL = "https://www.google.com/";
        String actualTitle = driver.getTitle();
        String actualURL = driver.getCurrentUrl();
*/
        /*        if (actualTitle.equals(expectedTitle)){
            System.out.println("Test Passed");
        }*/
        /*
        System.out.println(actualTitle.equals(expectedTitle)  ? "Test Passed" : "Test Failed");
        */
        /*
        if (actualURL.equals(expectedURL)){
            System.out.println("Test2 Passed");
        }*/
        /*
        System.out.println(actualURL.equals(expectedURL)  ? "Test2 Passed" : "Test2 Failed");
        // browser navigation
        Thread.sleep(300);
        driver.navigate().to("https://www.saucedemo.com/");
        Thread.sleep(300);
        driver.navigate().back();
        Thread.sleep(300);
        driver.navigate().forward();
        Thread.sleep(300);
        driver.navigate().refresh();
        Thread.sleep(300);
//        driver.quit();

        WebElement username =  driver.findElement(By.id("user-name"));
        username.sendKeys("standard_user");
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("secret_sauce");

        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();

        driver.get("https://the-internet.herokuapp.com/");

        WebElement formAuth = driver.findElement(By.linkText("Form Authentication"));
        
        formAuth.click();


//        driver.quit(); // close the session/
//        driver.close();// close the current tab
        // dif between findElement and findElements
        WebElement test =  driver.findElement(By.id("user-name"));
        List<WebElement> groupTest =  driver.findElements(By.tagName("a"));
        System.out.println(groupTest.size());*/


        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/");
        WebElement formAuth = driver.findElement(By.linkText("Form Authentication"));
        formAuth.click();

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
        if (actualMsg.contains(expectedMsg)){
            System.out.println("test passed");
        }else {
            System.out.println("expected : "+ expectedMsg);
            System.out.println("actual : "+ actualMsg);

            System.out.println("Test Fail");
        }

        if (driver.getCurrentUrl().contains("/secure")){
            System.out.println("Test 2 passed");
        }

        driver.quit();

    }
    // validLogin
    public void validLogin(){
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/");
        WebElement formAuth = driver.findElement(By.linkText("Form Authentication"));
        formAuth.click();

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
        if (actualMsg.contains(expectedMsg)){
            System.out.println("test passed");
        }else {
            System.out.println("expected : "+ expectedMsg);
            System.out.println("actual : "+ actualMsg);

            System.out.println("Test Fail");
        }

        if (driver.getCurrentUrl().contains("/secure")){
            System.out.println("Test 2 passed");
        }

        driver.quit();

    }

    // invalidUsername
    public void invalidUserName(){
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/");
        WebElement formAuth = driver.findElement(By.linkText("Form Authentication"));
        formAuth.click();

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
        if (actualMsg.contains(expectedMsg)){
            System.out.println("test passed");
        }else {
            System.out.println("expected : "+ expectedMsg);
            System.out.println("actual : "+ actualMsg);

            System.out.println("Test Fail");
        }

        if (!driver.getCurrentUrl().contains("/secure")){
            System.out.println("Test 2 passed");
        }

        driver.quit();


        WebDriver driver1 = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/");
        WebElement formAuth1 = driver.findElement(By.linkText("Form Authentication"));
        formAuth1.click();

        WebElement userByID = driver1.findElement(By.id("username"));
        WebElement userByName = driver1.findElement(By.name("username"));
        System.out.println(userByID.equals(userByName));

        WebElement password1 = driver.findElement(By.id("password"));
        System.out.println(password1.getAttribute("type"));

        WebElement loginButton = driver.findElement(By.className("radius"));
        System.out.println(loginButton.getText().trim());
        System.out.println(driver.findElements(By.tagName("input")).size());
        loginButton.click();
    }

    // invalid Password
    public void invalidPassword(){
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/");
        WebElement formAuth = driver.findElement(By.linkText("Form Authentication"));
        formAuth.click();

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
        if (actualMsg.contains(expectedMsg)){
            System.out.println("test passed");
        }else {
            System.out.println("expected : "+ expectedMsg);
            System.out.println("actual : "+ actualMsg);

            System.out.println("Test Fail");
        }

        if (!driver.getCurrentUrl().contains("/secure")){
            System.out.println("Test 2 passed");
        }

        driver.quit();
    }

    }
