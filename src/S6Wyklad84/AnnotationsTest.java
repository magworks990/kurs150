package S6Wyklad84;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;


public class AnnotationsTest extends BaseSeleniumTest {

    @FindBys({
            @FindBy(xpath = "//div[@data-role='widgetContent']//table[@class='Htable mgT']")
//            @FindBy(linkText = "Weryfikacja dokumentów pozytywna")
    })
    private List<WebElement> elements;

    @FindBy (xpath = "input")
    private List<WebElement>inputs;

    @FindBy (xpath = "//button")
    private List<WebElement> buttons;

    @FindAll({
            @FindBy (xpath = "input"),
            @FindBy (xpath = "//button")
    })
    private List<WebElement> inputsAndButton;
    @Test
    public void googleSearchTest() {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        PageFactory.initElements(driver, this);
        System.out.println("Pierwszy TEST");
        driver.get("http://cc.vm-rc-ecrm-front.ib/login");
        driver.findElement(By.xpath("//*[@id=\"domain\"]")).sendKeys(Keys.TAB, "pziemak", Keys.TAB, "j3537Y3V", Keys.ENTER);
        driver.get("http://cc.vm-rc-ecrm-front.ib/client/contracts/id/1651716/getlist");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"content\"]/div[5]/div[1]/div/div/table")));
        System.out.println("element size is " + elements.size());
        System.out.println("Input size is " + inputs.size());
        System.out.println("Button size is " + buttons.size());
        System.out.println("Inputs And Buttons size is " + inputsAndButton.size());
    }
}



