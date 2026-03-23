package com.automation.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstTest {

    public static void main(String[] args) throws InterruptedException {

        // Setup and open browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com");

        // Find username field using ID and type into it
        WebElement usernameField = driver.findElement(By.id("user-name"));
        usernameField.sendKeys("standard_user");

        // Find password field using ID and type into it
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("secret_sauce");

        // Find login button using ID and click it
        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();

        // Print current URL to confirm login worked
        System.out.println("Current URL: " + driver.getCurrentUrl());

        Thread.sleep(3000);
        driver.quit();
        System.out.println("Test finished!");
    }
}