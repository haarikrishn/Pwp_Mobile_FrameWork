package com.DmartLabs.stepdefinitions;

import com.DmartLabs.commonutils.*;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.lowagie.text.DocumentException;
import io.appium.java_client.windows.WindowsDriver;
import io.appium.java_client.windows.WindowsElement;
import io.cucumber.java.*;
import org.apache.poi.ss.formula.functions.T;
import org.xhtmlrenderer.pdf.ITextRenderer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;


public class Hooks {

    public static WindowsDriver<WindowsElement> windowsDriver = QXClient.getWindowsDriver();
    public static ExtentTestFactory extentTestFactory;

    public static ExtentReports extentReports;
    public static ExtentTest extentTest;

    public Hooks() {
        extentTestFactory = new ExtentTestFactory();
    }

    @Before
    public void setUp(Scenario scenario) throws Exception {
        // Initialize the driver
        windowsDriver = DriverFactory.getDriver();
        //  this.createHtmlReportFile();
        if (windowsDriver == null) {
            throw new IllegalStateException("WindowsDriver was not initialized.");
        }
        String fileName = ExtentReportManager.getReportNameWithTimeStamp();
        String fullReportPath = System.getProperty("user.dir") + "\\reports\\" + fileName;
        extentReports = ExtentReportManager.createInstance(fullReportPath, "Pos DeskTop Automation Report",
                "Test ExecutionReport");
        configExtenTest(scenario);
    }


    public static void configExtenTest(Scenario scenario) {
        extentTest = extentReports.createTest(scenario.getName().toString());
        ExtentTestFactory.setExtentTest(extentTest);
    }

    @BeforeStep(order = 1)
    public void onBeforeStep() throws IOException {


        extentTest = ExtentTestFactory.getExtentTest();

    }

    @AfterStep(order = 1)

    public void addScreenshot() throws IOException {

    }

    private void convertHtmlToPdf() throws IOException, DocumentException {
        String htmlReportPath = System.getProperty("user.dir") + "\\reports\\" +
                ExtentReportManager.getReportNameWithTimeStamp();
        // Path to the PDF report
        String pdfReportPath = htmlReportPath.replace(".html", ".pdf");

        // Create PDF renderer
        ITextRenderer renderer = new ITextRenderer();
        try (FileInputStream htmlInputStream = new FileInputStream(new File(htmlReportPath))) {
            //  renderer.setDocumentFromInputStream(htmlInputStream, null);
            renderer.setDocument(new File(htmlReportPath));
            renderer.layout();
        }
        // Write the PDF file
        try (FileOutputStream fos = new FileOutputStream(new File(pdfReportPath))) {
            renderer.createPDF(fos);
        }
    }

    @After
    public void tearDown() throws InterruptedException {
        if (windowsDriver != null) {
            try {
                Thread.sleep(1000);

                extentReports.flush();
                try {
                    convertHtmlToPdf();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                Thread.sleep(500);
                windowsDriver.quit();
                Thread.sleep(2000);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {

                WinDriverUtils.stop();
            }
        }
    }
}










    /*
    log4j:WARN See http://logging.apache.org/log4j/1.2/faq.html#noconfig for more info.
java.io.FileNotFoundException: D:\Dmart_Github\poss_desk\Poss\poss\reports\TestReport_2024_08_19_22_47_00.html (The system cannot find the file specified)

    public static WindowsDriver<WindowsElement> windowsDriver = QXClient.getWindowsDriver();


    @Before
    public void setUp() throws Exception {
        // Initialize the driver
        windowsDriver = DriverFactory.getDriver();
        if (windowsDriver == null) {
            throw new IllegalStateException("WindowsDriver was not initialized.");
        }
    }

    @After
    public void tearDown() throws InterruptedException {
        if (windowsDriver != null) {
            try {
                Thread.sleep(1000);
                windowsDriver.quit();
                Thread.sleep(2000);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {

                WinDriverUtils.stop();
            }
        }
    }


}
//===========================================================================================================================
/*
 @Before
    public void setUp() throws Exception {
        //WinDriverUtils.start();
        windowsDriver = DriverFactory.getDriver();

    }

    @After
    public void tearDown() throws InterruptedException {
        if (windowsDriver != null) {
            Thread.sleep(1000);
            windowsDriver.quit();
            Thread.sleep(2000);
           WinDriverUtils.stop();
        }
    }
 */