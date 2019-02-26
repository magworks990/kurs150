import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.w3c.dom.html.HTMLSelectElement;


import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Wyswietlenia {
    private WebDriver driver;

    @Test
    public void facebook() throws InterruptedException, AWTException {

        /*/~~~~~OPEN WEB BROWSER~~~~~/*/
      //for (int i = 0; i < 70; i++) {

     // System.out.println("Wykonuje sie przed klasą = -> " +i);
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, 500);
        String baseUrl = "https://www.facebook.com/pg/dzialczesci/about/";
        driver.get(baseUrl);
        Thread.sleep(3000);
        driver.findElement(By.id("email")).sendKeys("lukasz.samsel890@wp.pl");
        driver.findElement(By.id("pass")).sendKeys("Polska123", Keys.ENTER);
        Thread.sleep(2500);
        driver.findElement(By.id("pass")).sendKeys("Polska123", Keys.ENTER);
        Thread.sleep(2500);
        driver.get(baseUrl);
//            wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("clickOnMe"))).click();
//            driver.findElement(By.xpath("//button")).click();
        Thread.sleep(2000);
        driver.get("https://www.facebook.com/adrian.perzan.7/friends?lst=100034222998205%3A100002502470344%3A1551122864&source_ref=pb_friends_tl");
        wait.until(ExpectedConditions.elementToBeClickable(By.id("pagelet_timeline_app_collection_100002502470344:2356318349:2"))).isDisplayed();
       for (int i = 0; i < 20; i++) {
                       Thread.sleep(1000);
           Robot robot = new Robot();
           robot.keyPress(KeyEvent.VK_PAGE_DOWN);
       }
        Random r = new java.util.Random();
        Select firmaToJa = new Select(driver.findElement(By.id("pagelet_timeline_app_collection_100002502470344:2356318349:2")));
//        List<WebElement> element = (driver.findElement(By.id("pagelet_timeline_app_collection_100002502470344:2356318349:2")));
//        WebElement randomElement = element.get(r.nextInt(element.size()));
        System.out.println("pokaż co znalazłeś " +firmaToJa);

//            Thread.sleep(2500);
//            driver.quit();
    }
}
