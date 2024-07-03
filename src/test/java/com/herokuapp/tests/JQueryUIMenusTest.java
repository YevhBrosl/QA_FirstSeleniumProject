package com.herokuapp.tests;

import com.herokuapp.pages.HomePage;
import com.herokuapp.pages.JQueryUIMenusPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JQueryUIMenusTest extends TestBase1 {

    @BeforeMethod
    public void precondition() {
        new HomePage(driver).getJQueryUIMenus();
    }

    @Test
    public void selectSubMenuTest() {
        new JQueryUIMenusPage(driver).selectSubMenu()
                .verifyIsFileDownloaded("C:/Users/Admin/Downloads", "menu*.pdf");
    }


}
