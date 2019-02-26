
import org.apache.http.util.Asserts;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;


public class  S6Wyklad81 {
    private WebDriver driver;

    @BeforeTest
    public void setUp(){
        /*/~~~~~OPEN WEB BROWSER~~~~~/*/
        System.out.println("Wykonuje sie przed klasą");
        driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, 20);
        String baseUrl = "https://www.seleniumhq.org/";
        driver.get(baseUrl);
        driver.manage().window().maximize();
    }

    @Test
    public void google() {
        String expectedTitle = "Selenium - Web Browser Automation";
        System.out.println(driver.getTitle());
        Assert.assertEquals(expectedTitle, driver.getTitle());
        Assert.assertTrue(driver.getTitle().equals("Selenium - Web Browser Automation"), "Zły tytuł");
    }

    @Test
    public void googleOpenTest() {
        String expectedTitle = "Selenium - Web Browser Automation";
        System.out.println(driver.getTitle());
        Assert.assertEquals(expectedTitle, driver.getTitle());
        Assert.assertTrue(driver.getTitle().equals("Selenium - Web Browser Automation"), "Zły tytuł");
    }

    @AfterTest
    public void tearDown(){
        System.out.println("Wykonuje sie po klasie");
        driver.quit();

    }
}



