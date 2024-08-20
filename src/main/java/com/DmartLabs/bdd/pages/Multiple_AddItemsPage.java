package com.DmartLabs.bdd.pages;

import com.DmartLabs.commonutils.ExtentReportManager;
import com.DmartLabs.commonutils.Gestures;
import com.DmartLabs.commonutils.QXClient;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import io.appium.java_client.windows.WindowsDriver;
import io.appium.java_client.windows.WindowsElement;
import io.cucumber.datatable.DataTable;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Multiple_AddItemsPage {
    private WindowsDriver<WindowsElement> driver = QXClient.getWindowsDriver();

    public Multiple_AddItemsPage(WindowsDriver<WindowsElement> driver) throws InterruptedException {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        //    initilizeElements();
    }

    QXClient qxClient = new QXClient(driver);
    Gestures gestures = new Gestures(driver);
    Actions actions = new Actions(driver);
    private static WindowsElement OpenCashCounterEle;
    private static WindowsElement SAVEEle;
    private static WindowsElement EanEle;

    public void CashCounterInitilizeElements() throws InterruptedException {
        gestures.Setimplicitwait(10);
        try {
            Thread.sleep(1500);
            OpenCashCounterEle = driver.findElementByAccessibilityId(":r6:");
            SAVEEle = driver.findElementByName("SAVE");
        } catch (NoSuchElementException e) {
            Thread.sleep(500);
            //  OpenCashCounterEle = driver.findElementByAccessibilityId(":r6:");
            //SAVEEle = driver.findElementByName("SAVE");
            //     break;

        }
    }

    public void addCashToCounter(String text) throws InterruptedException {
        Thread.sleep(1500);
        try {
            gestures.clickAndSendtextToWindowsTextField(OpenCashCounterEle, text);
            Thread.sleep(500);
            gestures.clickOnWindowsbutton(SAVEEle);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void EanInitilizeElements() throws InterruptedException {
        gestures.Setimplicitwait(10);
        Thread.sleep(1000);
        try {
            EanEle = driver.findElementByAccessibilityId(":ra:");
            EanEle = driver.findElement(By.xpath("//*[@ClickablePoint='{x:149 y:177}']"));
            EanEle = driver.findElementByXPath("//*[@ClickablePoint='{x:149 y:177}']");
        } catch (Exception e2) {
            actions.moveByOffset(149, 177).click().sendKeys().perform();
            System.out.println(e2.getMessage());
        }

    }

    public void EanInitilizeElementsUsingDT(String ean, String xaph) throws InterruptedException {
        gestures.Setimplicitwait(10);
        Thread.sleep(500);
        try {
            EanEle = driver.findElementByAccessibilityId(":ra:");

            System.out.println(EanEle.getText() + "===========>ean text");
            ExtentReportManager.logInfoDetails("EanEle is -"+EanEle);
            //  EanEle = driver.findElement(By.xpath("//*[@ClickablePoint='{x:149 y:177}']"));
            // EanEle = driver.findElementByXPath("//*[@ClickablePoint='{x:149 y:177}']");
        } catch (Exception e2) {
//            JavascriptExecutor js = (JavascriptExecutor) driver;
//            js.executeScript("var evt = document.createEvent('MouseEvents');" +
//                    "evt.initMouseEvent('click', true, true, window, 0, 0, 0, " + 149 + ", " + 177 + ", false, false, false, false, 0, null);" +
//                    "document.dispatchEvent(evt);");
//
////            gestures.tocuh(driver, 149, 177);
//            try {
//                actions.moveByOffset(149, 177).click().sendKeys(ean).perform();
//
//            } catch (Exception action) {
//                Thread.sleep(500);
//                actions.click().perform();
//                driver.switchTo().activeElement().sendKeys(ean);
            System.out.println(e2.getMessage() + "e2");
//            }

            GenerateDynamicXpath(xaph);
//            try {
//                EanEle = driver.findElement(By.xpath("//*[@ClassName='MuiInputBase-input MuiOutlinedInput-input MuiInputBase-inputSizeSmall css-1o6z5ng']"));
//            } catch (Exception e) {
//                EanEle = driver.findElement(By.xpath("//*[@AriaRole='textbox']"));
//                try {
//                    EanEle = driver.findElement(By.xpath("//*[@LocalizedControlType='edit']"));
//                } catch (Exception e4) {
//                    EanEle = driver.findElement(By.xpath("//*[@ClickablePoint='{x:149 y:177}']"));
//                } finally {
//                    System.out.println("element not found");
//                }
//            }

        }

    }

    //==========================================================================================================================================
    private static int m = 0;
    List<String> DyanmicXapthList = new ArrayList<>();
    String commaSeperated = "ra,rb,rc,rd,re,rf,rg,rh,ri,rj,rk,rl,rm,rn,ro,rp,rq,rr,rs,rt,ru,rv,rw,rx,ry,rz";
    String commaNumberSeperated = "r11,r12,r13,r14,r15,r16,r17,r18,r19,r20,r21,r22,r23,r24,r25,r26,r27,r28,r29,r30";

    List<String> DyanmicXapthList1 = Arrays.asList(commaSeperated.split(","));
    List<String> DyanmicXapthNumberList = Arrays.asList(commaNumberSeperated.split(","));


    public void GenerateDynamicXpath(String xaph) {
        gestures.Setimplicitwait(2);
        // m=0;
        for (m = m; m < DyanmicXapthList1.size(); ) {
            xaph = DyanmicXapthList1.get(m);
            System.out.println(DyanmicXapthList1.get(m) + "=============>DyanmicXapthList1.get(m)");
            ExtentReportManager.logInfoDetails("DyanmicXapthList1 is -"+DyanmicXapthList1.get(m));
            if (DyanmicXapthList1.size() - 1 == m) {
                //    GenerateNumberDynamicXpath(xaph);

                break;
            }
            try {
                System.out.println(":" + xaph + ":" + "====================>\":+xaph+:\"");
                EanEle = driver.findElementByAccessibilityId(":" + xaph + ":");
                System.out.println(EanEle.getText() + "================>text");
                ExtentReportManager.logInfoDetails("EanEle.getText() is -"+xaph);
                break;
            } catch (Exception e) {
                m++;
                GenerateDynamicXpath(xaph);
            }
        }

        //    m = 0;
    }

    private static int n = 0;

    public void GenerateNumberDynamicXpath(String xaph) {
        gestures.Setimplicitwait(2);
        // m=0;
        for (n = n; n < DyanmicXapthNumberList.size(); ) {
            xaph = DyanmicXapthNumberList.get(n);
            System.out.println(DyanmicXapthNumberList.get(n) + "=============>DyanmicXapthList1.get(m)");
            if (DyanmicXapthNumberList.size() - 1 == n) {
                n = 0;
                //  break;
            }
            try {
                System.out.println(":" + xaph + ":" + "====================>\":+xaph+:\"");
                EanEle = driver.findElementByAccessibilityId(":" + xaph + ":");
                System.out.println(EanEle.getText() + "================>text");
                break;
            } catch (Exception e) {
                n++;
                GenerateNumberDynamicXpath(xaph);
            }
        }

        //    m = 0;
    }

    //==================================================================================================================================================
    public void EnterEanAndClickOnEnter(DataTable dataTable) throws InterruptedException {

        List<Map<String, String>> EanDT = dataTable.asMaps();
        for (int i = 0; i < EanDT.size(); i++) {
            String eanValue = EanDT.get(i).get("eanNumber");
            Thread.sleep(200);
            EanEle.clear();
            Thread.sleep(200);
            gestures.clickAndSendtextToWindowsTextField(EanEle, eanValue);
            Thread.sleep(200);
            //  actions.moveToElement(element).sendKeys(Keys.ENTER).perform();
            gestures.ClickOnEnter(EanEle);
            EanEle.sendKeys(Keys.ENTER);
            gestures.ClickonEnterUsingActionsClass(EanEle);
            Thread.sleep(200);
            EanEle.clear();

        }
    }

    public void EnterEanAndClickOnEnterMultiple(String text) throws InterruptedException {
        try {
            Thread.sleep(500);
            EanEle.clear();
            Thread.sleep(500);
            gestures.clickAndSendtextToWindowsTextField(EanEle, text);
            Thread.sleep(500);
            ExtentReportManager.logInfoDetails("EanEle is  -"+text);
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
}
