package tests;

import baseTest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckboxTest extends BaseTest {

    @Test
    public void validateCheckboxesDefaultState(){
        checkboxPage=mainHeruPage.goToCheckboxesPage();
        Assert.assertFalse(checkboxPage.getCheckboxNumber(1).isSelected());
        Assert.assertTrue(checkboxPage.getCheckboxNumber(2).isSelected());
    }
}
