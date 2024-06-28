package com.herokuapp.tests;

import com.herokuapp.pages.HomePage;
import com.herokuapp.pages.HorizontalSliderPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HorizontalSliderTest extends TestBase1{

    @BeforeMethod
    public void precondition() {
        new HomePage(driver).getHorizontalSlider();
    }

    @Test
    public void moveSliderTest() {
        new HorizontalSliderPage(driver).moveSlider()
                .verifySliderValue("5");
    }

}
