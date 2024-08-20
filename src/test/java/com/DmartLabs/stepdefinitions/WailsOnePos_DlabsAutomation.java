package com.DmartLabs.stepdefinitions;

import gherkin.lexer.Th;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.windows.WindowsDriver;
import io.appium.java_client.windows.WindowsElement;
import org.apache.poi.ss.formula.functions.T;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class WailsOnePos_DlabsAutomation {




    @Test
    public void OnePosAuto11() throws InterruptedException, MalformedURLException {
        // Desired capabilities for the WinAppDriver session
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Windows");
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "WindowsPC");

        caps.setCapability("app", "C:\\Users\\Labs User's\\Downloads\\wails_final_onepos\\wails_final_onepos.exe");
        //C:\\Users\\Labs User's\\Downloads\\onepos.exe"
        WindowsDriver<WindowsElement> driver = null;
        caps.setCapability("ms:waitForAppLaunch", "8");


//        try {

        driver = new WindowsDriver<WindowsElement>(new URL("http://127.0.0.1:4723"), caps);
        Actions actions = new Actions(driver);

        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        Thread.sleep(1000);


        WindowsElement employeeIdField = driver.findElementByAccessibilityId("login-employee-id");
        WindowsElement passwordField = driver.findElementByAccessibilityId("login-employee-password");
        WindowsElement enter = driver.findElementByName("ENTER");

        actions.click(employeeIdField).sendKeys("1439").build().perform();
        Thread.sleep(500);
        actions.click(passwordField).sendKeys("1234").build().perform();
        Thread.sleep(500);
        actions.click(enter).build().perform();

        Thread.sleep(500);
        WindowsElement EanEle;
        try {
            WindowsElement OpenCashCounterEle = driver.findElementByAccessibilityId(":r6:");

            Thread.sleep(500);
            actions.click(OpenCashCounterEle).click().sendKeys("1234").build().perform();

            Thread.sleep(500);
            WindowsElement SAVEEle = driver.findElementByName("SAVE");
            actions.click(SAVEEle).click().build().perform();
            Thread.sleep(500);

            EanEle = driver.findElementByAccessibilityId(":ra:");
            actions.click(EanEle).sendKeys("1000004883").build().perform();
            Thread.sleep(500);
            EanEle.sendKeys(Keys.ENTER);
            EanEle.clear();
            Thread.sleep(500);
            actions.click(EanEle).sendKeys("8903363007735").build().perform();
            Thread.sleep(500);
            EanEle.sendKeys(Keys.ENTER);
            EanEle.clear();

        } catch (NoSuchElementException e) {
            try {
                EanEle = driver.findElementByAccessibilityId(":ra:");
                actions.click(EanEle).sendKeys("1000004883").build().perform();
                Thread.sleep(500);
                EanEle.sendKeys(Keys.ENTER);
                EanEle.clear();
                Thread.sleep(500);
                actions.click(EanEle).sendKeys("8903363007735").build().perform();
                Thread.sleep(500);
                EanEle.sendKeys(Keys.ENTER);
                EanEle.clear();
            } catch (Exception e1) {
                EanEle = driver.findElementByAccessibilityId(":r8:");
                actions.click(EanEle).sendKeys("1000004883").build().perform();
                Thread.sleep(500);
                EanEle.sendKeys(Keys.ENTER);
                EanEle.clear();
                Thread.sleep(500);
                actions.click(EanEle).sendKeys("8903363007735").build().perform();
                Thread.sleep(500);
                EanEle.sendKeys(Keys.ENTER);
                EanEle.clear();
            }
            WindowsElement checkoutEle = driver.findElementByName("CHECK OUT");
            actions.click(checkoutEle).build().perform();
            Thread.sleep(1000);
            try {
                WindowsElement CashEle = driver.findElementByName("Cash (Ctrl+1)");
                actions.click(CashEle).build().perform();
                Thread.sleep(500);
            } catch (NoSuchElementException e2) {
                WindowsElement CashEle = driver.findElementByAccessibilityId("list-item-btn-pd-payment-type0");
                actions.click(CashEle).build().perform();
                Thread.sleep(1000);
            }

            WindowsElement OkEle = driver.findElementByName("OK");
            actions.click(OkEle).build().perform();
            Thread.sleep(500);
        }
        if (driver != null) {
            Thread.sleep(1000);
            //   driver.quit();

        }
    }





    @Test
    public void OnePosAuto() throws InterruptedException, MalformedURLException {
        // Desired capabilities for the WinAppDriver session
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Windows");
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "WindowsPC");

        caps.setCapability("app", "C:\\Users\\Labs User's\\Downloads\\wails_final_onepos\\wails_final_onepos.exe");
        //C:\\Users\\Labs User's\\Downloads\\onepos.exe"
        WindowsDriver<WindowsElement> driver = null;
        caps.setCapability("ms:waitForAppLaunch", "8");


