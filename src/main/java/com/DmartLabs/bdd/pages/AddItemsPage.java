package com.DmartLabs.bdd.pages;

import com.DmartLabs.commonutils.Gestures;
import com.DmartLabs.commonutils.QXClient;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.windows.WindowsDriver;
import io.appium.java_client.windows.WindowsElement;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.PageFactory;

public class AddItemsPage {
    private WindowsDriver<WindowsElement> driver = QXClient.getWindowsDriver();

    public AddItemsPage(WindowsDriver<WindowsElement> driver) throws InterruptedException {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        //    initilizeElements();
    }

    QXClient qxClient = new QXClient(driver);
    Gestures gestures = new Gestures(driver);
    private static WindowsElement OpenCashCounterEle;
    private static WindowsElement SAVEEle;
    private static WindowsElement EanEle;

    public void CashCounterInitilizeElements() throws InterruptedException {
        gestures.Setimplicitwait(25);
        try {
            Thread.sleep(2000);
            OpenCashCounterEle = driver.findElementByAccessibilityId(":r6:");
            SAVEEle = driver.findElementByName("SAVE");
        } catch (NoSuchElementException e) {
            Thread.sleep(500);


        }
    }

    public void addCashToCounter(String text) throws InterruptedException {
        Thread.sleep(2000);
        try {
            gestures.clickAndSendtextToWindowsTextField(OpenCashCounterEle, text);
            Thread.sleep(500);
            gestures.clickOnWindowsbutton(SAVEEle);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void EanInitilizeElements() throws InterruptedException {
        gestures.Setimplicitwait(15);
        Thread.sleep(2000);
        EanEle = driver.findElementByAccessibilityId(":ra:");
    }


    public void EnterEanAndClickOnEnter(String text) throws InterruptedException {
        Thread.sleep(500);
        EanEle.clear();
        Thread.sleep(500);
        gestures.clickAndSendtextToWindowsTextField(EanEle, text);
        Thread.sleep(2000);
        //  actions.moveToElement(element).sendKeys(Keys.ENTER).perform();
        gestures.ClickOnEnter(EanEle);
        EanEle.sendKeys(Keys.ENTER);
        gestures.ClickonEnterUsingActionsClass(EanEle);

    }
}
