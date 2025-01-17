package com.DmartLabs.bdd.pages;

import com.DmartLabs.commonutils.Gestures;
import com.DmartLabs.commonutils.QXClient;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class HU_DetailPage {

    public HU_DetailPage(){
        PageFactory.initElements(new AppiumFieldDecorator(QXClient.get().driver()), this);
    }

    @FindBy(id = "com.dmartlabs.pwp:id/txt_dhpil_title")
    private MobileElement pageTitle;

    @FindBy(id = "com.dmartlabs.pwp:id/txt_dhpil_hu_number")
    private MobileElement huNumber;

    @FindBy(id = "com.dmartlabs.pwp:id/txt_ldhpi_item_name")
    private List<MobileElement> allItems;

    //android.widget.TextView[@text='Grace Citrus Passi Shower Gel 250ml']

//    @FindBy(id="com.dmartlabs.pwp:id/txt_ldhpi_boxes_value")
//    private List<MobileElement> totalCaselots;

    String totalCaselotXpath = "//android.widget.TextView[@text='%s']/following-sibling::android.widget.TextView[@resource-id='com.dmartlabs.pwp:id/txt_ldhpi_boxes_value']";

    @FindBy(id = "com.dmartlabs.pwp:id/ib_ldhpi_backward")
    private MobileElement removeCaselotBtn;

    String removeCaselotBtnXpath = "//android.widget.TextView[@text='%s']/following-sibling::android.view.ViewGroup/android.widget.ImageButton[1]";

    @FindBy(id = "com.dmartlabs.pwp:id/ib_ldhpi_forward")
    private MobileElement addCaselotBtn;

    @FindBy(id = "com.dmartlabs.pwp:id/btn_dhpil_remove")
    private MobileElement removeBtn;

    @FindBy(id = "com.dmartlabs.pwp:id/txt_fricd_dialog_title")
    private MobileElement confirmChangesDialougeBox;

    @FindBy(id="com.dmartlabs.pwp:id/btn_fricd_yes")
    private MobileElement confirmChangesYesBtn;

    @FindBy(id="com.dmartlabs.pwp:id/btn_fricd_no")
    private MobileElement confirmChangesNoBtn;

    @FindBy(id = "com.dmartlabs.pwp:id/btn_dhpil_bottom_bar_back")
    private MobileElement backBtn;

    private String specificHUXpath = "//android.widget.TextView[@text='%s']";

    Gestures gestures;

//    public void adjustItemCaselot(List<WebElement> allHus, Map<String, String> adjustmentDetails){
//        gestures = QXClient.get().gestures();
//        String itemName = adjustmentDetails.get("itemName");
//        int adjustCaselot = 0;
//        AppiumDriver driver = QXClient.get().driver();
//        boolean flag = false;
//        for(WebElement hu:allHus){
//            allHus = gestures.waitForVisiblityOfAllWebElement(allHus);
//            hu.click();
//            Assert.assertTrue(gestures.isElementPresent(huNumber));
//
//            for (MobileElement item:allItems){
//                if (item.getText().contains(itemName)){
//                    flag = true;
//                    if (adjustmentDetails.containsKey("removeCaselot")) {
//                        adjustCaselot = Integer.parseInt(adjustmentDetails.get("removeCaselot"));
//                        String totalCaselotXpath = "//android.widget.TextView[@text='"+itemName+"']/following-sibling::android.widget.TextView[@resource-id='com.dmartlabs.pwp:id/txt_ldhpi_boxes_value']";
//                        int totalCaselot = Integer.parseInt(((MobileElement) driver.findElement(By.xpath(totalCaselotXpath))).getText());
//                        String removeCaselotBtnXpath = "//android.widget.TextView[@text='"+itemName+"']/following-sibling::android.view.ViewGroup/android.widget.ImageButton[1]";
//                        MobileElement removeCaselotBtn = (MobileElement) driver.findElement(By.xpath(removeCaselotBtnXpath));
//
//                        if (adjustCaselot<=totalCaselot && adjustCaselot!=0){
//                            for(int i=1;i<=totalCaselot;i++){
//                                removeCaselotBtn.click();
//                                if (i==adjustCaselot){
//                                    break;
//                                }
//                            }
//                            removeBtn.click();
//                            Assert.assertTrue(gestures.isElementPresent(confirmChangesDialougeBox));
//                            confirmChangesYesBtn.click();
//                            break;
//                        }
//                        else {
//                            backBtn.click();
//                            System.out.println("Valid Quantity is not provided !!!!!!!!!!!!!!!!!!!!!");
//                        }
//
//                        //put it inside if() --> 77 not sure
////                        removeBtn.click();
////                        Assert.assertTrue(gestures.isElementPresent(confirmChangesDialougeBox));
////                        confirmChangesYesBtn.click();
////                        break;
//
//                    } else if (adjustmentDetails.containsKey("addCaselot")) {
//                        adjustCaselot = Integer.parseInt(adjustmentDetails.get("addCaselot"));
//                        String totalCaselotXpath = "//android.widget.TextView[@text='"+itemName+"']/following-sibling::android.widget.TextView[@resource-id='com.dmartlabs.pwp:id/txt_ldhpi_boxes_value']";
//                        int totalCaselot = Integer.parseInt(((MobileElement) driver.findElement(By.xpath(totalCaselotXpath))).getText());
//                        String addCaselotBtnXpath = "//android.widget.TextView[@text='"+itemName+"']/following-sibling::android.view.ViewGroup/android.widget.ImageButton[2]";
//                        MobileElement addCaselotBtn = (MobileElement) driver.findElement(By.xpath(addCaselotBtnXpath));
//                        if (adjustCaselot<=totalCaselot && adjustCaselot!=0){
//                            for(int i=1;i<=totalCaselot;i++){
//                                addCaselotBtn.click();
//                                if (i==adjustCaselot){
//                                    break;
//                                }
//                            }
//                            removeBtn.click();
//                            Assert.assertTrue(gestures.isElementPresent(confirmChangesDialougeBox));
//                            confirmChangesYesBtn.click();
//                            break;
//                        }
//                        else {
//                            backBtn.click();
//                            System.out.println("Valid Quantity is not provided !!!!!!!!!!!!!!!!!!!!!");
//                        }
//
////                        removeBtn.click();
////                        Assert.assertTrue(gestures.isElementPresent(confirmChangesDialougeBox));
////                        confirmChangesYesBtn.click();
////                        break;
//
//                    } else
//                        System.out.println("Wrong Details provided !!!!!!!!!!!!!!!!!!!");
//                }
//            }
//            if (flag){
//                break;
//            }
//        }
//    }

    public void adjustItemCaselot(List<String> allHus, Map<String, String> adjustmentDetails){
        gestures = QXClient.get().gestures();
        String itemName = adjustmentDetails.get("itemName");
        int adjustCaselot = 0;
        AppiumDriver driver = QXClient.get().driver();
        boolean flag = false;
        for(String huNumber:allHus){
            String xpath = String.format(specificHUXpath, huNumber);
            MobileElement hu = (MobileElement) QXClient.get().driver().findElement(By.xpath(xpath));
            gestures.waitForVisbilityOfWebElement(hu).click();
            Assert.assertTrue(gestures.isElementPresent(this.huNumber));

            for (int i=0; i<allItems.size(); i++){
                if (allItems.get(i).getText().contains(itemName)){
                    System.out.println(allItems.get(i).getText());
                    flag = true;
                    if (adjustmentDetails.containsKey("removeCaselot")) {
                        adjustCaselot = Integer.parseInt(adjustmentDetails.get("removeCaselot"));
                        String totalCaselotXpath = "//android.widget.TextView[@text='"+itemName+"']/following-sibling::android.widget.TextView[@resource-id='com.dmartlabs.pwp:id/txt_ldhpi_boxes_value']";
                        int totalCaselot = Integer.parseInt(((MobileElement) driver.findElement(By.xpath(totalCaselotXpath))).getText());
                        String removeCaselotBtnXpath = "//android.widget.TextView[@text='"+itemName+"']/following-sibling::android.view.ViewGroup/android.widget.ImageButton[1]";
                        MobileElement removeCaselotBtn = (MobileElement) driver.findElement(By.xpath(removeCaselotBtnXpath));

                        if (adjustCaselot<=totalCaselot && adjustCaselot!=0){
                            for(int j=1;j<=totalCaselot;j++){
                                removeCaselotBtn.click();
                                if (j==adjustCaselot){
                                    break;
                                }
                            }
                            removeBtn.click();
                            Assert.assertTrue(gestures.isElementPresent(confirmChangesDialougeBox));
                            confirmChangesYesBtn.click();
                            break;
                        }
                        else {
                            backBtn.click();
                            System.out.println("Valid Quantity is not provided !!!!!!!!!!!!!!!!!!!!!");
                        }

                        //put it inside if() --> 77 not sure
//                        removeBtn.click();
//                        Assert.assertTrue(gestures.isElementPresent(confirmChangesDialougeBox));
//                        confirmChangesYesBtn.click();
//                        break;

                    } else if (adjustmentDetails.containsKey("addCaselot")) {
                        adjustCaselot = Integer.parseInt(adjustmentDetails.get("addCaselot"));
                        String totalCaselotXpath = "//android.widget.TextView[@text='"+itemName+"']/following-sibling::android.widget.TextView[@resource-id='com.dmartlabs.pwp:id/txt_ldhpi_boxes_value']";
                        int totalCaselot = Integer.parseInt(((MobileElement) driver.findElement(By.xpath(totalCaselotXpath))).getText());
                        String addCaselotBtnXpath = "//android.widget.TextView[@text='"+itemName+"']/following-sibling::android.view.ViewGroup/android.widget.ImageButton[2]";
                        MobileElement addCaselotBtn = (MobileElement) driver.findElement(By.xpath(addCaselotBtnXpath));
                        if (adjustCaselot<=totalCaselot && adjustCaselot!=0){
                            for(int j=1;j<=totalCaselot;j++){
                                addCaselotBtn.click();
                                if (j==adjustCaselot){
                                    break;
                                }
                            }
                            removeBtn.click();
                            Assert.assertTrue(gestures.isElementPresent(confirmChangesDialougeBox));
                            confirmChangesYesBtn.click();
                            break;
                        }
                        else {
                            backBtn.click();
                            System.out.println("Valid Quantity is not provided !!!!!!!!!!!!!!!!!!!!!");
                        }

//                        removeBtn.click();
//                        Assert.assertTrue(gestures.isElementPresent(confirmChangesDialougeBox));
//                        confirmChangesYesBtn.click();
//                        break;

                    } else
                        System.out.println("Wrong Details provided !!!!!!!!!!!!!!!!!!!");
                }

                if (i==allItems.size()-1 && !allItems.get(i).getText().contains(itemName)){
                    backBtn.click();
                }
            }

            if (flag){
                break;
            }
        }
    }


    public void adjustItemCaselot1(List<String> allHus, List<Map<String, String>> itemsAdjustmentDetails) {
        gestures = QXClient.get().gestures();
        int adjustCaselot = 0;
        AppiumDriver driver = QXClient.get().driver();
        boolean flag = false;
        List<Boolean> huFlag = new ArrayList<>();
        List<Boolean> itemsFlag = new ArrayList<>();
        for(String huNumber:allHus){
            MobileElement hu = getMobileElementFromDynamicXpath(specificHUXpath, huNumber);
            gestures.waitForVisbilityOfWebElement(hu).click();
            Assert.assertTrue(gestures.isElementPresent(this.huNumber));

            for (Map<String, String> itemadjustmentDetails:itemsAdjustmentDetails) {
                String itemName = itemadjustmentDetails.get("itemName");
                for (int i=0; i<allItems.size(); i++){
                    String actualItemName = allItems.get(i).getText();
                    System.out.println(actualItemName);
                    if (allItems.get(i).getText().contains(itemName)){
                        //String actualItemName = allItems.get(i).getText();
                        System.out.println(actualItemName);
                        flag = true;
                        itemsFlag.add(flag);
                        huFlag.add(flag);
                        if (itemadjustmentDetails.containsKey("removeCaselot")) {
                            adjustCaselot = Integer.parseInt(itemadjustmentDetails.get("removeCaselot"));
                            MobileElement totalCaselots = getMobileElementFromDynamicXpath(totalCaselotXpath, itemName);
                            int totalCaselot = Integer.parseInt(totalCaselots.getText());
                            MobileElement removeCaselotBtn = getMobileElementFromDynamicXpath(removeCaselotBtnXpath, itemName);

                            if (adjustCaselot<=totalCaselot && adjustCaselot!=0){
                                for(int j=1;j<=totalCaselot;j++){
                                    removeCaselotBtn.click();
                                    if (j==adjustCaselot){
                                        break;
                                    }
                                }
//                                removeBtn.click();
//                                Assert.assertTrue(gestures.isElementPresent(confirmChangesDialougeBox));
//                                confirmChangesYesBtn.click();
//                                break;
                            }
                            else {
                                backBtn.click();
                                System.out.println("Valid Quantity is not provided !!!!!!!!!!!!!!!!!!!!!");
                            }

                            //put it inside if() --> 77 not sure
//                        removeBtn.click();
//                        Assert.assertTrue(gestures.isElementPresent(confirmChangesDialougeBox));
//                        confirmChangesYesBtn.click();
//                        break;

                        } else if (itemadjustmentDetails.containsKey("addCaselot")) {
                            adjustCaselot = Integer.parseInt(itemadjustmentDetails.get("addCaselot"));
                            MobileElement totalCaselots = getMobileElementFromDynamicXpath(totalCaselotXpath, itemName);
                            int totalCaselot = Integer.parseInt(totalCaselots.getText());
                            String addCaselotBtnXpath = "//android.widget.TextView[@text='"+itemName+"']/following-sibling::android.view.ViewGroup/android.widget.ImageButton[2]";
                            MobileElement addCaselotBtn = (MobileElement) driver.findElement(By.xpath(addCaselotBtnXpath));
                            if (adjustCaselot<=totalCaselot && adjustCaselot!=0){
                                for(int j=1;j<=totalCaselot;j++){
                                    addCaselotBtn.click();
                                    if (j==adjustCaselot){
                                        break;
                                    }
                                }
//                                removeBtn.click();
//                                Assert.assertTrue(gestures.isElementPresent(confirmChangesDialougeBox));
//                                confirmChangesYesBtn.click();
//                                break;
                            }
                            else {
                                backBtn.click();
                                System.out.println("Valid Quantity is not provided !!!!!!!!!!!!!!!!!!!!!");
                            }

//                        removeBtn.click();
//                        Assert.assertTrue(gestures.isElementPresent(confirmChangesDialougeBox));
//                        confirmChangesYesBtn.click();
//                        break;

                        } else
                            System.out.println("Wrong Details provided !!!!!!!!!!!!!!!!!!!");

                    }

                    if (i==allItems.size()-1 && !allItems.get(i).getText().contains(itemName)){
                        backBtn.click();
                    }

                    if (itemsFlag.size()==itemsAdjustmentDetails.size()){
                        break;
                    }
                }
//                removeBtn.click();
//                Assert.assertTrue(gestures.isElementPresent(confirmChangesDialougeBox));
//                confirmChangesYesBtn.click();
            }

            if (huFlag.size()==itemsAdjustmentDetails.size()){
                break;
            }

        }

    }

    private MobileElement getMobileElementFromDynamicXpath(String partialXpath, String replaceCharacter){
        String xpath = String.format(partialXpath, replaceCharacter);
        return (MobileElement) QXClient.get().driver().findElement(By.xpath(xpath));
    }


}
