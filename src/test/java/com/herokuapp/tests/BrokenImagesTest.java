package com.herokuapp.tests;

import com.herokuapp.pages.BrokenImagesPage;
import com.herokuapp.pages.HomePage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BrokenImagesTest extends TestBase1{

    @BeforeMethod
    public void precondition() {
        new HomePage(driver).getBrokenImages();
    }

    @Test
    public void checkBrokenImagesTest() {
        new BrokenImagesPage(driver).checkBrokenImages();
    }

}
