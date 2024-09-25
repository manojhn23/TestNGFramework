package com.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends BasePage{

    @FindBy(xpath = "//div[@class='top-result']")
    WebElement searchPage;

    @FindBy(xpath = "//h2")
    WebElement msgEle;

    public boolean isSearchPageDisplayed() {
        return searchPage.isDisplayed();
    }

    public String getResultMsg() {
        return msgEle.getText();
    }
}
