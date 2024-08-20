package com.DmartLabs.bdd.pages;

import com.DmartLabs.commonutils.ExtentReportManager;
import com.DmartLabs.commonutils.Gestures;
import com.DmartLabs.commonutils.QXClient;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.windows.WindowsDriver;
import io.appium.java_client.windows.WindowsElement;
import io.cucumber.datatable.DataTable;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Multiple_PaymentPage {


    private WindowsDriver<WindowsElement> driver = QXClient.getWindowsDriver();
    QXClient qxClient = new QXClient(driver);
    Gestures gestures = new Gestures(driver);

    public Multiple_PaymentPage(WindowsDriver<WindowsElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    private static WindowsElement checkoutEle;
    private static WindowsElement CashEle;
    private static WindowsElement OkEle;
    private static WindowsElement newCtrl;
    private static WindowsElement cardEle;
    private static WindowsElement ChequeEle;
    private static WindowsElement UPIEle;
    private static WindowsElement CANCELEle;
    private static WindowsElement YESEle;

    public void initilizePaymentElements() throws InterruptedException {
        gestures.Setimplicitwait(15);
        Thread.sleep(5000);
        checkoutEle = driver.findElementByName("CHECK OUT");
        Thread.sleep(500);
        ExtentReportManager.logInfoDetails("checkoutEle is  -"+checkoutEle);
        gestures.clickOnWindowsbutton(checkoutEle);
        Thread.sleep(500);
    }

    public void initilizeCashelements() throws InterruptedException {
        gestures.Setimplicitwait(3);
        Set<String> windowHandles = driver.getWindowHandles();
        System.out.println(windowHandles);
        Thread.sleep(4000);

        try {
            CashEle = driver.findElementByName("Cash (Ctrl+1)");
            ExtentReportManager.logInfoDetails("CashEle is  -"+CashEle);

        } catch (NoSuchElementException e2) {
            Thread.sleep(1000);
            CashEle = driver.findElementByAccessibilityId("list-item-btn-pd-payment-type0");
        }
        try {
            cardEle = driver.findElementByName("Card (Credit / Debit) (Ctrl + 2)");
        } catch (Exception e) {
            cardEle = driver.findElementByAccessibilityId("list-item-btn-pd-payment-type1");
            ExtentReportManager.logInfoDetails("cardEle is  -"+cardEle);
        }
        try {

            ChequeEle = driver.findElementByName("Cheque (Ctrl + 3)");
            ExtentReportManager.logInfoDetails("ChequeEle is  -"+ChequeEle);
        } catch (Exception e) {
            ChequeEle = driver.findElementByAccessibilityId("list-item-btn-pd-payment-type2");
        }
        try {

            UPIEle = driver.findElementByName("UPI (Ctrl + 5)");
            ExtentReportManager.logInfoDetails("UPIEle is  -"+UPIEle);
        } catch (Exception e) {
            UPIEle = driver.findElementByAccessibilityId("list-item-btn-pd-payment-type4");
        }


    }


    public static List<String> PaymentTypeAl = new ArrayList<>();

    public List<String> AddAllPaymentsType(DataTable dataTable) {
        List<Map<String, String>> PaymentTypesDT = dataTable.asMaps();
        for (int k = 0; k < PaymentTypesDT.size(); k++) {
            String paymentValue = PaymentTypesDT.get(k).get("PaymentType");
            PaymentTypeAl.add(paymentValue);
        }
        ExtentReportManager.logInfoDetails("PaymentTypeAl is - "+PaymentTypeAl);
        return PaymentTypeAl;
    }

    // Cash Card Cheque Upi
    public void AddPaymentTypeAndFinishThepayment(String PaymentType) throws InterruptedException {
        Thread.sleep(500);
        initilizeCashelements();

        for (int i = 0; i < PaymentTypeAl.size(); i++) {

            // String paymentString = PaymentTypeAl.get(i);
            Thread.sleep(500);
            if ("Cash".equals(PaymentType)) {
                //cash
                gestures.clickOnWindowsbutton(CashEle);
                OkEle = driver.findElementByName("OK");
                gestures.clickOnWindowsbutton(OkEle);
                ExtentReportManager.logInfoDetails("PaymentType is - "+"cash");
                break;
            } else if ("Card".equals(PaymentType)) {
                //card
                gestures.clickOnWindowsbutton(cardEle);
                OkEle = driver.findElementByName("OK");
                Thread.sleep(4500);
                OkEle = driver.findElementByName("OK");
                Thread.sleep(1000);
                gestures.clickOnWindowsbutton(OkEle);
                Thread.sleep(200);
                ExtentReportManager.logInfoDetails("PaymentType is - "+"Card");
                try {
                    CANCELEle = driver.findElementByName("CANCEL");
                } catch (NoSuchElementException e) {
                    Thread.sleep(200);
                    try {
                        Thread.sleep(2000);
                        OkEle = driver.findElementByName("OK");
                        gestures.clickOnWindowsbutton(OkEle);
                        Thread.sleep(200);
                        CANCELEle = driver.findElementByName("CANCEL");
                        Thread.sleep(100);
                        gestures.clickOnWindowsbutton(CANCELEle);
                        YESEle = driver.findElementByName("YES");
                        Thread.sleep(200);
                        gestures.clickOnWindowsbutton(YESEle);
                    } catch (NoSuchElementException e3) {
                        Thread.sleep(1000);
                        gestures.clickOnWindowsbutton(OkEle);
                        Thread.sleep(200);
                        CANCELEle = driver.findElementByName("CANCEL");
                        Thread.sleep(100);
                        gestures.clickOnWindowsbutton(CANCELEle);
                        YESEle = driver.findElementByName("YES");
                        Thread.sleep(200);
                        gestures.clickOnWindowsbutton(YESEle);
                    }
                }
//                Thread.sleep(200);
//                YESEle = driver.findElementByName("YES");
//                Thread.sleep(200);
//                gestures.clickOnWindowsbutton(YESEle);
                break;
            } else if ("Cheque".equals(PaymentType)) {
                //cheque
                gestures.clickOnWindowsbutton(ChequeEle);
                OkEle = driver.findElementByName("OK");
                gestures.clickOnWindowsbutton(OkEle);
                ExtentReportManager.logInfoDetails("PaymentType is - "+"Cheque");
                break;
            } else if ("Upi".equals(PaymentType)) {
                //Upi
                gestures.clickOnWindowsbutton(UPIEle);
                OkEle = driver.findElementByName("OK");
                Thread.sleep(4500);
                OkEle = driver.findElementByName("OK");
                Thread.sleep(500);
                gestures.clickOnWindowsbutton(OkEle);
                Thread.sleep(1000);
                ExtentReportManager.logInfoDetails("PaymentType is - "+"Upi");
                try {
                    CANCELEle = driver.findElementByName("CANCEL");
                } catch (NoSuchElementException e1) {
                    Thread.sleep(200);
                    try {
                        Thread.sleep(2000);
                        OkEle = driver.findElementByName("OK");
                        gestures.clickOnWindowsbutton(OkEle);
                        Thread.sleep(200);
                        CANCELEle = driver.findElementByName("CANCEL");
                        Thread.sleep(100);
                        gestures.clickOnWindowsbutton(CANCELEle);
                        YESEle = driver.findElementByName("YES");
                        Thread.sleep(200);
                        gestures.clickOnWindowsbutton(YESEle);
                    } catch (NoSuchElementException e4) {
                        Thread.sleep(1000);
                        gestures.clickOnWindowsbutton(OkEle);
                        Thread.sleep(200);
                        CANCELEle = driver.findElementByName("CANCEL");
                        Thread.sleep(100);
                        gestures.clickOnWindowsbutton(CANCELEle);
                        Thread.sleep(200);
                        YESEle = driver.findElementByName("YES");
                        Thread.sleep(200);
                        gestures.clickOnWindowsbutton(YESEle);
                    }
                }
//                Thread.sleep(200);
//                YESEle = driver.findElementByName("YES");
//                Thread.sleep(200);
//                gestures.clickOnWindowsbutton(YESEle);
                break;
            }


        }


    }

    //"NEW (CTRL + N)"
    public void NewInititlize() throws InterruptedException {
        gestures.Setimplicitwait(15);
        Thread.sleep(500);
        try {
            newCtrl = driver.findElementByName("NEW (CTRL + N)");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void clickOnNew() throws InterruptedException {
        try {
            NewInititlize();
            gestures.clickOnWindowsbutton(newCtrl);
        } catch (Exception e) {
            Thread.sleep(100);
        }


    }


}