//        try {

        driver = new WindowsDriver<WindowsElement>(new URL("http://127.0.0.1:4723"), caps);
        Actions actions = new Actions(driver);

        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        Thread.sleep(1000);


        WindowsElement employeeIdField = driver.findElementByAccessibilityId("login-employee-id");
        WindowsElement passwordField = driver.findElementByAccessibilityId("login-employee-password");
        WindowsElement enter = driver.findElementByName("ENTER");

        actions.click(employeeIdField).sendKeys("1439").build().perform();
        Thread.sleep(500);
        actions.click(passwordField).sendKeys("1234").build().perform();
        Thread.sleep(500);
        actions.click(enter).build().perform();

        Thread.sleep(500);
        WindowsElement EanEle;
        try {
            WindowsElement OpenCashCounterEle = driver.findElementByAccessibilityId(":r6:");

            Thread.sleep(500);
            actions.click(OpenCashCounterEle).click().sendKeys("1234").build().perform();

            Thread.sleep(500);
            WindowsElement SAVEEle = driver.findElementByName("SAVE");
            actions.click(SAVEEle).click().build().perform();
            Thread.sleep(500);
        } catch (NoSuchElementException e) {
            try {
                EanEle = driver.findElementByAccessibilityId(":ra:");
                actions.click(EanEle).sendKeys("1000004883").build().perform();
                Thread.sleep(500);
                EanEle.sendKeys(Keys.ENTER);
                EanEle.clear();
                Thread.sleep(500);
                actions.click(EanEle).sendKeys("8903363007735").build().perform();
                Thread.sleep(500);
                EanEle.sendKeys(Keys.ENTER);
                EanEle.clear();
            } catch (Exception e1) {
                EanEle = driver.findElementByAccessibilityId(":r8:");
                actions.click(EanEle).sendKeys("1000004883").build().perform();
                Thread.sleep(500);
                EanEle.sendKeys(Keys.ENTER);
                EanEle.clear();
                Thread.sleep(500);
                actions.click(EanEle).sendKeys("8903363007735").build().perform();
                Thread.sleep(500);
                EanEle.sendKeys(Keys.ENTER);
                EanEle.clear();
            }
            WindowsElement checkoutEle = driver.findElementByName("CHECK OUT");
            actions.click(checkoutEle).build().perform();
            Thread.sleep(1000);
            try {
                WindowsElement CashEle = driver.findElementByName("Cash (Ctrl+1)");
                actions.click(CashEle).build().perform();
                Thread.sleep(500);
            } catch (NoSuchElementException e2) {
                WindowsElement CashEle = driver.findElementByAccessibilityId("list-item-btn-pd-payment-type0");
                actions.click(CashEle).build().perform();
                Thread.sleep(1000);
            }

            WindowsElement OkEle = driver.findElementByName("OK");
            actions.click(OkEle).build().perform();
            Thread.sleep(500);
        }
        if (driver != null) {
            Thread.sleep(1000);
            //   driver.quit();

        }
    }
























    //================================================================================================================================

    @Test
    public void OnePosAuto1() throws InterruptedException, MalformedURLException {
        // Desired capabilities for the WinAppDriver session
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Windows");
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "WindowsPC");

        caps.setCapability("app", "C:\\Users\\Labs User's\\Downloads\\wails_final_onepos\\wails_final_onepos.exe");
        //C:\\Users\\Labs User's\\Downloads\\onepos.exe"
        WindowsDriver<WindowsElement> driver = null;
        caps.setCapability("ms:waitForAppLaunch", "8");


