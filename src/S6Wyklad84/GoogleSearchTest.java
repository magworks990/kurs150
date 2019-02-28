package S6Wyklad84;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.Test;


public class GoogleSearchTest extends BaseSeleniumTest {

    @FindBy (name = "q")
    private WebElement search;

    @Test
    public void googleSearchTest() {
        System.out.println("Pierwszy TEST");
        driver.get("https://www.google.com");
        search.sendKeys("selenium");
        search.sendKeys(Keys.ENTER);
        driver.findElement(By.xpath("//*[@id=\"rso\"]/div[2]/div/div[1]/div/div/div[1]/a[1]/h3")).click();
        Assert.assertTrue(driver.getTitle().equals("Selenium - Web Browser Automation"));
    }
}



