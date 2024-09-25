package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProductListPage extends BasePage {

    @FindBy(xpath = "//h1")
    WebElement productHeader;

    @FindBy(xpath = "//label[contains(text(),'Low To High')]")
    WebElement priceLowToHigh;

    @FindBy(xpath = "//label[contains(text(),'High To Low')]")
    WebElement priceHighToLow;

    @FindBy(xpath = "//div[@class='price']/strong")
    List<WebElement> prices;

    @FindBy(xpath = "//div[@class='sort-value-desk']")
    WebElement sortBy;

    public boolean isProductListPageDisplayed() {
        return productHeader.isDisplayed();
    }

    public void clicksOnSortByLowToHigh() {
        actions.moveToElement(sortBy).pause(1000).click(priceLowToHigh).pause(3000).build().perform();
    }

    public boolean isPricesSortedLowToHigh() {
        List<Double> afterSort = new ArrayList<>();
        List<Double> beforeSort = new ArrayList<>();
        prices = driver.findElements(By.xpath("//div[@class='price']/strong"));
        for (WebElement element : prices) {
            double price = Double.parseDouble(element.getText().substring(1));
            afterSort.add(price);
            beforeSort.add(price);
        }
        Collections.sort(beforeSort);
        return beforeSort.equals(afterSort);
    }

    public void clicksOnSortByHighToLow() {
        actions.moveToElement(sortBy).pause(1000).click(priceHighToLow).pause(3000).build().perform();
    }

    public boolean isPricesSortedHighToLow() {
        List<Double> afterSort = new ArrayList<>();
        List<Double> beforeSort = new ArrayList<>();
        prices = driver.findElements(By.xpath("//div[@class='price']/strong"));
        for (WebElement element : prices) {
            double price = Double.parseDouble(element.getText().substring(1));
            afterSort.add(price);
            beforeSort.add(price);
        }
        beforeSort.sort(Collections.reverseOrder());
        return beforeSort.equals(afterSort);
    }
}