//        try {

        driver = new WindowsDriver<WindowsElement>(new URL("http://127.0.0.1:4723"), caps);
        Actions actions = new Actions(driver);

        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        Thread.sleep(1000);


        WindowsElement employeeIdField = driver.findElementByAccessibilityId("login-employee-id");
        WindowsElement passwordField = driver.findElementByAccessibilityId("login-employee-password");
        WindowsElement enter = driver.findElementByName("ENTER");

        actions.click(employeeIdField).sendKeys("1439").build().perform();
        Thread.sleep(500);
        actions.click(passwordField).sendKeys("1234").build().perform();
        Thread.sleep(500);
        actions.click(enter).build().perform();

        Thread.sleep(500);
        WindowsElement EanEle;
        try {
            WindowsElement OpenCashCounterEle = driver.findElementByAccessibilityId(":r6:");

            Thread.sleep(500);
            actions.click(OpenCashCounterEle).click().sendKeys("1234").build().perform();

            Thread.sleep(500);
            WindowsElement SAVEEle = driver.findElementByName("SAVE");
            actions.click(SAVEEle).click().build().perform();
            Thread.sleep(500);
        } catch (NoSuchElementException e) {
            try {
                EanEle = driver.findElementByAccessibilityId(":ra:");
                actions.click(EanEle).sendKeys("1000004883").build().perform();
                Thread.sleep(500);
                EanEle.sendKeys(Keys.ENTER);
                EanEle.clear();
                Thread.sleep(500);
                actions.click(EanEle).sendKeys("8903363007735").build().perform();
                Thread.sleep(500);
                EanEle.sendKeys(Keys.ENTER);
                EanEle.clear();
            } catch (Exception e1) {
                EanEle = driver.findElementByAccessibilityId(":r8:");
                actions.click(EanEle).sendKeys("1000004883").build().perform();
                Thread.sleep(500);
                EanEle.sendKeys(Keys.ENTER);
                EanEle.clear();
                Thread.sleep(500);
                actions.click(EanEle).sendKeys("8903363007735").build().perform();
                Thread.sleep(500);
                EanEle.sendKeys(Keys.ENTER);
                EanEle.clear();
            }
            WindowsElement checkoutEle = driver.findElementByName("CHECK OUT");
            actions.click(checkoutEle).build().perform();
            Thread.sleep(1000);
            try {
                WindowsElement CashEle = driver.findElementByName("Cash (Ctrl+1)");
                actions.click(CashEle).build().perform();
                Thread.sleep(500);
            } catch (NoSuchElementException e2) {
                WindowsElement CashEle = driver.findElementByAccessibilityId("list-item-btn-pd-payment-type0");
                actions.click(CashEle).build().perform();
                Thread.sleep(1000);
            }

            WindowsElement OkEle = driver.findElementByName("OK");
            actions.click(OkEle).build().perform();
            Thread.sleep(500);

            //    WindowsElement NewEle = driver.findElementByName("NEW (CTRL+N)");
            //   actions.click(NewEle).build().perform();
            //   Thread.sleep(500);


        }
//        WindowsElement EanEle = driver.findElementByAccessibilityId(":r8:");
//        actions.click(EanEle).sendKeys("1000004883").build().perform();
//        Thread.sleep(500);
//        EanEle.sendKeys(Keys.ENTER);
//        EanEle.clear();
//        actions.click(EanEle).sendKeys("8903363007735").build().perform();
//        Thread.sleep(500);
//        EanEle.sendKeys(Keys.ENTER);
//        EanEle.clear();

        //==========================================================================================================
//            WindowsElement username = driver.findElementByName("Employee ID *");
//           // actions.click(username).perform();
//          //  username.click();
//            driver.switchTo().activeElement().sendKeys("hari");
//           // actions.sendKeys("hari").perform();
//            username.sendKeys("hari");
//            Thread.sleep(5000);
//            WindowsElement password = driver.findElementByName("Password *");
//            actions.click(password).perform();
//       //     password.click();
//          //  actions.sendKeys("123").perform();
//            password.sendKeys("123");
//            Thread.sleep(10000);
//
//            WindowsElement enter = driver.findElementByName("ENTER");
//          //  actions.click(enter).perform();
//            enter.click();
//            // Thread.sleep(10000);
//            driver.findElementByName("CLEAR");
        //========================================================================================================
//            WindowsElement username = driver.findElementByName("Employee ID *");
//            username.clear(); // Ensure the field is cleared before typing
//            username.sendKeys("hari"); // Send keys to the username field
//
//            Thread.sleep(5000);
//            WindowsElement password = driver.findElementByName("Password *");
//            password.clear(); // Ensure the field is cleared before typing
//            password.sendKeys("123"); // Send keys to the password field
//
//            Thread.sleep(5000);
//            WindowsElement enterButton = driver.findElementByName("ENTER");
//            enterButton.click();
//
//
//            Thread.sleep(5000);

        //===========================================================================
