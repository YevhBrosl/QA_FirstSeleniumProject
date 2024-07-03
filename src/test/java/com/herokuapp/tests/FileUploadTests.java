package com.herokuapp.tests;

import com.herokuapp.pages.FileUploadPage;
import com.herokuapp.pages.HomePage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FileUploadTests extends TestBase1 {

    @BeforeMethod
    public void precondition() {
        new HomePage(driver).getFileUpload();
    }

    @Test
    public void uploadFileWithRobotKeyboardTest() {
        new FileUploadPage(driver).uploadFileWithRobotKeyboard()
                .verifyFileName("A4.txt");
    }

    @Test
    public void uploadFileWithRobotMouseTest() {
        new FileUploadPage(driver).uploadFileWithRobotMouse()
                .verifyFileName("A4.txt");
    }

    @Test
    public void uploadFileWithRobotMouseAndDragDropTest() {
        new FileUploadPage(driver).uploadFileWithRobotMouseAndDragDrop()
                .verifyFileName1("A4.txt");
    }

    @Test
    public void uploadFileTest() {
        new FileUploadPage(driver).uploadFile("C:/Users/Admin/A4.txt")
                .verifyFileName("A4.txt");
    }
}
