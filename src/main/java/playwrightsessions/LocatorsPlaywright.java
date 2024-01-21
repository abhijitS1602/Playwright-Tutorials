package playwrightsessions;

import com.microsoft.playwright.*;

import java.util.List;

public class LocatorsPlaywright {
    public static void main(String[] args) {
        try(Playwright playwright = Playwright.create()){
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
            Page page = browser.newPage();
            page.navigate("https://www.orangehrm.com/");

            //Single element
            Locator contactSales = page.locator("text = Contact Sales");
            contactSales.last().click();

            //Multiple Elements
            Locator countryOptions = page.locator("select#Form_getForm_Country option");
            Locator countryDropdown = page.locator("select#Form_getForm_Country");
            countryDropdown.hover();
            countryDropdown.click();

            //method 1 for printing list of countries
            for (int i=0; i < countryOptions.count(); i++){
                String text = countryOptions.nth(i).textContent();
                System.out.println(text);
            }


            //method 2 for printing list of countries
            List<String> listOfCountries = countryOptions.allTextContents();
            for (String e:
                 listOfCountries) {
                System.out.println(e);

            }

        }
    }
}
