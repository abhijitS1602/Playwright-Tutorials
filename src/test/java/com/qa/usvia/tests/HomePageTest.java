package com.qa.usvia.tests;

import com.microsoft.playwright.Page;
import com.qa.usvisa.factory.PlaywrightFactory;
import com.qa.usvisa.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HomePageTest {

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
    public void sign_in(){
        homePage.sign_in();
    }

    @AfterTest
    public void tearDown(){
        page.context().browser().close();
    }

}
