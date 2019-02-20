import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Wyswietlenia {

    public static void main(String[] args) throws InterruptedException {

        /*/~~~~~OPEN WEB BROWSER~~~~~/*/
        for (int i = 0; i < 70; i++) {

            System.out.println("Wykonuje sie przed klasą = -> " +i);
            WebDriver driver = new ChromeDriver();
            WebDriverWait wait = new WebDriverWait(driver, 500);
            String baseUrl = "https://www.facebook.com/pg/dzialczesci/about/";
            driver.get(baseUrl);
            driver.manage().window().maximize();
            Thread.sleep(3000);

//            wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#u_0_l > div:nth-child(2) > a"))).click();
            Thread.sleep(2500);
            Thread.sleep(2500);
            Thread.sleep(2500);
            Thread.sleep(2500);
            driver.close();
        }
    }
}
