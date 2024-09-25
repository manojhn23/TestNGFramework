package com.automation.tests;

import com.automation.pages.HomePage;
import com.automation.pages.ProductListPage;
import com.automation.pages.SearchPage;
import com.automation.utils.ConfigReader;
import com.automation.utils.DriverManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    HomePage homePage;
    ProductListPage productListPage;
    SearchPage searchPage;

    @BeforeMethod
    public void setUp() {
        ConfigReader.initReader();
        DriverManager.createDriver();
        homePage = new HomePage();
        productListPage = new ProductListPage();
        searchPage = new SearchPage();
    }

    @AfterMethod
    public void closeUp() {
        DriverManager.getDriver().quit();
    }
}
