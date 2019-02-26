package S6Wyklad84;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;


public class GoogleSearchTest extends BaseSeleniumTest {

    @Test
    public void googleSearchTest() {
        System.out.println("Pierwszy TEST");
        driver.get("https://www.google.com");
        driver.findElement(By.name("q")).sendKeys("Selenium", Keys.ENTER);
        driver.findElement(By.xpath("//*[@id=\"rso\"]/div[2]/div/div[1]/div/div/div[1]/a[1]/h3")).click();
        Assert.assertTrue(driver.getTitle().equals("Selenium - Web Browser Automation"));
    }
}



