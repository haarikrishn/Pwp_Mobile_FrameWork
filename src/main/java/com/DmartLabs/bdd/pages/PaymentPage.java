package com.DmartLabs.bdd.pages;

import com.DmartLabs.commonutils.Gestures;
import com.DmartLabs.commonutils.QXClient;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.windows.WindowsDriver;
import io.appium.java_client.windows.WindowsElement;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.PageFactory;

import java.util.Set;

public class PaymentPage {


    private WindowsDriver<WindowsElement> driver = QXClient.getWindowsDriver();
    QXClient qxClient = new QXClient(driver);
    Gestures gestures = new Gestures(driver);

    public PaymentPage(WindowsDriver<WindowsElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    private static WindowsElement checkoutEle;
    private static WindowsElement CashEle;
    private static WindowsElement OkEle;
    private static WindowsElement newCtrl;

    public void initilizePaymentElements() throws InterruptedException {
        gestures.Setimplicitwait(15);
        Thread.sleep(5000);
        checkoutEle = driver.findElementByName("CHECK OUT");
        Thread.sleep(500);
        gestures.clickOnWindowsbutton(checkoutEle);
        Thread.sleep(500);
    }

    public void initilizeCashelements() throws InterruptedException {
        gestures.Setimplicitwait(15);
        Set<String> windowHandles = driver.getWindowHandles();
        System.out.println(windowHandles);
        Thread.sleep(5000);
        try {
            CashEle = driver.findElementByName("Cash (Ctrl+1)");

        } catch (NoSuchElementException e2) {
            Thread.sleep(1000);
            CashEle = driver.findElementByAccessibilityId("list-item-btn-pd-payment-type0");
        }


    }


    public void AddPaymentTypeAndFinishThepayment() throws InterruptedException {


        initilizeCashelements();
        gestures.clickOnWindowsbutton(CashEle);
        Thread.sleep(500);

        OkEle = driver.findElementByName("OK");
        gestures.clickOnWindowsbutton(OkEle);

    }

    //"NEW (CTRL + N)"
    public void NewInititlize() throws InterruptedException {
        gestures.Setimplicitwait(15);
        Thread.sleep(1000);
        newCtrl = driver.findElementByName("NEW (CTRL + N)");
    }

    public void clickOnNew() throws InterruptedException {
        NewInititlize();
        gestures.clickOnWindowsbutton(newCtrl);
    }


}
