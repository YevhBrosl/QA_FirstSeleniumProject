package com.herokuapp.tests;

import com.herokuapp.pages.AddRemoveElementsPage;
import com.herokuapp.pages.HomePage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddRemoveElementsTest extends TestBase1{

    @BeforeMethod
    public void precondition() {
        new HomePage(driver).getAddRemoveElements();
    }

//    @Test
//    public void addRemoveElementWithKeyboardEventTest() {
//        new AddRemoveElementsPage(driver).addRemoveElementWithKeyboardEvent()
//                .verifyElementIsDeleted();
//    }

    @Test
    public void addElementsTest() {
        new AddRemoveElementsPage(driver).addElements()
                .verifyAddElements();
    }

    @Test(expectedExceptions = AssertionError.class)
    public void removeElementsTest() {
        new AddRemoveElementsPage(driver).removeElements()
                .verifyRemoveElements();
    }
}
