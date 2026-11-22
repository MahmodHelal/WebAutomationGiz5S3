package baseTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.CheckboxPage;
import pages.DropdownPage;
import pages.MainHeruPage;
import pages.formPackage.FormAuthenticationPage;
import pages.formPackage.SecureAreaPage;
import pages.waitingStratefies.DynamicLoadingPage;
import pages.waitingStratefies.FirstDynamicPage;
import pages.waitingStratefies.SecondDynamicPage;

import java.time.Duration;

public class BaseTest {
    protected WebDriver driver;
    protected MainHeruPage mainHeruPage;
    protected FormAuthenticationPage formAuthenticationPage;
    protected SecureAreaPage secureAreaPage;
    protected CheckboxPage checkboxPage;
    protected DropdownPage dropdownPage;
    protected DynamicLoadingPage dynamicLoadingPage;
    protected FirstDynamicPage firstDynamicPage;
    protected SecondDynamicPage secondDynamicPage;

    @BeforeClass
    public void setUp() {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        mainHeruPage = new MainHeruPage(driver);
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
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
