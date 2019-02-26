package S6Wyklad84;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public  abstract class BaseSeleniumTest {
    protected WebDriver driver;

    @BeforeTest
    public void setUp() {
        /*/~~~~~OPEN WEB BROWSER~~~~~/*/
        System.out.println("Wykonuje sie przed klasą");
        driver = new ChromeDriver();
//        WebDriverWait wait = new WebDriverWait(driver, 20);
        String baseUrl = "https://www.seleniumhq.org/";
        driver.get(baseUrl);
//        driver.manage().window().maximize();
    }
    @AfterTest
    public void tearDown(){
        System.out.println("Wykonuje sie po klasie");
//        driver.quit();

    }
}
