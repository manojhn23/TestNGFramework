package com.automation.tests;

import com.automation.utils.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchTest extends BaseTest{

    @Test
    public void emptySearchTest(){
        homePage.opensWebsite();
        Assert.assertTrue(homePage.isHomePageDisplayed());
        homePage.searchItem("search.item");
        homePage.clicksSearchBtn();
        Assert.assertTrue(searchPage.isSearchPageDisplayed());
        Assert.assertEquals(searchPage.getResultMsg(), ConfigReader.getProperty("result.msg"));
    }
}
