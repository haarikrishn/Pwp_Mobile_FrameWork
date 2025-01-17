package com.DmartLabs.bdd.pages;

import com.DmartLabs.commonutils.Gestures;
import com.DmartLabs.commonutils.QXClient;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class LoaderPage {

    public LoaderPage(){
        PageFactory.initElements(new AppiumFieldDecorator(QXClient.get().driver()), this);
    }

    Gestures gestures;

    @FindBy(xpath = "//android.widget.TextView[@text='Loader']")
    private MobileElement loaderModule;

    @FindBy(id = "com.dmartlabs.pwp:id/edt_dl_search")
    private MobileElement searchBox;

    @FindBy(id="com.dmartlabs.pwp:id/txt_lid_delivery_no")
    private List<MobileElement> allDeliveries;

    @FindBy(id = "com.dmartlabs.pwp:id/ib_fch_logout")
    private MobileElement logOutIcon;

    @FindBy(id = "com.dmartlabs.pwp:id/alertTitle")
    private MobileElement logoutAlertPanel;

    @FindBy(id = "android:id/button1")
    private MobileElement logoutYesBtn;

    @FindBy(id = "android:id/button2")
    private MobileElement logoutNoBtn;

    @FindBy(id = "com.dmartlabs.pwp:id/cl_parent")
    private MobileElement loggingOutPanel;

    private String specficDeliveryXpath = "//android.widget.TextView[@text='%s']/parent::android.view.ViewGroup";
    private String destinationSiteId = "//android.widget.TextView[@text='%s']/preceding-sibling::android.widget.TextView[@resource-id='com.dmartlabs.pwp:id/txt_lid_site_name']";
    private String dispatchTypeXpath = "//android.widget.TextView[@text='%s']/following-sibling::android.widget.TextView[@resource-id='com.dmartlabs.pwp:id/txt_lid_dispatch_label']";

    private static List<String> deliveryList = new ArrayList<>();;
    private static boolean isScroll = false;
    private static int scrollCount = 0;

    public void isLoaderPageDisplayed(){
        gestures = QXClient.get().gestures();
        boolean result = gestures.isElementPresent(loaderModule);
        Assert.assertTrue(result,"Loader is not in Loader Page");
    }

    public List<String> getAllDeliveries(){
        for (MobileElement delivery:allDeliveries){
            String deliveryNumber = delivery.getText().trim();
            if (!deliveryList.contains(deliveryNumber))
                    deliveryList.add(deliveryNumber);
        }

        if (!isScroll){
            scrollCount++;
            QXClient.get().gestures().scrollVertically1(1);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for (MobileElement delivery:allDeliveries){
                if (deliveryList.contains(delivery.getText().trim()))
                    isScroll = true;
            }
            getAllDeliveries();
        }
        gestures.scrollVertically2(1);
        return deliveryList;
    }

    public void scrollToDeliveryCardAndClick(String expectedDeliveryNumber){

        for (MobileElement delivery:allDeliveries){
            String deliveryNumber = delivery.getText().trim();
            if (deliveryNumber.equals("#0075707900")){
                continue;
            }
            if (!deliveryList.contains(deliveryNumber))
                deliveryList.add(deliveryNumber);
        }

        if (!isScroll){
            scrollCount++;
            QXClient.get().gestures().scrollVertically1(1);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for (MobileElement delivery:allDeliveries){
                if (deliveryList.contains(delivery.getText().trim()))
                    isScroll = true;

                if (delivery.getText().equals(expectedDeliveryNumber)){
                    delivery.click();
                    return;
                }
            }
            scrollToDeliveryCardAndClick(expectedDeliveryNumber);
        }
    }

    public void loadAllDeliveries(){
        deliveryList = getAllDeliveries();
        gestures = QXClient.get().gestures();
        DeliveryDetailsPage deliveryDetails = new DeliveryDetailsPage();

        try {
//            for (MobileElement delivery:allDeliveries){
//                deliveryList.add(delivery.getText().trim());
//            }

            for (String deliveryNumber:deliveryList){
                if (deliveryNumber.contains("#0075707900") || deliveryNumber.contains("#936752817"))
                    continue;
                MobileElement delivery = getMobileElementFromDynamicXpath(specficDeliveryXpath, deliveryNumber);
                //gestures.waitForVisbilityOfWebElement(delivery);
                gestures.isElementPresent(delivery);
//                clickOnDeliveryCard(deliveryNumber);
//                deliveryDetails.isDeliverDetailsPageDisplayed(deliveryNumber);
//                deliveryDetails.loadHUs();
//                deliveryDetails.confirmLoadedItems();
//                deliveryDetails.deliveryLoadingConfirmation();
//                Thread.sleep(3000);
//            allDeliveries.remove(delivery);
            }
        } catch (StaleElementReferenceException sre){
            loadAllDeliveries();
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }

//    public List<String> getDeliveryList(){
//        List<String> deliveryList = new ArrayList<>();
//        for (MobileElement delivery:allDeliveries){
//            deliveryList.add(delivery.getText().trim());
//        }
//        System.out.println("list1 ========> "+deliveryList);
//        System.out.println();
//        return deliveryList;
//    }

    public void searchDelivery(String deliveryNumber){
        searchBox.sendKeys(deliveryNumber);
    }

    public String verifyDispatchType(String deliveryNumber) {
        MobileElement dispatchTypeElement = getMobileElementFromDynamicXpath(dispatchTypeXpath, deliveryNumber);
        MobileElement destinationSite = getMobileElementFromDynamicXpath(destinationSiteId, deliveryNumber);

        String dispatchType = dispatchTypeElement.getText();

        if (destinationSite.getText().contains("5019")){
            Assert.assertEquals(dispatchType,"PALLET DISPATCH");
        } else if (destinationSite.getText().contains("4019")){
            Assert.assertEquals(dispatchType, "BOX DISPATCH");
        }
        return dispatchType;
    }

    public void clickOnDeliveryCard(Map<String, String> deliveryNumber) {
        String expectedDeliveryNumber = deliveryNumber.get("deliveryNumber");
//        String specificDeliveryXpath = "//android.widget.TextView[@text='"+expectedDeliveryNumber+"']";
//        By xpath = By.xpath(specificDeliveryXpath);
        try {
//            MobileElement deliveryCard = (MobileElement) QXClient.get().driver().findElement(xpath);
              MobileElement deliveryCard = getMobileElementFromDynamicXpath(specficDeliveryXpath, expectedDeliveryNumber);
//            int eleLoc = deliveryCard.getLocation().getY();
//            System.out.println("Element location is ================> "+eleLoc);
//            Dimension dim = QXClient.get().driver().manage().window().getSize();
//            System.out.println(dim.height);

            if (deliveryCard.getText().trim().equals(allDeliveries.get(allDeliveries.size()-1).getText().trim())){
                QXClient.get().gestures().scrollVertically1(1);
            }
            deliveryCard.click();
        }
        catch (NoSuchElementException nse){
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            gestures.scrollAndClick(expectedDeliveryNumber);
        }
        catch (Exception e){
            e.printStackTrace();
        }
//        MobileElement deliveryCard = (MobileElement) QXClient.get().driver().findElement(xpath);
        //deliveryCard.getLocation().
//        if (!deliveryCard.isDisplayed()){
//            gestures.scrollAndClick(expectedDeliveryNumber);
//        }
//        else
//            deliveryCard.click();
    }

    public void clickOnDeliveryCard1(Map<String, String> deliveryNumber) {
        String expectedDeliveryNumber = deliveryNumber.get("deliveryNumber");
//        String specificDeliveryXpath = "//android.widget.TextView[@text='"+expectedDeliveryNumber+"']";
//        By xpath = By.xpath(specificDeliveryXpath);
        MobileElement deliveryCard=null;
        try {
//            MobileElement deliveryCard = (MobileElement) QXClient.get().driver().findElement(xpath);
            deliveryCard = getMobileElementFromDynamicXpath(specficDeliveryXpath, expectedDeliveryNumber);
//            int eleLoc = deliveryCard.getLocation().getY();
//            System.out.println("Element location is ================> "+eleLoc);
//            Dimension dim = QXClient.get().driver().manage().window().getSize();
//            System.out.println(dim.height);

            if (allDeliveries.size()-1==3 && deliveryCard.getText().trim().equals(allDeliveries.get(allDeliveries.size()-1).getText().trim())){
                QXClient.get().gestures().scrollVertically1(1);
            }
            //gestures.waitAndClickElementisVisible(deliveryCard);
            deliveryCard.click();
        }
        catch (NoSuchElementException nse){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            scrollToDeliveryCardAndClick(expectedDeliveryNumber);
        }
        catch (Exception e){
            e.printStackTrace();
        }
//        MobileElement deliveryCard = (MobileElement) QXClient.get().driver().findElement(xpath);
        //deliveryCard.getLocation().
//        if (!deliveryCard.isDisplayed()){
//            gestures.scrollAndClick(expectedDeliveryNumber);
//        }
//        else
//            deliveryCard.click();
    }

    public void clickOnDeliveryCard(String deliveryNumber) {

        String specificDeliveryXpath = "//android.widget.TextView[@text='"+deliveryNumber+"']";
        By xpath = By.xpath(specificDeliveryXpath);
        try {
            MobileElement deliveryCard = (MobileElement) QXClient.get().driver().findElement(xpath);
//            int eleLoc = deliveryCard.getLocation().getY();
//            System.out.println("Element location is ================> "+eleLoc);
//            Dimension dim = QXClient.get().driver().manage().window().getSize();
//            System.out.println(dim.height);;
            deliveryCard.click();
        }
        catch (NoSuchElementException nse){
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            gestures.scrollAndClick(deliveryNumber);
        }
        catch (Exception e){
            e.printStackTrace();
        }
//        MobileElement deliveryCard = (MobileElement) QXClient.get().driver().findElement(xpath);
        //deliveryCard.getLocation().
//        if (!deliveryCard.isDisplayed()){
//            gestures.scrollAndClick(expectedDeliveryNumber);
//        }
//        else
//            deliveryCard.click();
    }

    public void clickOnDeliveryCard1(String deliveryNumber) {
        String expectedDeliveryNumber = deliveryNumber;
//        String specificDeliveryXpath = "//android.widget.TextView[@text='"+expectedDeliveryNumber+"']";
//        By xpath = By.xpath(specificDeliveryXpath);
        MobileElement deliveryCard=null;
        try {
//            MobileElement deliveryCard = (MobileElement) QXClient.get().driver().findElement(xpath);
            deliveryCard = getMobileElementFromDynamicXpath(specficDeliveryXpath, expectedDeliveryNumber);
//            int eleLoc = deliveryCard.getLocation().getY();
//            System.out.println("Element location is ================> "+eleLoc);
//            Dimension dim = QXClient.get().driver().manage().window().getSize();
//            System.out.println(dim.height);

            if (deliveryCard.getText().trim().equals(allDeliveries.get(allDeliveries.size()-1).getText().trim())){
                QXClient.get().gestures().scrollVertically1(1);
            }
            deliveryCard.click();
        }
        catch (NoSuchElementException nse){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            scrollToDeliveryCardAndClick(expectedDeliveryNumber);
        }
        catch (Exception e){
            e.printStackTrace();
        }
//        MobileElement deliveryCard = (MobileElement) QXClient.get().driver().findElement(xpath);
        //deliveryCard.getLocation().
//        if (!deliveryCard.isDisplayed()){
//            gestures.scrollAndClick(expectedDeliveryNumber);
//        }
//        else
//            deliveryCard.click();
    }

    public void logoutUser(){
        gestures = QXClient.get().gestures();
        gestures.waitForVisbilityOfWebElement(logOutIcon).click();
//        logOutIcon.click();
        gestures.waitForVisbilityOfWebElement(logoutAlertPanel);
        logoutYesBtn.click();
        Assert.assertTrue(loggingOutPanel.isDisplayed());
        LoginPage loginPage = new LoginPage();
        loginPage.loginTitleIsDisplayed();
    }

    private MobileElement getMobileElementFromDynamicXpath(String partialXpath, String replaceCharacter){
        String xpath = String.format(partialXpath, replaceCharacter);
        return (MobileElement) QXClient.get().driver().findElement(By.xpath(xpath));
    }

}
