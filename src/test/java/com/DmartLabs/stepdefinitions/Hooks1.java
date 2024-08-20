//package com.DmartLabs.stepdefinitions;
//
//import com.DmartLabs.commonutils.*;
//import com.DmartLabs.config.Global;
//import com.aventstack.extentreports.ExtentTest;
//import com.aventstack.extentreports.Status;
//import io.appium.java_client.windows.WindowsDriver;
//import io.appium.java_client.windows.WindowsElement;
//import io.cucumber.java.*;
//import org.apache.commons.io.FileUtils;
//import org.openqa.selenium.OutputType;
//import org.openqa.selenium.TakesScreenshot;
//
//import java.io.File;
//import java.io.IOException;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//
//
//public class Hooks1 {
//    public static WindowsDriver<WindowsElement> windowsDriver = QXClient.getWindowsDriver();
//
//
//    @Before
//    public void setUp() throws Exception {
//        // Initialize the driver
//        windowsDriver = DriverFactory.getDriver();
//        this.createHtmlReportFile();
//        if (windowsDriver == null) {
//            throw new IllegalStateException("WindowsDriver was not initialized.");
//        }
//        QXReport.getTest().log(Status.PASS, "Application Launched Successfully");
//        ExtentTestManager.InitReport();
//    }
//
//
//    private void createHtmlReportFile() {
//        Date date = new Date();
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
//        String reportPath = System.getProperty("user.dir") + File.separator + "reports" + File.separator + "Report_" + dateFormat.format(date);
//        File file = new File(reportPath);
//        file.mkdir();
//        Global.setReportPath(reportPath);
//    }
//
//    @BeforeStep()
//    public void beforeScenarioStart(Scenario scenario) throws IOException {
//        ExtentTest testReport = ExtentTestManager.createTest(scenario.getName());
//             //   GlobalSession.get().getAppiumManager().getDeviceName());
//
//        QXReport.setTestReport(testReport);
//
//
//    }
//
//    @AfterStep(order = 1)
//    public void addScreenshot(Scenario scenario) throws IOException {
//        if (scenario.isFailed()) {
//            File screenshot = ((TakesScreenshot) QXClient.getWindowsDriver().getScreenshotAs(OutputType.FILE);
//            byte[] fileContent = FileUtils.readFileToByteArray(screenshot);
//            scenario.attach(fileContent, "image/png", "screenshot");
//        }
//
//
//    }
//
//    @After
//    public void tearDown() throws InterruptedException {
//        if (windowsDriver != null) {
//            try {
//                Thread.sleep(1000);
//                ExtentManager.getExtent().flush();
//                windowsDriver.quit();
//                Thread.sleep(2000);
//            } catch (Exception e) {
//                e.printStackTrace();
//            } finally {
//
//                WinDriverUtils.stop();
//            }
//        }
//    }
//
//
//}
////===========================================================================================================================
///*
// @Before
//    public void setUp() throws Exception {
//        //WinDriverUtils.start();
//        windowsDriver = DriverFactory.getDriver();
//
//    }
//
//    @After
//    public void tearDown() throws InterruptedException {
//        if (windowsDriver != null) {
//            Thread.sleep(1000);
//            windowsDriver.quit();
//            Thread.sleep(2000);
//           WinDriverUtils.stop();
//        }
//    }
// */