package com.herokuapp.tests;

import com.herokuapp.pages.HomePage;
import com.herokuapp.pages.JQueryUIMenusPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JQueryUIMenusTest extends TestBase1 {

    HomePage home;
    JQueryUIMenusPage jQuery;
    String path = "C:/Users/Admin/Downloads";


    @BeforeMethod
    public void precondition() {
        home = new HomePage(driver);
        jQuery = new JQueryUIMenusPage(driver);
        home.getJQueryUIMenus();
    }

//    @Test
//    public void selectSubMenuTest() {
//        new JQueryUIMenusPage(driver).selectSubMenu()
//                .verifyIsFileDownloaded("C:/Users/Admin/Downloads", "menu*.pdf");
//    }

    @Test
    public void JQueryUIMenusPdfTest() {
        jQuery.hoverEnabled()
                .hoverDownloads()
                .clickPdf()
                .checkFileDownloaded(path, "menu.pdf");
    }

    @Test
    public void JQueryUIMenusCsvTest() {
        jQuery.hoverEnabled()
                .hoverDownloads()
                .clickCsv()
                .checkFileDownloaded(path, "menu.csv");
    }

    @Test
    public void JQueryUIMenusExcelTest() {
        jQuery.hoverEnabled()
                .hoverDownloads()
                .clickExcel()
                .checkFileDownloaded(path, "menu.xls");
    }

    @AfterMethod
    public void postCondition() {
        jQuery.removeDownloadedFile(path, "menu");
    }

}
