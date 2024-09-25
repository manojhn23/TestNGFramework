package com.automation.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SortByTest extends BaseTest {

    @Test
    public void priceLowToHighTest() {
        homePage.opensWebsite();
        Assert.assertTrue(homePage.isHomePageDisplayed());
        homePage.clicksOnShirtsInSearch();
        Assert.assertTrue(productListPage.isProductListPageDisplayed());
        productListPage.clicksOnSortByLowToHigh();
        Assert.assertTrue(productListPage.isPricesSortedLowToHigh());
    }

    @Test
    public void priceHighToLowTest() {
        homePage.opensWebsite();
        Assert.assertTrue(homePage.isHomePageDisplayed());
        homePage.clicksOnShirtsInSearch();
        Assert.assertTrue(productListPage.isProductListPageDisplayed());
        productListPage.clicksOnSortByHighToLow();
        Assert.assertTrue(productListPage.isPricesSortedHighToLow());
    }
}
