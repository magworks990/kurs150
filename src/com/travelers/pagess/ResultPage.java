package com.travelers.pagess;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ResultPage {

    @FindBy(xpath = "//table[@class='bgwhite table table-striped']")
    private WebElement resultsTable;

    private com.travelers.pages.helpers.SeleniumHelper helper;

    public ResultPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        helper = new com.travelers.pages.helpers.SeleniumHelper(driver);
    }

    public List<String> getHotelNames() throws AWTException {
        for (int i = 0; i < 4; i++) {
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_PAGE_DOWN);
            helper.waitForListOfWebElements(resultsTable.findElements(By.xpath(".//h4//b")));
        }
        List<String> hotelNames = new ArrayList<>();
        List<WebElement> hotelNameWebElements = resultsTable.findElements(By.xpath(".//h4//b"));
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
