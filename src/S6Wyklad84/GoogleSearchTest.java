package S6Wyklad84;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;


public class GoogleSearchTest extends BaseSeleniumTest {


    @FindBy (name = "q")
    private List<WebElement> search;

    @Test
    public void googleSearchTest() {
        PageFactory.initElements(driver, this);
        System.out.println("Pierwszy TEST");
        driver.get("https://www.google.com");
        int size = search.size();
        int randomNumber = ThreadLocalRandom.current().nextInt(0,size);
        search.get(randomNumber).sendKeys("Selenium");
        search.get(randomNumber).sendKeys(Keys.ENTER);
        driver.findElement(By.xpath("//*[@id=\"rso\"]/div[2]/div/div[1]/div/div/div[1]/a[1]/h3")).click();
        Assert.assertTrue(driver.getTitle().equals("Selenium - Web Browser Automation"));
    }
}

//    int size = elements.size();
//        System.out.println(elements.size());
//                elements.forEach(webElement ->
//                System.out.println(webElement.getText()));
//                int randomNumber = ThreadLocalRandom.current().nextInt(0,size);
//                System.out.println("Pokaż co wylosowałeś " +randomNumber);
//                elements.get(randomNumber).click();

