package com.DmartLabs.bdd.extraPages;

import io.appium.java_client.windows.WindowsDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Map;
import java.util.concurrent.TimeUnit;

public class Caluclator_Page {

    private WindowsDriver<WebElement> windowsDriver;

    @FindBy(name = "Plus")
    private WebElement plusButton;

    @FindBy(name = "Nine")
    private WebElement nineButton;

    @FindBy(name = "Equals")
    private WebElement equalsButton;


    public Caluclator_Page(WindowsDriver<WebElement> driver) {
        this.windowsDriver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void performCalculation() throws InterruptedException {
        nineButton.click();
        plusButton.click();
        Thread.sleep(500);
        nineButton.click();
        Thread.sleep(500);
        equalsButton.click();
        windowsDriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        System.out.println("successfully executed");
    }

//    public String getResults() {
//        return resultsElement.getText();
//    }


}
