package com.automation.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverActionsTest {

    public static void main(String[] args) throws InterruptedException {

        // Setup and open browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com");

        // Action 1: sendKeys - type into username field
        WebElement username = driver.findElement(By.id("user-name"));
        username.sendKeys("standard_user");
        System.out.println("Typed username!");

        // Action 2: clear - clear the typed text
        username.clear();
        System.out.println("Cleared username field!");

        // Action 3: sendKeys again - retype after clearing
        username.sendKeys("standard_user");
        System.out.println("Retyped username!");

        // Type password
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("secret_sauce");

        // Action 4: click - click login button
        driver.findElement(By.id("login-button")).click();
        System.out.println("Clicked login button!");

        // Action 5: getTitle - read page title
        System.out.println("Page Title: " + driver.getTitle());

        // Action 6: getCurrentUrl - read current URL
        System.out.println("Current URL: " + driver.getCurrentUrl());

        // Action 7: getText - read text from an element
        WebElement title = driver.findElement(By.className("title"));
        System.out.println("Products page heading: " + title.getText());

        // Action 8: navigate back - go to previous page
        driver.navigate().back();
        System.out.println("Navigated back!");
        System.out.println("URL after back: " + driver.getCurrentUrl());

        Thread.sleep(3000);
//        driver.quit();
        System.out.println("Test finished!");
    }
}