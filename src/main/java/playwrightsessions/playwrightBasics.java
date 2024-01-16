package playwrightsessions;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class playwrightBasics {
    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {
            // Launch chromium, firefox or webkit.
            Browser browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
            Page page = browser.newPage();
            page.navigate("https://www.google.com");
            String title = page.title();
            System.out.println("Page title is: "+ title);

            browser.close();
        }
    }
}


