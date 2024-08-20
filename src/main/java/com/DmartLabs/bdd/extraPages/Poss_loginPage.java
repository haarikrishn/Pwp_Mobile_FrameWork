package com.DmartLabs.bdd.extraPages;

import com.DmartLabs.commonutils.Gestures;
import com.DmartLabs.commonutils.QXClient;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.windows.WindowsDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Map;
import java.util.concurrent.TimeUnit;

public class Poss_loginPage {


    private WindowsDriver<WebElement> windowsDriver;

    @FindBy(xpath = "//*[@AutomationId='login-employee-id']")
    private WebElement userNameField;

    @FindBy(xpath = "//*[@AutomationId='login-employee-password']")
    private WebElement passwordField;

    @FindBy(name = "ENTER")
    private WebElement enterButton;

    public Poss_loginPage(WindowsDriver<WebElement> driver) {
        this.windowsDriver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void enterUserName(String userName) {
        if (userNameField.isDisplayed()) {
            userNameField.sendKeys(userName);
        } else {
            throw new RuntimeException("Username field is not displayed.");
        }
    }

    public void enterPassword(String password) {
        if (passwordField.isDisplayed()) {
            passwordField.sendKeys(password);
        } else {
            throw new RuntimeException("Password field is not displayed.");
        }
    }

    public void clickEnterButton() {
        if (enterButton.isDisplayed()) {
            enterButton.click();
        } else {
            throw new RuntimeException("Enter button is not displayed.");
        }
    }

    public void login(String userName, String password) {
        enterUserName(userName);
        enterPassword(password);
        clickEnterButton();
    }

}
