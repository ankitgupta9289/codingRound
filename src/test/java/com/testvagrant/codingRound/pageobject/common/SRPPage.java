package com.testvagrant.codingRound.pageobject.common;

import com.testvagrant.codingRound.utils.ActionHelper;
import org.openqa.selenium.By;

public abstract class SRPPage {

    private By searchSummary_Lbl = By.className("searchSummary");

    public boolean isPresent_SearchSummary_Lbl() {
        return ActionHelper.isPresentWithWait(searchSummary_Lbl);
    }

    public abstract boolean isPresent_SearchResultsTuples_We();
}
