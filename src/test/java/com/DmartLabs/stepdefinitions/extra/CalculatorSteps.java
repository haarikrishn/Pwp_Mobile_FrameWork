package com.DmartLabs.stepdefinitions.extra;

import com.DmartLabs.bdd.extraPages.Caluclator_Page;
import com.DmartLabs.stepdefinitions.Hooks;
import io.cucumber.java.en.Given;

public class CalculatorSteps {

    private Caluclator_Page caluclatorPage;
    private Hooks hooks;

    public CalculatorSteps(Hooks hooks) {
        this.hooks = hooks;
    //    this.caluclatorPage = new Caluclator_Page(hooks.getWindowsDriver());
    }

    @Given("Verify that User is in calucaltor application's Home Page after login")
    public void verifyThatUserIsInCalucaltorApplicationSHomePageAfterLogin() throws InterruptedException {
        caluclatorPage.performCalculation();

    }


}
