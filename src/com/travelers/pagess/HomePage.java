package com.travelers.pages;

import com.travelers.pages.helpers.SeleniumHelper;
import com.travelers.pagess.ResultPage;
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
    private WebDriver driver;
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

    @FindBy(xpath = "//div[@class= 'select2-result-label']")
    private  WebElement selectResult;

    private SeleniumHelper helper;

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.helper = new SeleniumHelper(driver);
    }

    public HomePage setCityHotelInput(String cityName) {
        serchSpan.click();
        searchCityInput.sendKeys(cityName);
        /* By locationLabel = By.xpath("//div[@class= 'select2-result-label']");*/
        helper.waitForElementToBeDisplayed(selectResult);
        searchCityInput.sendKeys(Keys.ENTER);
        return this;
    }

    public HomePage setDateRange(String checkInDate, String checkOutDate) {
        checkInInput.sendKeys(checkInDate);
        checkOutInput.sendKeys(checkOutDate);
        checkOutInput.click();// datapicker kalendaża zostaje
        return this;
    }

    public HomePage openTravellersModel() {
        travellesInput.click();
        helper.waitForElementToBeDisplayed(adultsPlusButton);
        return this;
    }

    public HomePage addAdult() {
        adultsPlusButton.click();
        return this;
    }

    public HomePage addChild() {
        childPlusButton.click();
        return this;
    }

    public ResultPage performSearch() {
        searchButton.click();
        return new ResultPage(driver);
    }
}


