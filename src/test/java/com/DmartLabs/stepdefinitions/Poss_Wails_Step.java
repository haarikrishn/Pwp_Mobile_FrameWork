package com.DmartLabs.stepdefinitions;

import com.DmartLabs.bdd.pages.*;
import com.DmartLabs.commonutils.ExcelUtils;
import com.DmartLabs.commonutils.ExtentReportManager;
import com.DmartLabs.commonutils.QXClient;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.windows.WindowsDriver;
import io.appium.java_client.windows.WindowsElement;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class Poss_Wails_Step {


    AddItemsPage addItemsPage = new AddItemsPage(QXClient.getWindowsDriver());
    PaymentPage paymentPage = new PaymentPage(QXClient.getWindowsDriver());
    GenerateDynamicXpath1_Page generateDynamicXpath1_page = new GenerateDynamicXpath1_Page(QXClient.getWindowsDriver());

    public Poss_Wails_Step() throws InterruptedException {
    }

    @And("add required cash to cash counter")
    public void addRequiredCashToCashCounter(DataTable dataTable) throws InterruptedException {

        List<Map<String, String>> openCounterDT = dataTable.asMaps();

        for (int k = 0; k < openCounterDT.size(); k++) {
            String OpenCashcouterBalance = openCounterDT.get(k).get("OpenCashcouterBalance");
            try {
                addItemsPage.CashCounterInitilizeElements();
                addItemsPage.addCashToCounter(OpenCashcouterBalance);

                ExtentReportManager.logInfoDetails("OpenCashcouterBalance is - "+OpenCashcouterBalance);

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    @When("add items to items details page {string}")
    public void addItemsToItemsDetailsPage(String eanNumber) throws InterruptedException {

        addItemsPage.EanInitilizeElements();
        addItemsPage.EnterEanAndClickOnEnter(eanNumber);

    }

    @And("After entering items details add payment details {string}")
    public void afterEnteringItemsDetailsAddPaymentDetails(String PaymentType) throws InterruptedException {

        paymentPage.initilizePaymentElements();
        paymentPage.AddPaymentTypeAndFinishThepayment();
    }

    @And("after payment click on new terminal")
    public void afterPaymentClickOnNewTerminal() throws InterruptedException {
        paymentPage.clickOnNew();

    }


    //-===============================================================================================
    //using excel

    Multiple_AddItemsPage multiple_addItemsPage = new Multiple_AddItemsPage(QXClient.getWindowsDriver());
    Multiple_PaymentPage multiple_paymentPage = new Multiple_PaymentPage(QXClient.getWindowsDriver());


    @And("enter itemdetails payment details after payment click  on new using excel {string} {string} {string} {string}")
    public void enterItemdetailsPaymentDetailsAfterPaymentClickOnNewUsingExcel(String SheetName, String requiredTasks, String PamentType, String excelFile) throws InterruptedException {

        ExcelUtils excelUtils = new ExcelUtils();


        List<HashMap<String, String>> EanAndpaymentList = excelUtils.readPossDataFromExcelSheet(SheetName, requiredTasks, PamentType, excelFile);
        System.out.println(EanAndpaymentList);
        for (int i = 0; i < EanAndpaymentList.size(); i++) {
            String ean = EanAndpaymentList.get(i).get("EAN");
            Thread.sleep(500);
            multiple_addItemsPage.EanInitilizeElements();
            Thread.sleep(500);
            multiple_addItemsPage.EnterEanAndClickOnEnterMultiple(ean);
            Thread.sleep(500);
        }
        multiple_paymentPage.initilizePaymentElements();
        Thread.sleep(500);
        multiple_paymentPage.AddPaymentTypeAndFinishThepayment(PamentType);
        Thread.sleep(500);
        multiple_paymentPage.clickOnNew();
        Thread.sleep(500);
        ;

    }

    //==================================================================================================
    //data table
    String xaph = null;

    @And("enter itemdetails payment details after payment click  on new using data table")
    public void enterItemdetailsPaymentDetailsAfterPaymentClickOnNewUsingDataTable(DataTable dataTable) throws InterruptedException {
        ExcelUtils excelUtils = new ExcelUtils();
        List<Map<String, String>> EANPaymentDT = dataTable.asMaps();
        for (int i = 0; i < EANPaymentDT.size(); i++) {
            String SheetName = EANPaymentDT.get(i).get("SheetName");
            String requiredTasks = EANPaymentDT.get(i).get("requiredTasks");
            String PamentType = EANPaymentDT.get(i).get("PamentType");
            String excelFile = EANPaymentDT.get(i).get("excelFile");

            List<HashMap<String, String>> EanAndpaymentList = excelUtils.readPossDataFromExcelSheet(SheetName, requiredTasks, PamentType, excelFile);
            System.out.println(EanAndpaymentList);
            ExtentReportManager.logInfoDetails("EanAndpaymentList is -"+EanAndpaymentList);

            for (int j = 0; j < EanAndpaymentList.size(); j++) {
                String ean = EanAndpaymentList.get(j).get("EAN");
                //    Thread.sleep(500);

                multiple_addItemsPage.EanInitilizeElementsUsingDT(ean, xaph);
                //    Thread.sleep(500);
                multiple_addItemsPage.EnterEanAndClickOnEnterMultiple(ean);
                //    Thread.sleep(500);
            }
            multiple_paymentPage.initilizePaymentElements();
            //    Thread.sleep(500);
            multiple_paymentPage.AddPaymentTypeAndFinishThepayment(PamentType);
            Thread.sleep(200);

            multiple_paymentPage.clickOnNew();


            //Thread.sleep(500);
        }
    }

    //===================================================================================================
    //practise
    @And("enter itemdetails payment details after payment click  on new using data table practise method")
    public void enterItemdetailsPaymentDetailsAfterPaymentClickOnNewUsingDataTablePractiseMethod(DataTable dataTable) throws InterruptedException {

        ExcelUtils excelUtils = new ExcelUtils();
        List<Map<String, String>> EANPaymentDT = dataTable.asMaps();
        for (int i = 0; i < EANPaymentDT.size(); i++) {
            String SheetName = EANPaymentDT.get(i).get("SheetName");
            String requiredTasks = EANPaymentDT.get(i).get("requiredTasks");
            String PamentType = EANPaymentDT.get(i).get("PamentType");
            String excelFile = EANPaymentDT.get(i).get("excelFile");

            List<HashMap<String, String>> EanAndpaymentList = excelUtils.readPossDataFromExcelSheet(SheetName, requiredTasks, PamentType, excelFile);
            System.out.println(EanAndpaymentList);
            for (int j = 0; j < EanAndpaymentList.size(); j++) {
                String ean = EanAndpaymentList.get(j).get("EAN");
                generateDynamicXpath1_page.EanInitilizeElementsUsingPractiseDT(ean, xaph);
                generateDynamicXpath1_page.EnterEanAndClickOnEnterMultiple(ean);
            }
            generateDynamicXpath1_page.initilizePaymentElements();
            generateDynamicXpath1_page.AddPaymentTypeAndFinishThepayment(PamentType);
            Thread.sleep(200);
            generateDynamicXpath1_page.clickOnNew();


        }
    }


    @And("add required cash to cash counter using practise method")
    public void addRequiredCashToCashCounterUsingPractiseMethod(DataTable dataTable) {
        List<Map<String, String>> openCounterDT = dataTable.asMaps();

        for (int k = 0; k < openCounterDT.size(); k++) {
            String OpenCashcouterBalance = openCounterDT.get(k).get("OpenCashcouterBalance");
            try {
                generateDynamicXpath1_page.CashCounterInitilizeElements();
                generateDynamicXpath1_page.addCashToCounter(OpenCashcouterBalance);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }


    }

    @And("Add all Required payment types to arrayList using practise method")
    public void addAllRequiredPaymentTypesToArrayListUsingPractiseMethod(DataTable dataTable) {

        generateDynamicXpath1_page.AddAllPaymentsType(dataTable);

    }
}


