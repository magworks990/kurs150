import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class S6Wyklad80 {
    public static void main (String[]args){

        /*/~~~~~OPEN WEB BROWSER~~~~~/*/
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, 20);
        String baseUrl = "https://www.google.com/";
        driver.get ( baseUrl );
        driver.manage().window().maximize();


        driver.findElement(By.name("q")).sendKeys("selenium", Keys.ENTER);
}


}
