package com.travelers.tests;

import com.travelers.pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.awt.*;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SearchHotelTest extends BaseSeleniumTests{

    @Test
    public void searchHotelTest() throws InterruptedException, AWTException {
//        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        HomePage homePage = new HomePage(driver);
        homePage.sendCityHotelInput("Dubai");
        homePage.setDateRange("09/05/2019", "09/06/2019");
        homePage.openTravellersModel();
        homePage.addAdult();
        homePage.addChild();
        homePage.addChild();
        homePage.performSearch();
        List<String>hotelNames = homePage.getHotelNames();
        Assert.assertEquals("Hotel-15262",hotelNames.get(0));
        Assert.assertEquals("Hotel-66575",hotelNames.get(1));
        Assert.assertEquals("Hotel-74741",hotelNames.get(2));
        Assert.assertEquals("Hotel-40549",hotelNames.get(3));
        Assert.assertEquals("Hotel-29638",hotelNames.get(4));
        Assert.assertEquals("Hotel-22087",hotelNames.get(5));
        Assert.assertEquals("Hotel-37448",hotelNames.get(6));
        Assert.assertEquals("Hotel-57878",hotelNames.get(7));
        List<String>prices = homePage.getHotelPrices();
        Assert.assertEquals("$150",prices.get(0));
        Assert.assertEquals("$150",prices.get(1));
//        Assert.assertEquals("",prices.get(2));
//        Assert.assertEquals("",prices.get(3));
        Assert.assertEquals("$80",prices.get(2));
        Assert.assertEquals("$150",prices.get(3));
        Assert.assertEquals("$150",prices.get(4));
//        Assert.assertEquals("",prices.get(7));

    }
}