package com.travelers.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public  abstract class BaseSeleniumTests {
    public WebDriver driver;

    @BeforeTest
    public void setUp() {
        /*/~~~~~OPEN WEB BROWSER~~~~~/*/
        System.out.println("Before Class");
        driver = new ChromeDriver();
//        WebDriverWait wait = new WebDriverWait(driver, 20);
        String baseUrl = "https://www.phptravels.net/";
        driver.get(baseUrl);
//        driver.manage().window().maximize();
    }
    @AfterTest
    public void tearDown(){
        System.out.println("After class");
//        driver.quit();

    }
}
