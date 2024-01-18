package playwrightsessions;

import com.microsoft.playwright.*;

public class BrowserContextLesson {
    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));

            BrowserContext bc1 =  browser.newContext();
            Page p1 = bc1.newPage();
            p1.navigate("https://www.google.com");
            String title = p1.title();
            System.out.println("Page title is: "+ title);

            BrowserContext bc2 =  browser.newContext();
            Page p2 = bc2.newPage();
            p2.navigate("https://www.facebook.com");
            String title2 = p2.title();
            System.out.println("Page title is: "+ title2);

        }
    }
}
