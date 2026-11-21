package baseTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.CheckboxPage;
import pages.MainHeruPage;
import pages.formPackage.FormAuthenticationPage;
import pages.formPackage.SecureAreaPage;

public class BaseTest {
    protected WebDriver driver;

    protected MainHeruPage mainHeruPage;
    protected FormAuthenticationPage formAuthenticationPage;
    protected SecureAreaPage secureAreaPage;
    protected CheckboxPage checkboxPage;

    @BeforeClass
    public void setUp() {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
         mainHeruPage = new MainHeruPage(driver);
    }
    @BeforeMethod
    public void navigateToBaseUrl() {
        driver.get("https://the-internet.herokuapp.com/");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }



}
