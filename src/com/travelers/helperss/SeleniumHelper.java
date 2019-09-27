package com.travelers.pages.helpers;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.time.*;
import java.util.List;


public class SeleniumHelper {

    private WebDriver driver;

    public SeleniumHelper (WebDriver driver){
        this.driver = driver;
    }

    public void waitForElementToBeDisplayed(WebElement element){
        FluentWait<WebDriver> wait = new FluentWait<>(driver);
        wait.withTimeout(Duration.ofSeconds(15))
                .pollingEvery(Duration.ofMillis(1000))
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForListOfWebElements(List<WebElement> elementList){
        FluentWait<WebDriver> wait = new FluentWait<>(driver);
        wait.withTimeout(Duration.ofSeconds(15))
                .pollingEvery(Duration.ofMillis(1000))
                .ignoring(NoSuchElementException.class);
        wait.until(driver1 ->
                elementList.size()>0);
    }
    public static void takeScreenShot (WebDriver driver) throws IOException {
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File screenShotFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
        File destinationaFile = new File(".idea/" + LocalTime.now().getNano()+".png");
        Files.copy(screenShotFile.toPath(),destinationaFile.toPath());
    }

}
