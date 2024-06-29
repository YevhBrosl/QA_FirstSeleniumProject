package com.herokuapp.tests;

import com.herokuapp.pages.DragAndDropPage;
import com.herokuapp.pages.HomePage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DragAndDropTest extends TestBase1 {

    @BeforeMethod
    public void precondition() {
        new HomePage(driver).getDragAndDrop();
    }

    @Test
    public void swapShapesWithDragAndDropTest() {
        new DragAndDropPage(driver).swapShapesWithDragAndDrop()
                .verifySwap("B");
    }

    @Test
    public void swapShapesWithDragAndDropByTest() {
        new DragAndDropPage(driver).swapShapesWithDragAndDropBy()
                .verifySwap("B");
    }
}
