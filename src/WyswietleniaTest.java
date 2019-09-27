import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.w3c.dom.html.HTMLSelectElement;


import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.*;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.ThreadLocalRandom;

public class WyswietleniaTest {

    public static void main(String[] args) throws InterruptedException {

        /*/~~~~~OPEN WEB BROWSER~~~~~/*/
        //for (int i = 0; i < 70; i++) {
        /*
        Znalazłem wspólny ixpth ->> //div[@data-name='GroupProfileGridItem']
                                    //div[@data-name='GroupProfileGridItem']//div[@class='FriendButton']
         */
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, 500);
        String baseUrl = "https://www.facebook.com";
        driver.get(baseUrl);
        Thread.sleep(3000);
        driver.findElement(By.id("email")).sendKeys("lukasz.samsel21@wp.pl");
        driver.findElement(By.id("pass")).sendKeys("lukaszsamsel", Keys.ENTER);
        Thread.sleep(2500);
//        driver.findElement(By.id("pass")).sendKeys("lukaszsamsel", Keys.ENTER);
        driver.get(baseUrl);
        Thread.sleep(2000);
        driver.get("https://www.facebook.com/groups/222664904823804/members/");
//        driver.get("https://www.facebook.com/groups/385823398185966/members/");


        try {
            for (int i = 0; i < 5; i++) {
                System.out.print("\rSkrola użyto " + i + " razy");
                if (driver.findElement(By.id("groupsMemberBrowser")).getText().contains("Paweł Grzegorczyk123")) {
                    System.out.println("\nStrona została przewinięta do końca");
                    break;
                } else if (!driver.findElement(By.id("groupsMemberBrowser")).getText().contains("Paweł Grzegorczyk123")) {
                    Robot robot = new Robot();
                    JavascriptExecutor scroll = (JavascriptExecutor) driver;
                    scroll.executeScript("window.scrollBy(0, 5000)", "");
                }
            }
        } catch (Exception e) {
        }

        try {
            List<WebElement> friendButtons = driver.findElements(By.className("FriendButton"));
            int size = friendButtons.size();
            int licznik = 0;
            System.out.print("Pokaż rozmiar: " + size);
            for (WebElement friendButton : friendButtons) {
                if (friendButton.getText().contains("Dodaj")) {
//                    Thread.sleep(6000);
                    friendButton.click();
                    System.out.println("Wysłano " + licznik++ +" zaproszenie");
//                    Thread.sleep(1000);
                }
            }
//        } catch (WebDriverException ignored) {
        } catch (Exception e) {
        }
    }
}

//        try {
//            List<WebElement> friendButtons = driver.findElements(By.className("FriendButton"));
//            int numbers = friendButtons.size();
//            int licznik = 0;
//            for (WebElement friendButton : friendButtons) {
//                Thread.sleep(2000);
//                if (friendButton.getText().contains("Dodaj")) {
//                    friendButton.click();
//                    System.out.println("Wysłano " + licznik++ +" zaproszenie");
//                    System.out.println(" ");
//                }
//            }
//        } catch (WebDriverException ignored) {
//        }
//    }


//        List<WebElement> friendButtons = driver.findElements(By.className("FriendButton"));
//        int size = friendButtons.size();
//        System.out.println("Pokaż rozmiar: " + size);
//        for (WebElement friendButton : friendButtons) {
//            if (friendButton.getText().contains("Dodaj")) {
//                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("FriendButton")));
//                friendButton.click();
//            }
//        }

//                List <WebElement> friendsButton = (List<WebElement>) wait.until(ExpectedConditions.elementToBeClickable(By.className("FriendButton")));
//                for (WebElement friendButton : friendsButton) {
//                    if (driver.findElement(By.xpath("//span[contains(text(),'Znajomi')]"))) {
//                        friendButton.click();
//                    }
//                }
////            for (int k = 5; k >= 0; k--) {
//                List<WebElement> elements = driver.findElements(By.className("FriendButton"));
//                int size = elements.size();
//                System.out.println("Pojaż rozmiar listy " + elements.size());
//                for (int index = 0; index < elements.size(); index++)
//                    System.out.println("Numer " + index + " status: " +elements.get(index).getText());
//                        for (WebElement element : elements.contains(By.xpath("//span[contains(text(),'Znajomi')]"))){
//                if (wait.until(ExpectedConditions.elementToBeClickable(By.className("FriendButton"))).getText().contains("Dodaj znajomego")){
//                    driver.findElement(By.className("FriendButton")).click();
//                    System.out.println("Dodano znalomego");
//                } else if (driver.findElement(By.className("FriendButton")).getText().contains("Wysłano zaproszenie do grona znajomych")) {
//                    System.out.println("Juz już wysłano zaproszenie do znajmoka");
//                } else if (driver.findElement(By.className("FriendButton")).getText().contains("Znajomi")) {
//                    System.out.println("Juz jest znajomkiem");
//                } else {
//                }


//                List<WebElement> elements = driver.findElements(By.className("FriendButton"));
//                for (int index =0; index <elements.size(); index++) {
//                    int randomNumber = ThreadLocalRandom.current().nextInt(0, size);
//                    System.out.println("Pokaż co wylosowałeś " + randomNumber);
//                    System.out.println("Pokaż ile razy losowałeś znajomka " + index);
//                    elements.get(randomNumber).click();
//                    Thread.sleep(2000);
//                }




