//package com.DmartLabs.stepdefinitions.extra;
//
//import com.DmartLabs.bdd.pages.HomePage;
//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.When;
//
//public class HomePageSteps {
//
//    HomePage homePage;
//
//    @Given("Verify that User is in PWP application's Home Page after login")
//    public void verifyThatUserIsInPWPApplicationSHomePage() {
//        homePage = new HomePage();
//        homePage.isHomePageDisplayed();
//    }
//
//    @Given("Verify that User is in PWP application's Home Page")
//    public void verifyThatUserIsInHomePage() {
//        homePage = new HomePage();
//        homePage.isHomePageDisplayed();
//    }
//
//    @When("Click on Loader Module to perform Loading operations")
//    public void clickOnLoaderModuleToPerformLoadingOperations() {
//        homePage.clickOnLoaderModule();
//
//    }
//
//    @When("Click on Picker Module to perform Picking operations")
//    public void clickOnPickerModuleToPerformPickingOperations() {
//        homePage.clickOnPickerModule();
//    }
//
//    public static void main(String[] args) {
//        System.out.println("hi");
//    }
//
//
//}
