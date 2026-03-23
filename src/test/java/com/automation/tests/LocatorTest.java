package com.automation.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorTest {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com");

        // Locating using ID
        WebElement username = driver.findElement(By.id("user-name"));
        username.sendKeys("standard_user");
        System.out.println("ID locator worked!");

        // Locating using Name
        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("secret_sauce");
        System.out.println("Name locator worked!");

        // Locating using XPath
        WebElement loginBtn = driver.findElement(By.xpath("//*[@id='login-button']"));
        loginBtn.click();
        System.out.println("XPath locator worked!");

        // Print URL to confirm login
        System.out.println("Current URL: " + driver.getCurrentUrl());

        Thread.sleep(3000);
        driver.quit();
        System.out.println("Test finished!");
    }
}