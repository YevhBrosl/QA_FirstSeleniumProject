package com.herokuapp.tests;

import com.herokuapp.pages.DropdownPage;
import com.herokuapp.pages.HomePage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DropdownTest extends TestBase1{

    @BeforeMethod
    public void precondition() {
        new HomePage(driver).getDropdown();
    }

    @Test
    public void selectOptionTest() {
        new DropdownPage(driver).selectOption("Option 1");
    }
}
