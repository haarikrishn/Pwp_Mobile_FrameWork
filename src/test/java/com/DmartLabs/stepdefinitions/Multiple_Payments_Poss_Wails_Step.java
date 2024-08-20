package com.DmartLabs.stepdefinitions;

import com.DmartLabs.bdd.pages.AddItemsPage;
import com.DmartLabs.bdd.pages.Multiple_AddItemsPage;
import com.DmartLabs.bdd.pages.Multiple_PaymentPage;
import com.DmartLabs.bdd.pages.PaymentPage;
import com.DmartLabs.commonutils.QXClient;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

import java.util.List;
import java.util.Map;

public class Multiple_Payments_Poss_Wails_Step {


    Multiple_AddItemsPage multiple_addItemsPage = new Multiple_AddItemsPage(QXClient.getWindowsDriver());
    Multiple_PaymentPage multiple_paymentPage = new Multiple_PaymentPage(QXClient.getWindowsDriver());


    public Multiple_Payments_Poss_Wails_Step() throws InterruptedException {
    }

    @When("add items to items details page  for multiple payments")
    public void addItemsToItemsDetailsPageForMultiplePayments(DataTable dataTable) throws InterruptedException {
        List<Map<String, String>> eanDT = dataTable.asMaps();

        multiple_addItemsPage.EanInitilizeElements();

        multiple_addItemsPage.EnterEanAndClickOnEnter(dataTable);
    }

    @And("After entering items details add payment details {string} for multiple payments")
    public void afterEnteringItemsDetailsAddPaymentDetailsForMultiplePayments(String PaymentType) throws
            InterruptedException {

        multiple_paymentPage.initilizePaymentElements();

        multiple_paymentPage.AddPaymentTypeAndFinishThepayment(PaymentType);

    }

    @And("after payment click on new terminal for multiple apyments")
    public void afterPaymentClickOnNewTerminalForMultipleApyments() throws InterruptedException {
        multiple_paymentPage.clickOnNew();


    }


    @And("Add all Required payment types to arrayList")
    public void addAllRequiredPaymentTypesToArrayList(DataTable dataTable) {

        multiple_paymentPage.AddAllPaymentsType(dataTable);


    }
}


