package com.testvagrant.codingRound.testsuite.home;

import com.testvagrant.codingRound.utils.ActionHelper;
import com.testvagrant.codingRound.assertion.CustomAssert;
import com.testvagrant.codingRound.global.GlobalData;
import com.testvagrant.codingRound.pageobject.common.ClearTripHomePage;
import com.testvagrant.codingRound.pageobject.common.LoginLayer;
import com.testvagrant.codingRound.testsuite.base.BaseTestClass;
import org.testng.annotations.Test;

public class ExecutionSuite_Login extends BaseTestClass {

    @Test(groups = {"sanity,login"}, description = "To verify proper error message is displayed when user tries to sign in with blank login details")
    public void tc_Login_001_VerifyVisibility_ErrorMsg_IfSignInDetailsAreMissing() {
        String errorMsg = "There were errors in your submission";
        ActionHelper.openURL(GlobalData.URL_CLEARTRIP);
        ClearTripHomePage clearTripHomePage = ClearTripHomePage.getInstance();
        clearTripHomePage.click_YourTrips_We();
        clearTripHomePage.click_LogIn_Btn();
        LoginLayer loginLayer = LoginLayer.getInstance();
        loginLayer.click_SignIn_Btn();
        CustomAssert.assertContains(loginLayer.getText_LoginErrorMsg_Lbl(), errorMsg,
                "Check error message displayed on doing login with blank username and password");
    }
}
