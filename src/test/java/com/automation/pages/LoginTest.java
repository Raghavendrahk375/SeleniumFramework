package com.automation.pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.automation.pages.LoginPage;

public class LoginTest {

    WebDriver driver;
    LoginPage loginPage;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com");

        // Create LoginPage object and pass driver to it
        loginPage = new LoginPage(driver);
    }

    @Test
    public void validLoginTest() {
        // Using LoginPage method instead of findElement directly
        loginPage.login("standard_user", "secret_sauce");

        Assert.assertEquals(driver.getCurrentUrl(),
            "https://www.saucedemo.com/inventory.html");
        System.out.println("Valid login test PASSED!");
    }

    @Test
    public void invalidLoginTest() {
        // Using LoginPage methods
        loginPage.login("wrong_user", "wrong_password");

        String error = loginPage.getErrorMessage();
        Assert.assertTrue(error.contains("Username and password do not match"));
        System.out.println("Invalid login test PASSED!");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}