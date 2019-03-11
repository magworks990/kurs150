package com.travelers.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ReslutPage {

    @FindBy(xpath = "//table[@class='bgwhite table table-striped']")
    private WebElement resultsTable;

    public ReslutPage (WebDriver driver){

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
        List<String> prices = hotelPrices.stream().map(element -> element.getText()).collect(Collectors.toList());
        return prices;
    }
}
