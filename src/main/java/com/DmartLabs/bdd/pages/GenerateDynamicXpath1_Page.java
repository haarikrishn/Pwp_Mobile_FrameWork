package com.DmartLabs.bdd.pages;

import com.DmartLabs.commonutils.Gestures;
import com.DmartLabs.commonutils.QXClient;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.windows.WindowsDriver;
import io.appium.java_client.windows.WindowsElement;
import io.cucumber.datatable.DataTable;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import java.util.*;

public class GenerateDynamicXpath1_Page {
    private WindowsDriver<WindowsElement> driver = QXClient.getWindowsDriver();
    QXClient qxClient = new QXClient(driver);
    Gestures gestures = new Gestures(driver);
    Actions actions = new Actions(driver);

    public GenerateDynamicXpath1_Page(WindowsDriver<WindowsElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    private static WindowsElement OpenCashCounterEle;
    private static WindowsElement SAVEEle;

    //=========================================================================
    public  void CashCounterInitilizeElements() throws InterruptedException {
        gestures.Setimplicitwait(25);
        try {
            Thread.sleep(2000);
            OpenCashCounterEle = driver.findElementByAccessibilityId(":r6:");
            SAVEEle = driver.findElementByName("SAVE");
        } catch (NoSuchElementException e) {
            Thread.sleep(500);


        }
    }


    //===========================================================================================
    private static WindowsElement EanEle;

    private static List<String> DYNAMIC_XPATH_LIST = Arrays.asList(
            "ra", "rb", "rc", "rd", "re", "rf", "rg", "rh", "ri", "rj", "rk", "rl", "rm", "rn", "ro", "rp", "rq", "rr", "rs", "rt", "ru", "rv", "rw", "rx", "ry", "rz"
    );
    private static List<String> DYNAMIC_XPATH_NUMBER_LIST = Arrays.asList(
            "r11", "r12", "r13", "r14", "r15", "r16", "r17", "r18", "r19", "r20", "r21", "r22", "r23", "r24", "r25", "r26", "r27", "r28", "r29", "r30"
    );

    public boolean FindElementById(String xpath) {
        try {
            EanEle = driver.findElementByAccessibilityId(":" + xpath + ":");
            System.out.println(EanEle.getText() + "================>text");
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage() + "element not found");
            return false;
        }
    }


    public  void addCashToCounter(String text) throws InterruptedException {
        Thread.sleep(2000);
        try {
            gestures.clickAndSendtextToWindowsTextField(OpenCashCounterEle, text);
            Thread.sleep(500);
            gestures.clickOnWindowsbutton(SAVEEle);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }


    public void initilizeElementUsingDynamicXpath(String xpath) {
        boolean flag = false;
        for (int i = 0; i < DYNAMIC_XPATH_LIST.size(); i++) {
            xpath = DYNAMIC_XPATH_LIST.get(i);
            if (FindElementById(xpath)) {
                flag = true;
                break;
            }
        }
        if (!flag) {
            for (int j = 0; j < DYNAMIC_XPATH_NUMBER_LIST.size(); j++) {
                xpath = DYNAMIC_XPATH_NUMBER_LIST.get(j);
                if (FindElementById(xpath)) {
                    break;
                }
            }
        }
    }

    public void EanInitilizeElementsUsingPractiseDT(String ean, String xaph) throws InterruptedException {
        gestures.Setimplicitwait(10);
        Thread.sleep(500);
        try {
            EanEle = driver.findElementByAccessibilityId(":ra:");
            System.out.println(EanEle.getText() + "===========>ean text");
        } catch (Exception e2) {

            System.out.println(e2.getMessage() + "e2");
            initilizeElementUsingDynamicXpath(xaph);
        }
    }

    public void EnterEanAndClickOnEnterMultiple(String text) throws InterruptedException {
        try {
            Thread.sleep(500);
            EanEle.clear();
            Thread.sleep(500);
            gestures.clickAndSendtextToWindowsTextField(EanEle, text);
            Thread.sleep(500);
            //  actions.moveToElement(element).sendKeys(Keys.ENTER).perform();


            gestures.ClickOnEnter(EanEle);
            EanEle.sendKeys(Keys.ENTER);
            gestures.ClickonEnterUsingActionsClass(EanEle);
        } catch (Exception e) {
            try {
                actions.moveByOffset(149, 177).click().sendKeys(text).perform();

            } catch (Exception e3) {
                actions.click().perform();
                driver.switchTo().activeElement().sendKeys(text);
                System.out.println(e3.getMessage() + "e3");
            }
        }

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
        gestures.clickOnWindowsbutton(checkoutEle);
        Thread.sleep(500);
    }

    public void initilizeCashelements() throws InterruptedException {
        gestures.Setimplicitwait(5);
        Set<String> windowHandles = driver.getWindowHandles();
        System.out.println(windowHandles);
        Thread.sleep(5000);

        try {
            CashEle = driver.findElementByName("Cash (Ctrl+1)");

        } catch (NoSuchElementException e2) {
            Thread.sleep(1000);
            CashEle = driver.findElementByAccessibilityId("list-item-btn-pd-payment-type0");
        }
        try {
            cardEle = driver.findElementByName("Card (Credit / Debit) (Ctrl + 2)");
        } catch (Exception e) {
            cardEle = driver.findElementByAccessibilityId("list-item-btn-pd-payment-type1");
        }
        try {

            ChequeEle = driver.findElementByName("Cheque (Ctrl + 3)");
        } catch (Exception e) {
            ChequeEle = driver.findElementByAccessibilityId("list-item-btn-pd-payment-type2");
        }
        try {

            UPIEle = driver.findElementByName("UPI (Ctrl + 5)");
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
        return PaymentTypeAl;
    }

    public void AddPaymentTypeAndFinishThepayment(String PaymentType) throws InterruptedException {
        Thread.sleep(500);
        initilizeCashelements();
        for (int i = 0; i < PaymentTypeAl.size(); i++) {

            // String paymentString = PaymentTypeAl.get(i);
            Thread.sleep(500);
            if ("Cash".equals(PaymentType) || "Cheque".equals(PaymentType)) {
                gestures.clickOnWindowsbutton(CashEle);
                OkEle = driver.findElementByName("OK");
                gestures.clickOnWindowsbutton(OkEle);
                break;
            } else if ("Card".equals(PaymentType) || "Upi".equals(PaymentType)) {
                CardOrUpiPayment();
                break;

            }

        }
    }

    public void CardOrUpiPayment() throws InterruptedException {

        gestures.clickOnWindowsbutton(UPIEle);
        OkEle = driver.findElementByName("OK");
        Thread.sleep(4500);
        OkEle = driver.findElementByName("OK");
        Thread.sleep(500);
        gestures.clickOnWindowsbutton(OkEle);
        Thread.sleep(1000);
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


    }

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

//    public static void main(String[] args) {
//        System.out.println("hi");
//    }

