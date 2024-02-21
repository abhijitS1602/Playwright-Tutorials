package com.qa.usvisa.factory;

import com.microsoft.playwright.*;
import com.qa.usvisa.Constants;

import java.sql.SQLOutput;

public class PlaywrightFactory {



    Playwright playwright;
    Browser browser;
    BrowserContext browserContext;
    Page page;

    public Page initBrowser(String browserName){
        System.out.println("Browser is : "+ browserName);

        playwright = Playwright.create();
        switch (browserName.toLowerCase()){
            case "chromium":
                browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
                break;
            case "chrome":
                browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));
                break;
            case "firefox":
                browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
                break;
            case "safari":
                browser =  playwright.webkit().launch(new BrowserType.LaunchOptions().setHeadless(false));
                break;
            default:
                System.out.println("Wrong browser Option");
                break;
        }
        browserContext = browser.newContext();
        page = browserContext.newPage();
        page.navigate(Constants.URL);

        return page;
    }
}
