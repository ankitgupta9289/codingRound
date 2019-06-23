package com.testvagrant.codingRound.pageobject.common;

import com.testvagrant.codingRound.utils.ActionHelper;
import org.openqa.selenium.By;

public class LoginLayer {

    private static LoginLayer _instance = null;
    private By signIn_Btn = By.id("signInButton");
    private By loginErrorMsg_Lbl = By.id("errors1");
    private String frameIDLoginLayer = "modal_window";

    private LoginLayer() {
    }

    public static LoginLayer getInstance() {
        if (_instance == null)
            _instance = new LoginLayer();
        _instance.swithToLoginLayerFrame();
        return _instance;
    }

    public void click_SignIn_Btn() {
        ActionHelper.click(signIn_Btn);
    }

    public void swithToLoginLayerFrame() {
        ActionHelper.swtichToFrame(frameIDLoginLayer);
    }

    public String getText_LoginErrorMsg_Lbl() {
        return ActionHelper.getText(loginErrorMsg_Lbl);
    }

}
