package com.herokuapp.tests;

import com.herokuapp.pages.HomePage;
import com.herokuapp.pages.NestedFramesPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class NestedFramesTests extends TestBase1{

    @BeforeMethod
    public void precondition() {
        new HomePage(driver).getNestedFrames();
    }

    @Test
    public void framesTest() {
        new NestedFramesPage(driver).getListOfFrames();
    }

    @Test
    public void switchToFrameByIndexTest() {
        new NestedFramesPage(driver).switchToFrameByIndex(1)
                .verifyFrameText("BOTTOM");
    }

    @Test
    public void switchToChildFrameTest() {
        new NestedFramesPage(driver).switchToChildFrame(2)
                .verifyFrameText("RIGHT");
    }

}
