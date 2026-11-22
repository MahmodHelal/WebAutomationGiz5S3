package tests;

import baseTest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DropdownTest extends BaseTest {


    @Test
    public void  validateSelectOption() throws InterruptedException {
        dropdownPage = mainHeruPage.goToDropdownPage();
        dropdownPage.selectOptionByText("Option 1");
        Thread.sleep(2000);
        Assert.assertEquals(dropdownPage.getSelectedItem() , "Option 1");


    }



}
