package com.DmartLabs.stepdefinitions.extra;

import com.DmartLabs.stepdefinitions.Hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class poss_Steps {

    private com.DmartLabs.bdd.extraPages.Poss_loginPage Poss_loginPage;
    private Hooks hooks;

    public poss_Steps(Hooks hooks) {
        this.hooks = hooks;
     //   this.Poss_loginPage = new Poss_loginPage(hooks.getWindowsDriver());
    }

    @Given("Verify that User is in poss application's Home Page after login {string} {string}")
    public void verifyThatUserIsInPossApplicationSHomePageAfterLogin(String userName, String password) throws InterruptedException {
        Poss_loginPage.enterUserName( userName);
        Poss_loginPage.enterPassword( password);


    }


}
