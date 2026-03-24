package com.automation.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        // This runs BEFORE every @Test method
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com");
        System.out.println("Browser opened!");
    }

    @Test
    public void validLoginTest() {
        // Test 1: Login with valid credentials
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        // Assert - verify login was successful
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, "https://www.saucedemo.com/inventory.html");
        System.out.println("Valid login test PASSED!");
        
    }

    @Test
    public void invalidLoginTest() {
        // Test 2: Login with invalid credentials
        driver.findElement(By.id("user-name")).sendKeys("wrong_user");
        driver.findElement(By.id("password")).sendKeys("wrong_password");
        driver.findElement(By.id("login-button")).click();

        // Assert - verify error message appears
        String errorMessage = driver.findElement(By.cssSelector("[data-test='error']")).getText();
        Assert.assertTrue(errorMessage.contains("Username and password do not match"));
        System.out.println("Invalid login test PASSED!");
    }

    @AfterMethod
    public void tearDown() {
        // This runs AFTER every @Test method
        driver.quit();
        System.out.println("Browser closed!");
    }
}