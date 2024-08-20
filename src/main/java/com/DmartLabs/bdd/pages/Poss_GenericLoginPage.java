package com.DmartLabs.bdd.pages;

import com.DmartLabs.commonutils.Gestures;
import com.DmartLabs.commonutils.QXClient;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.windows.WindowsDriver;
import io.appium.java_client.windows.WindowsElement;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class Poss_GenericLoginPage<actions> {


    private WindowsDriver<WindowsElement> driver;
    private Actions actions;
    private QXClient qxClient;
    private Gestures gestures;

    private WindowsElement employeeIdField;
    private WindowsElement passwordField;
    private WindowsElement enter;

    // Constructor
    public Poss_GenericLoginPage(WindowsDriver<WindowsElement> driver) throws InterruptedException {
        this.driver = driver;
        this.actions = new Actions(driver);
        this.qxClient = new QXClient(driver);
        this.gestures = qxClient.gestures();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);


        initializeElements();
    }

    private void initializeElements() throws InterruptedException {


        // driver.findElementByAccessibilityId()
        // AutomationId:	"login-employee-id"
        gestures.Setimplicitwait(15);
       // Thread.sleep(2000);
        Thread.sleep(1000);
        try {
            employeeIdField = driver.findElementByAccessibilityId("login-employee-id");
            passwordField = driver.findElementByAccessibilityId("login-employee-password");
            enter = driver.findElementByName("ENTER");
        } catch (NoSuchElementException e) {
            Thread.sleep(1000);
            employeeIdField = driver.findElementByAccessibilityId("login-employee-id");
            passwordField = driver.findElementByAccessibilityId("login-employee-password");
            enter = driver.findElementByName("ENTER");
        }
    }


    public void sendUsername_PassWord_Click_Enter(String userName, String password) throws InterruptedException {
        gestures.MaximizeTheScreen(driver);
        employeeIdField.clear();
        gestures.clickAndSendtextToWindowsTextField(employeeIdField, userName);
        Thread.sleep(500);
        passwordField.clear();
        gestures.clickAndSendtextToWindowsTextField(passwordField, password);
        Thread.sleep(500);
        gestures.clickOnWindowsbutton(enter);
    }
}