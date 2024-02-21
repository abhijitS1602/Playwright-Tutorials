package com.qa.usvia.tests;

import com.microsoft.playwright.Page;
import com.qa.usvisa.factory.PlaywrightFactory;
import com.qa.usvisa.pages.HomePage;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class RescheduleTest {

    PlaywrightFactory playwrightFactory;
    Page page;
    HomePage homePage;

    @BeforeTest
    public void setup(){
        playwrightFactory = new PlaywrightFactory();
        page =  playwrightFactory.initBrowser("chrome");
        homePage = new HomePage(page);
    }

    @Test
    public void search_for_appointment(){
        homePage.sign_in();
    }

    @AfterTest
    public void tearDown(){
        page.context().browser().close();
    }

}
