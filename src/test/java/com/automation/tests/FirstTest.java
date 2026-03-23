package com.automation.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FirstTest {
	
	public static void main(String[] args) throws InterruptedException {
		
        // Step 1: Setup ChromeDriver automatically
        WebDriverManager.chromedriver().setup();
        
        // Step 2: Launch Chrome browser
		WebDriver driver=new ChromeDriver();
		
        // Step 3: Maximize the window
		driver.manage().window().maximize();
		
        // Step 4: Open the website
        driver.get("https://www.saucedemo.com");
        
        // Step 5: Print page title in console
        System.out.println("Page Title: "+ driver.getTitle());
        
        // Step 6: Wait 3 seconds so you can see the browser
        Thread.sleep(3000);
        
        // Step 7: Close browser
        driver.quit();
        
        
        System.out.println("Testing Finished!!!");
        

	}

}
