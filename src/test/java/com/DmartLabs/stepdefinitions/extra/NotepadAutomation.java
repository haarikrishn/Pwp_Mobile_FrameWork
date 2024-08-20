package com.DmartLabs.stepdefinitions.extra;

import com.DmartLabs.stepdefinitions.WinDriverStep;
import io.appium.java_client.windows.WindowsDriver;
import io.appium.java_client.windows.WindowsElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class NotepadAutomation {
    @Test
    public void notepadAuto() {
        // Desired capabilities for the WinAppDriver session
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Windows");
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "WindowsPC");

        //caps.setCapability("app", "notepad.exe");
        //  caps.setCapability("app", "onepos.exe");
        caps.setCapability("app", "C:\\Users\\Labs User's\\Downloads\\onepos.exe");

        WindowsDriver<WindowsElement> driver = null;


        caps.setCapability("ms:waitForAppLaunch", "10");

        WinDriverStep.start();
        caps.setCapability("ms:waitForAppLaunch", "25");
        //   appCapabilities.SetCapability("appWorkingDir", MyApplicationDirectory);
        caps.setCapability("appWorkingDir", "C:\\Users\\Labs User's\\Downloads");
        try {
            // Set up the WinAppDriver connection
            driver = new WindowsDriver<WindowsElement>(new URL("http://127.0.0.1:4723"), caps);

            // Implicit wait for elements to be available
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

            // Find the text area in Notepad and input some text
            WindowsElement textArea = driver.findElementByClassName("Edit");
            textArea.sendKeys("Hello, this is a test with WinAppDriver!");

            // Open the File menu and click on Save As
            WindowsElement menu = driver.findElementByName("File");
            menu.click();

            WindowsElement saveAs = driver.findElementByName("Save As");
            saveAs.click();

            // Wait for Save As dialog to open
            Thread.sleep(2000);

            // Input a file name and save the file
            WindowsElement fileNameInput = driver.findElementByClassName("Edit");
            fileNameInput.sendKeys("TestFile.txt");

            WindowsElement saveButton = driver.findElementByName("Save");
            saveButton.click();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            // Close the driver
            if (driver != null) {
                driver.quit();

            }
        }
    }

    @Test
    public void notepad2() {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Windows");
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "WindowsPC");
        caps.setCapability("app", "C:\\Users\\Labs User's\\Downloads\\onepos.exe");

        // Adjust the wait time if necessary
        caps.setCapability("ms:waitForAppLaunch", "25");

        WindowsDriver<WindowsElement> driver = null;

        try {
            // Set up the WinAppDriver connection
            driver = new WindowsDriver<WindowsElement>(new URL("http://127.0.0.1:4723"), caps);

            // Implicit wait for elements to be available
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

            // Find the text area and input some text
            WindowsElement textArea = driver.findElementByClassName("Edit");
            textArea.sendKeys("Hello, this is a test with WinAppDriver!");

            // Open the File menu and click on Save As
            WindowsElement menu = driver.findElementByName("File");
            menu.click();

            WindowsElement saveAs = driver.findElementByName("Save As");
            saveAs.click();

            // Wait for Save As dialog to open
            Thread.sleep(2000);

            // Input a file name and save the file
            WindowsElement fileNameInput = driver.findElementByClassName("Edit");
            fileNameInput.sendKeys("TestFile.txt");

            WindowsElement saveButton = driver.findElementByName("Save");
            saveButton.click();

        } catch (MalformedURLException e) {
            System.err.println("Malformed URL Exception: " + e.getMessage());
            e.printStackTrace();
        } catch (InterruptedException e) {
            System.err.println("Interrupted Exception: " + e.getMessage());
            e.printStackTrace();
        } finally {
            // Close the driver
            if (driver != null) {
                driver.quit();
            }
        }
    }

}


