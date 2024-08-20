package com.DmartLabs.stepdefinitions;

import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.windows.WindowsDriver;
import io.appium.java_client.windows.WindowsElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class OnePos_DlabsAutomation {


    //======================================================================================================================
    //one pos


    @Test
    public void OnePosAuto() throws InterruptedException {
        // Desired capabilities for the WinAppDriver session
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Windows");
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "WindowsPC");

        //caps.setCapability("app", "notepad.exe");
        //  caps.setCapability("app", "onepos.exe");
        //C:\Users\Labs User's\Downloads\wails_final_onepos\wails_final_onepos.exe
  //      caps.setCapability("app", "C:\\Users\\Labs User's\\Downloads\\onepos.exe");
        caps.setCapability("app", "C:\\Users\\Labs User's\\Downloads\\wails_final_onepos\\wails_final_onepos.exe");

        WindowsDriver<WindowsElement> driver = null;

        // WinDriver.start();
        caps.setCapability("ms:waitForAppLaunch", "2");

        try {
            // Set up the WinAppDriver connection
            driver = new WindowsDriver<WindowsElement>(new URL("http://127.0.0.1:4723"), caps);

            // Implicit wait for elements to be available
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

            WindowsElement employeeIdField = driver.findElementByAccessibilityId("login-employee-id");

            // Interact with the element
            employeeIdField.sendKeys("12345");

            WindowsElement passwordField = driver.findElementByAccessibilityId("login-employee-password");
            passwordField.sendKeys("123");


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } finally {
            // Close the driver
            if (driver != null) {
                Thread.sleep(2000);
                driver.quit();

            }
        }
    }

    //===================================================================================================================
    //dlabs poc
    @Test
    public void D_labs2() throws InterruptedException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Windows");
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "WindowsPC");
        caps.setCapability("app", "C:\\Users\\Labs User's\\Downloads\\Dlabs_poc.exe");

        // Adjust the wait time if necessary
        caps.setCapability("ms:waitForAppLaunch", "25");

        WindowsDriver<WindowsElement> driver = null;

        try {

            // Set up the WinAppDriver connection
            driver = new WindowsDriver<WindowsElement>(new URL("http://127.0.0.1:4723"), caps);

            // Implicit wait for elements to be available
            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

            // Find the text area and input some text
            //*[@AutomationId='your-automation-id']
            //     WindowsElement employeeIdField1 = driver.findElementByXPath("//*[@AutomationId='name']");
            WindowsElement employeeIdField1 = driver.findElementByAccessibilityId("name");
            employeeIdField1.sendKeys("123");

            //  WindowsElement save = driver.findElementByXPath("//*[@ClassNamee='btn']");
            //  WindowsElement save = driver.findElementByAccessibilityId("btn");
            WindowsElement save = driver.findElementByAccessibilityId("chrome");
            save.click();

        } catch (MalformedURLException e) {
            System.err.println("Malformed URL Exception: " + e.getMessage());
            e.printStackTrace();
        } finally {
            // Close the driver
            if (driver != null) {
                Thread.sleep(2000);
                driver.quit();
            }
        }
    }

    //=============================================================================================================================
    //calucaltor


    @Test
    public void Calucaltor() throws InterruptedException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Windows");
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "WindowsPC");
        caps.setCapability("app", "C:\\Windows\\System32\\calc.exe");

        // Adjust the wait time if necessary
        caps.setCapability("ms:waitForAppLaunch", "25");

        WindowsDriver<WindowsElement> driver = null;

        try {

            // Set up the WinAppDriver connection
            driver = new WindowsDriver<WindowsElement>(new URL("http://127.0.0.1:4723"), caps);

            // Implicit wait for elements to be available
            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

            driver.findElementByAccessibilityId("num1Button").click();

            // Use the Name property for locating the buttons and performing click operation
            driver.findElement(By.name("Plus")).click();
            driver.findElement(By.name("Nine")).click();
            driver.findElement(By.name("Equals")).click();

            driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS); // Adjusted wait time

            // The result should be 10, assert if the result pane does not show 10
            WebElement resultsElement = driver.findElementByAccessibilityId("CalculatorResults");

            String expectedText = "10";

        } catch (MalformedURLException e) {
            System.err.println("Malformed URL Exception: " + e.getMessage());
            e.printStackTrace();
        } finally {
            // Close the driver
            if (driver != null) {
                Thread.sleep(2000);
                driver.quit();
            }
        }
    }
}


