package com.travelers.pages;

import com.travelers.pages.helpers.SeleniumHelper;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javax.lang.model.element.Element;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.nio.file.WatchEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class HomePage {
    //*******************************
    @FindBy(xpath = "//span[text()='Search by Hotel or City Name']")
    private WebElement serchSpan;

    @FindBy(xpath = "//div[@id='select2-drop']//input")
    private WebElement searchCityInput;
    //*******************************
    @FindBy(name = "checkin")
    private WebElement checkInInput;

    @FindBy(name = "checkout")
    private WebElement checkOutInput;
    //*******************************
    @FindBy(id = "travellersInput")
    private WebElement travellesInput;

    @FindBy(id = "adultPlusBtn")
    private WebElement adultsPlusButton;

    @FindBy(id = "childPlusBtn")
    private WebElement childPlusButton;

    @FindBy(xpath = "//button[text()=' Search']")
    private WebElement searchButton;

    @FindBy(xpath = "//table[@class='bgwhite table table-striped']")
    private WebElement resultsTable;

    @FindBy(xpath = "//div[@class= 'select2-result-label']")
    private  WebElement selectResult;

    private SeleniumHelper helper;

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.helper = new SeleniumHelper(driver);
    }

    public void sendCityHotelInput(String cityName) {
        serchSpan.click();
        searchCityInput.sendKeys(cityName);
        By locationLabel = By.xpath("//div[@class= 'select2-result-label']");
        helper.waitForElementToByDisplay(locationLabel);
        searchCityInput.sendKeys(Keys.ENTER);
    }

    public void setDateRange(String checkInDate, String checkOutDate) {
        checkInInput.sendKeys(checkInDate);
        checkOutInput.sendKeys(checkOutDate);
        checkOutInput.click();// datapicker kalendaża zostaje
    }

    public void openTravellersModel() {
        travellesInput.click();
    }

    public void addAdult() {
        adultsPlusButton.click();
    }

    public void addChild() {
        childPlusButton.click();
    }

    public void performSearch() {
        searchButton.click();
    }



    public List<String> getHotelNames() throws AWTException, InterruptedException {
        for (int i = 0; i < 2; i++) {
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_PAGE_DOWN);
            Thread.sleep(1000);
        }
        List<String> hotelNames = new ArrayList<>();
        List<WebElement> hotelNameWebElements = resultsTable.findElements(By.xpath("//h4//b"));
        for (WebElement hotelNameWebElement : hotelNameWebElements) { //hotelName z kolekkcji HotlNames
            System.out.println("Znalazłem Hotel: " + hotelNameWebElement.getText());
            hotelNames.add(hotelNameWebElement.getText());
        }
        return hotelNames;
    }
    public List<String> getHotelPrices() {
        List<WebElement> hotelPrices = resultsTable.findElements(By.xpath("//div[contains(@class,'price_tab')]//b"));
        List <String> prices = hotelPrices.stream().map(element -> element.getText()).collect(Collectors.toList());
        return prices;
    }
}