//            WebDriverWait wait = new WebDriverWait(driver, 20);
//            WindowsElement username = driver.findElementByName("Employee ID *");
//            wait.until(ExpectedConditions.elementToBeSelected(username));
//            username.clear();
//            username.sendKeys("hari");
//
//            // Wait and interact with the password field
//
//            WindowsElement password = driver.findElementByName("Password *");
//            wait.until(ExpectedConditions.elementToBeSelected(password));
//            password.clear();
//            password.sendKeys("123");
//
//            WindowsElement enterButton = driver.findElementByName("ENTER");
//            wait.until(ExpectedConditions.elementToBeSelected(enterButton));
//            enterButton.click();


        //===============================================================================
//            WindowsElement username = driver.findElementByName("Employee ID *");
//            if (username.isDisplayed()) {
//                username.clear(); // Ensure the field is cleared before typing
//                username.sendKeys("hari"); // Send keys to the username field
//            } else {
//                System.out.println("username not displayed");
//            }
//
//            Thread.sleep(5000);
//
//            WindowsElement password = driver.findElementByName("Password *");
//            if (password.isDisplayed()) {
//                password.clear(); // Ensure the field is cleared before typing
//                password.sendKeys("123"); // Send keys to the password field
//            } else {
//                System.out.println("password is not displayed");
//            }
//            Thread.sleep(5000);
//            WindowsElement enterButton = driver.findElementByName("ENTER");
//            if (enterButton.isDisplayed()) {
//                enterButton.click();
//            } else {
//                System.out.println("enterButton is not displayed");
//            }
//
//
//            Thread.sleep(5000);

        //==================================================================


//        try {
//
//            WebDriverWait wait = new WebDriverWait(driver, 20);
//            //        driver.switchTo().activeElement().sendKeys("hari");
//            //   WindowsElement employeeIdField =  driver.findElementByXPath("//*[@AutomationId='login-employee-id')]");
//            WindowsElement employeeIdField = driver.findElementByAccessibilityId("login-employee-id");
//            Assert.assertTrue(employeeIdField.isDisplayed());
//            //  employeeIdField.sendKeys("hari");
//            employeeIdField.click();
//            Thread.sleep(5000);
//              employeeIdField.sendKeys("hari");
//            Thread.sleep(1000);
//              actions.click(employeeIdField).sendKeys("hk1").perform();
//            Thread.sleep(1000);
//            employeeIdField.click();
//              driver.switchTo().activeElement().sendKeys("hari");
//
//            WindowsElement employeeIdField1 = driver.findElementByXPath("//Edit[@AutomationId='login-employee-id']");
//
//       if(employeeIdField1.isDisplayed()) {
//
//           wait.until(ExpectedConditions.elementToBeClickable(employeeIdField1));
//           employeeIdField1.sendKeys("hari");
//       }
//       else
//       {
//           System.out.println("employeeIdField1  not dislayed");
//       }
//
//
//
//////Document[@Name='Dmart POS']/descendant::Edit[@AutomationId='login-employee-id']
//            WindowsElement employeeIdField2 = driver.findElementByXPath("//Document[@Name='Dmart POS']/descendant::Edit[@AutomationId='login-employee-id']");
//            employeeIdField2.sendKeys("hari");
//
//
//            WindowsElement username = driver.findElementByName("Employee ID *");
//            wait.until(ExpectedConditions.elementToBeClickable(username));
//            username.clear();
//            username.sendKeys("hari");
//            WindowsElement elementXapth = driver.findElement(By.xpath("//input[@name='login-employee-id']"));
//            elementXapth.sendKeys("hk");
//
//
//        } catch (Exception e) {
//            Thread.sleep(2000);
//            System.out.println(e.getMessage());
//            //     driver.switchTo().activeElement().sendKeys("hari");
////            WindowsElement employeeIdField = driver.findElementByAccessibilityId("login-employee-id");
////            employeeIdField.sendKeys("hari");
//
//
//        }
//        Thread.sleep(7000);
//        WindowsElement passwordField = driver.findElementByAccessibilityId("login-employee-password");
//        passwordField.sendKeys("123");
//        Thread.sleep(2000);
//        WindowsElement enter = driver.findElementByName("ENTER");
//        enter.click();


        //================================================================================
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        } finally {
        if (driver != null) {
            Thread.sleep(1000);
            //   driver.quit();

        }
    }
}


//}


