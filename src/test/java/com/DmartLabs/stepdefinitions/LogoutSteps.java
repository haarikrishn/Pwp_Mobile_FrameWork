package com.DmartLabs.stepdefinitions;

import com.DmartLabs.bdd.pages.HomePage;
import com.DmartLabs.bdd.pages.LoaderPage;
import com.DmartLabs.bdd.pages.LoginPage;
import com.DmartLabs.bdd.pages.picker1Page;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

import java.util.Map;

public class LogoutSteps {

    HomePage homePage;
    LoaderPage loaderPage;
    com.DmartLabs.bdd.pages.picker1Page picker1Page;


    @Given("Logout the user from Loader application")
    public void logoutTheUserFromLoaderApplication() {
        loaderPage = new LoaderPage();
        loaderPage.logoutUser();
    }

    @Given("Logout the user from Picker application")
    public void logoutTheUserFromPickerApplication() {
        picker1Page = new picker1Page();
        picker1Page.logoutUser();
    }

    @And("Logout the user from application")
    public void logoutTheUserFromApplication() throws InterruptedException {
        homePage = new HomePage();
        homePage.logoutUser();
    }
}
