package com.DmartLabs.bdd.extraPages;

import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.windows.WindowsDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Poss_loginPage1 {


    private WindowsDriver<WebElement> windowsDriver;

    @FindBy(xpath = "//*[@AutomationId='login-employee-id']")
    private WebElement userNameField;

    @FindBy(xpath = "//*[@AutomationId='login-employee-password']")
    private WebElement passwordField;

    @FindBy(name = "ENTER")
    private WebElement enterButton;

    public Poss_loginPage1(WindowsDriver<WebElement> driver) {
        this.windowsDriver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }


}
