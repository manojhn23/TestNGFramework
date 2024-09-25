package com.automation.pages;

import com.automation.utils.ConfigReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(xpath = "//a[@class='search-bar']")
    WebElement searchIcon;

    @FindBy(xpath = "//div[@class='desktop-banner']")
    WebElement banner;

    @FindBy(xpath = "//a[text()='Men Shirts']")
    WebElement shirtsInSearch;

    @FindBy(xpath = "//button[text()='Search']/preceding-sibling::input")
    WebElement searchInput;

    @FindBy(xpath = "//button[text()='Search']")
    WebElement searchBtn;

    public void opensWebsite() {
        driver.get(ConfigReader.getProperty("base.url"));
    }

    public boolean isHomePageDisplayed() {
        return banner.isDisplayed();
    }

    public void clicksOnShirtsInSearch() {
        searchIcon.click();
        shirtsInSearch.click();
    }

    public void searchItem(String itemKey) {
        searchIcon.click();
        searchInput.sendKeys(ConfigReader.getProperty(itemKey));
    }

    public void clicksSearchBtn() {
        searchBtn.click();
    }
}
