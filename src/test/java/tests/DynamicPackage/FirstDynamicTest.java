package tests.DynamicPackage;

import baseTest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class FirstDynamicTest extends BaseTest {
    @Test
    public void validateExampleOnePage()  {
        SoftAssert softAssert = new SoftAssert();
        dynamicLoadingPage = mainHeruPage.goToDynamicLoadingPage();
        Assert.assertEquals(dynamicLoadingPage.getActualTitle(), dynamicLoadingPage.getExpectedTitle());
        firstDynamicPage = dynamicLoadingPage.clickOnFirstExample();
        Assert.assertEquals(firstDynamicPage.getTitleOfPage(), firstDynamicPage.getExpectedTitle());
        firstDynamicPage.clickStartButton();
        softAssert.assertEquals(firstDynamicPage.getActualFinishText(), firstDynamicPage.getExpectedFinishText());
        System.out.println("Hello After Soft assert");
        softAssert.assertAll();

    }
}
