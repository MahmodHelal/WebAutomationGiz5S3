package tests.DynamicPackage;

import baseTest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SecondDynamicTest extends BaseTest {
    @Test
    public void validateExampleOnePage()  {
        SoftAssert softAssert = new SoftAssert();
        dynamicLoadingPage = mainHeruPage.goToDynamicLoadingPage();
        Assert.assertEquals(dynamicLoadingPage.getActualTitle(), dynamicLoadingPage.getExpectedTitle());
        secondDynamicPage = dynamicLoadingPage.clickOnSecondExample();
        Assert.assertEquals(secondDynamicPage.getTitleOfPage(), secondDynamicPage.getExpectedTitle());
        secondDynamicPage.clickStartButton();
        softAssert.assertEquals(secondDynamicPage.getActualFinishText(), secondDynamicPage.getExpectedFinishText());
        System.out.println("Hello After Soft assert");
        softAssert.assertAll();

    }
}
