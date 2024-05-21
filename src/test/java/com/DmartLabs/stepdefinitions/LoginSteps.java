package com.DmartLabs.stepdefinitions;

import com.DmartLabs.bdd.pages.LoginPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;

import java.util.Map;

public class LoginSteps {

    @Given("Provide username and password to login to application")
    public void provideUsernameAndPasswordToLoginToApplication(DataTable dataTable) throws InterruptedException {
        Map<String, String> loginCredentials = dataTable.asMap(String.class, String.class);
        LoginPage loginPage = new LoginPage();
        loginPage.loginToPWP(loginCredentials);
    }
}
