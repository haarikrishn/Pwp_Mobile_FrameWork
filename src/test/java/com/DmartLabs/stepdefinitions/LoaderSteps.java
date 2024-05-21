package com.DmartLabs.stepdefinitions;

import com.DmartLabs.bdd.pages.*;
import com.DmartLabs.commonutils.Gestures;
import com.DmartLabs.commonutils.QXClient;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LoaderSteps {

    private LoaderPage loader;
    private DeliveryDetailsPage deliveryDetails;
    private HU_DetailPage huDetail;
    private static Map<String, String> expectedDeliveryNumber;
    private String dispatchType;
//    List<WebElement> allHUs;
    private List<String> huNumbers;
    private ConsolidateHUPage consolidateHU;
    private ConfirmMoveItemPage confirmMoveItem;
    private Map<String, String> sourceHU;
    private Gestures gestures;

    @Given("Verify that Loader is in Loader Page")
    public void verifyThatLoaderIsInLoaderPage() {
        loader = new LoaderPage();
        loader.isLoaderPageDisplayed();
    }

    @When("Provide the delivery number of a Delivery for which Loading Operation is to be performed")
    public void provideTheDeliveryNumberOfADeliveryForWhichLoadingOperationIsToBePerformed(DataTable dataTable) {
        expectedDeliveryNumber = dataTable.asMap(String.class, String.class);
    }

    @When("Get the delivery number to load the Delivery into the truck")
    public void getTheDeliveryNumberToLoadTheDeliveryIntoTheTruck() {
        expectedDeliveryNumber = new HashMap<>();
        System.out.println("Normal Delivery ============> "+QXClient.getNormalDeliveryNumber());
        expectedDeliveryNumber.put("deliveryNumber", QXClient.getNormalDeliveryNumber());
    }

    @And("Search the delivery in a Loader Page")
    public void searchTheDeliveryInALoaderPage() {
        String deliveryNumber = expectedDeliveryNumber.get("deliveryNumber");
        loader.searchDelivery(deliveryNumber);
    }

    @And("Verify the dispatch type of a delivery")
    public void verifyTheDispatchTypeOfADelivery() {
        dispatchType = loader.verifyDispatchType(expectedDeliveryNumber.get("deliveryNumber"));
    }

    @When("Load all the deliveries into the truck")
    public void loadAllTheDeliveriesIntoTheTruck() {
        loader.loadAllDeliveries();
    }

    @And("Click on Delivery Card")
    public void clickOnDeliveryCard1() {
        loader.clickOnDeliveryCard1(expectedDeliveryNumber);
    }

    @And("Verify that loader is in Delivery Details Page")
    public void verifyThatLoaderIsInDeliveryDetailsPage() {
        deliveryDetails = new DeliveryDetailsPage();
//        allHUs = deliveryDetails.isDeliverDetailsPageDisplayed(expectedDeliveryNumber);
        huNumbers = deliveryDetails.isDeliverDetailsPageDisplayed(expectedDeliveryNumber);
    }

    @And("Go to OFFLINE Mode")
    public void goToOFFLINEMode() {
        Gestures.turnOffWiFi();
    }

    @And("Verify that Loader is in offline mode")
    public void verifyThatLoaderIsInOfflineMode() {
        deliveryDetails.verifyThatLoaderIsInOfflineMode();
    }

    @And("Click on CONSOLIDATE button")
    public void clickOnCONSOLIDATEButton() {
        deliveryDetails.clickONConsolidateButton();
    }

    @And("Provide source HU Number")
    public void provideSourceHUNumber(DataTable dataTable) {
        sourceHU = dataTable.asMap(String.class, String.class);
        deliveryDetails.provideSourceHU_Number(sourceHU.get("sourceHUNumber"));
    }

    @And("In Consolidate HU Page click on select all checkbox")
    public void inConsolidateHUPageClickOnSelectAllCheckbox() {
        consolidateHU = new ConsolidateHUPage();
        consolidateHU.clickOnSelectAllCheckBox();
    }

    @And("Click on MOVE button")
    public void clickOnMOVEButton() {
        consolidateHU.clickOnMoveButton();
    }

    @And("Provide the destination HU number")
    public void provideTheDestinationHUNumber(DataTable dataTable) {
        Map<String, String> destinationHU = dataTable.asMap(String.class, String.class);
        consolidateHU.provideDestinationHU_Number(destinationHU.get("destinationHUNumber"));
    }

    @And("Verify that Confirm Move Item page is displayed and click on OK button")
    public void verifyThatConfirmMoveItemPageIsDisplayedAndClickOnOKButton() {
        confirmMoveItem = new ConfirmMoveItemPage();
        confirmMoveItem.confirmMoveItems();
    }

    @And("Verify that HU is empty")
    public void verifyThatHUIsEmpty() {
        deliveryDetails.verifyThatHU_IsEmpty(sourceHU.get("sourceHUNumber"));
    }

    @And("Adjust the item's caselot in HU")
    public void adjustItemsCaselotInHU(DataTable dataTable) {
        Map<String, String> itemAdjustmentDetails = dataTable.asMap(String.class, String.class);
        huDetail = new HU_DetailPage();
//        huDetail.adjustItemCaselot(allHUs,itemAdjustmentDetails);
        huDetail.adjustItemCaselot(huNumbers,itemAdjustmentDetails);
    }

    @And("Adjust the item's caselot in HU 1")
    public void adjustItemsCaselotInHU1(DataTable dataTable) {
        List<Map<String, String>> itemAdjustmentDetails = dataTable.asMaps();
        huDetail = new HU_DetailPage();
//        huDetail.adjustItemCaselot(allHUs,itemAdjustmentDetails);
        huDetail.adjustItemCaselot1(huNumbers,itemAdjustmentDetails);
    }

    @And("Load the HUs into the truck")
    public void loadTheHUsIntoTheTruck() {
        if (dispatchType.equals("PALLET DISPATCH")) {
            SoftAssert softAssert = deliveryDetails.loadHUs();
            softAssert.assertAll();
        } else if (dispatchType.equals("BOX DISPATCH"))
            deliveryDetails.loadBoxes();
    }

    @And("Load the HUs into the truck and verify that No Network Connection dialouge box and Remote Sync Icon is displayed or not")
    public void loadTheHUsIntoTheTruckAndVerifyThatNoNetworkConnectionDialougeBoxAndRemoteSyncIconIsDisplayedOrNot() {
        deliveryDetails.loadHUsInOfflineMode();
    }

    @And("Provide HU number not to be loaded and load the remaining HUs into the truck")
    public void provideHUNumberNotToBeLoadedAndLoadTheRemainingHUsIntoTheTruck(DataTable dataTable) {
        List<String> leftHUs = dataTable.asList();
        deliveryDetails.leaveSomeHUsAndLoadReamainingHUs(leftHUs);
    }

    @And("Provide HU number not to be loaded and load the remaining HUs into the truck in Offline mode")
    public void provideHUNumberNotToBeLoadedAndLoadTheRemainingHUsIntoTheTruckInOfflineMode(DataTable dataTable) {
        List<String> leftHUs = dataTable.asList();
        deliveryDetails.leaveSomeHUsAndLoadRemaingHUsInOfflineMode(leftHUs);
    }

    @And("Click on CONFIRM Button in Offline mode")
    public void clickOnCONFIRMButtonInOfflineMode() {
        deliveryDetails.confirmLoadedItemsInOfflineMode();
    }

    @And("Verify that No Network Connection dialouge box is displayed")
    public void verifyThatNoNetworkConnectionDialougeBoxIsDisplayed() {
        deliveryDetails.verifyNoNetworkConnectionDialougeBox();
    }

    @And("Go to ONLINE mode")
    public void goToONLINEMode() {
        Gestures.turnOnWiFi();
    }

    @And("Confirm the loading")
    public void confirmTheLoading() {
        deliveryDetails.confirmLoadedItems();
    }

    @And("Confirm the partially loaded HU delivery in Offline mode")
    public void confirmThePartiallyLoadedHUDeliveryInOfflineMode() {
        SoftAssert softAssert = deliveryDetails.confirmPartiallyLoadedDelivery();
        softAssert.assertAll();
    }

    @And("Confirm the partially loaded HU delivery")
    public void confirmThePartiallyLoadedHUDelivery() {
        SoftAssert softAssert = deliveryDetails.confirmPartiallyLoadedDelivery();
        softAssert.assertAll();
    }

    @Then("Verify that loading operation is completed")
    public void verifyThatLoadingOperationIsCompleted() {
        deliveryDetails.deliveryLoadingConfirmation();
    }

    @And("Confirm Box type delivery loading")
    public void confirmBoxTypeDeliveryLoading() {
        deliveryDetails.confirmBoxTypeDeliveryLoading();
    }


    @Then("Verify that Box type delivery loading operation is completed")
    public void verifyThatBoxTypeDeliveryLoadingOperationIsCompleted() {
        deliveryDetails.boxTypeDeliveryLoadingConfirmation();
    }

    @And("Wait for {int} minutes")
    public void waitForMinutes(int waitingPeriod) {
        try {
            Thread.sleep(waitingPeriod);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @And("Provide HUs to be loaded into the truck")
    public void provideHUsToBeLoadedIntoTheTruck(DataTable dataTable) {
        huNumbers = dataTable.asList();
        SoftAssert softAssert = deliveryDetails.loadParticularHU(huNumbers);
        softAssert.assertAll();
    }

    @And("Load remaining HUs")
    public void loadRemainingHUs() {
        deliveryDetails.leaveSomeHUsAndLoadReamainingHUs(huNumbers);
    }

    @And("Verify that Error Message is displayed")
    public void verifyThatErrorMessageIsDisplayed() {
        deliveryDetails.verifyErrorMessage();
    }

}
