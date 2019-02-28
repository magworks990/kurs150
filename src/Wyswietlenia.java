import org.openqa.selenium.*;
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
import java.util.concurrent.ThreadLocalRandom;

public class Wyswietlenia {
    private WebDriver driver;
    private WebElement size;

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
        driver.findElement(By.id("email")).sendKeys("lukasz.samsel21@wp.pl");
        driver.findElement(By.id("pass")).sendKeys("lukaszsamsel", Keys.ENTER);
        Thread.sleep(2500);
        driver.findElement(By.id("pass")).sendKeys("lukaszsamsel", Keys.ENTER);
        Thread.sleep(2500);
        driver.get(baseUrl);
        Thread.sleep(2000);
        driver.get("https://www.facebook.com");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"self_bio_100001068058042\"]/div/div[2]/div/div[2]/div[1]/a"))).isDisplayed();
        for (int i = 0; i < 5; i++) {
            Thread.sleep(1000);
            Robot robot = new Robot();
            JavascriptExecutor scroll = (JavascriptExecutor)driver;
            scroll.executeScript("window.scrollBy(0, 250)","");
           // robot.keyPress(KeyEvent.VK_PAGE_DOWN);

        }
        Thread.sleep(1000);
        List<WebElement> elements = driver.findElements(By.className("FriendButton"));
        int size = elements.size();
        System.out.println(elements.size());
        elements.forEach(webElement ->
                System.out.println(webElement.getText()));
        int randomNumber = ThreadLocalRandom.current().nextInt(0,size);
        System.out.println("Pokaż co wylosowałeś " +randomNumber);
        elements.get(randomNumber).click();


//        for (String i = 0; i <size ; i++) {

//            Thread.sleep(2500);
//            driver.quit();
    }
}
