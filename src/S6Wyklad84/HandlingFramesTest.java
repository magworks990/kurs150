package S6Wyklad84;

import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.awt.*;
import java.util.List;

public class HandlingFramesTest extends BaseSeleniumTest {

    @Test
    public void handlingFramesTest() {
        System.out.println("Drugi TEST");
        driver.get("https://www.google.com");
        driver.findElement(By.name("q")).sendKeys("Selenium", Keys.ENTER);
        driver.findElement(By.xpath("//*[@id=\"rso\"]/div[2]/div/div[1]/div/div/div[1]/a[1]/h3")).click();
        Assert.assertTrue(driver.getTitle().equals("Selenium - Web Browser Automation"));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("alert('Hello World')");

//        driver.switchTo().alert().accept();
//       List <WebElement> elements = driver.findElement(By.tagName("xyz"));
    }
}



