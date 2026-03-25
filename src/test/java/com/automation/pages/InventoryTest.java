package com.automation.pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.automation.pages.LoginPage;
import com.automation.pages.InventoryPage;

public class InventoryTest {

    WebDriver driver;
    LoginPage loginPage;
    InventoryPage inventoryPage;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com");

        // Create page objects
        loginPage = new LoginPage(driver);
        inventoryPage = new InventoryPage(driver);

        // Login before every test
        loginPage.login("standard_user", "secret_sauce");
    }

    @Test
    public void verifyInventoryPageTitle() {
        // Verify we are on the right page
        String title = inventoryPage.getPageTitle();
        Assert.assertEquals(title, "Products");
        System.out.println("Page title verified: " + title);
    }

    @Test
    public void verifyProductCount() {
        // Verify 6 products are displayed
        int count = inventoryPage.getProductCount();
        Assert.assertEquals(count, 6);
        System.out.println("Product count verified: " + count);
    }

    @Test
    public void verifyAddToCart() {
        // Add first product to cart
        inventoryPage.addFirstProductToCart();

        // Verify cart badge shows 1
        String cartCount = inventoryPage.getCartCount();
        Assert.assertEquals(cartCount, "1");
        System.out.println("Cart count verified: " + cartCount);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}