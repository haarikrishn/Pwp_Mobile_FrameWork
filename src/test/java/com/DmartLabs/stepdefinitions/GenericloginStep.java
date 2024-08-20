package com.DmartLabs.stepdefinitions;

import com.DmartLabs.bdd.pages.Poss_GenericLoginPage;
import com.DmartLabs.commonutils.QXClient;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;

import java.util.List;
import java.util.Map;

public class GenericloginStep {

    Poss_GenericLoginPage poss_genericLoginPage = new Poss_GenericLoginPage(QXClient.getWindowsDriver());

    public GenericloginStep() throws InterruptedException {
    }

    @Given("Verify that User is in poss application's Home Page after login")
    public void verifyThatUserIsInPossApplicationSHomePageAfterLogin(DataTable dataTable) throws InterruptedException {
        List<Map<String, String>> LoginDt = dataTable.asMaps();
        for (int i = 0; i < LoginDt.size(); i++) {
            String userName = LoginDt.get(i).get("userName");
            String password = LoginDt.get(i).get("password");

            Thread.sleep(500);
            poss_genericLoginPage.sendUsername_PassWord_Click_Enter(userName, password);
        }


    }


}
