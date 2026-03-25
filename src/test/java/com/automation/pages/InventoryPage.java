package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InventoryPage {

    WebDriver driver;

    // Locators
    By pageTitle = By.className("title");
    By productList = By.className("inventory_item");
    By cartIcon = By.className("shopping_cart_link");
    By addToCartButton = By.xpath("(//button[contains(text(),'Add to cart')])[1]");
    By cartBadge = By.className("shopping_cart_badge");

    // Constructor
    public InventoryPage(WebDriver driver) {
        this.driver = driver;
    }

    // Actions
    public String getPageTitle() {
        return driver.findElement(pageTitle).getText();
    }

    public int getProductCount() {
        return driver.findElements(productList).size();
    }

    public void addFirstProductToCart() {
        driver.findElement(addToCartButton).click();
    }

    public String getCartCount() {
        return driver.findElement(cartBadge).getText();
    }

    public void clickCart() {
        driver.findElement(cartIcon).click();
    }
}