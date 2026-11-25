package tests.DynamicPackage;

import baseTest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DynamicControlsTest extends BaseTest {

    @Test
    public void removeCheckboxTest(){
        dynamicControlsPage = mainHeruPage.goToDynamicControlsPage();
        Assert.assertTrue(dynamicControlsPage.isCheckboxPresent());
        dynamicControlsPage.removeCheckbox();
        Assert.assertFalse(dynamicControlsPage.isCheckboxPresent() ,"Checkbox should be removed");
        Assert.assertTrue(dynamicControlsPage.getMessage().contains("It's gone!"));
    }

    @Test
    public void addCheckboxAfterRemovingTest(){
        dynamicControlsPage = mainHeruPage.goToDynamicControlsPage();
        dynamicControlsPage.removeCheckbox();
        Assert.assertFalse(dynamicControlsPage.isCheckboxPresent(),"Check box present should be hidden");
        dynamicControlsPage.addCheckbox();
        Assert.assertTrue(dynamicControlsPage.isCheckboxPresent());
        Assert.assertTrue(dynamicControlsPage.getMessage().contains("It's back!"));
    }

    @Test
    public void enableInputAndTypeTextTest(){
        dynamicControlsPage = mainHeruPage.goToDynamicControlsPage();
        Assert.assertFalse(dynamicControlsPage.isInputEnabled());
        dynamicControlsPage.enableInput();
        Assert.assertTrue(dynamicControlsPage.isInputEnabled());
        dynamicControlsPage.typeText("Helal From Lazy Group");
        Assert.assertEquals(dynamicControlsPage.getText() , "Helal From Lazy Group" , "Text should be Helal From Lazy Group");
    }








}
