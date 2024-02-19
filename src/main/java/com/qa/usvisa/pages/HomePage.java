package com.qa.usvisa.pages;

import com.microsoft.playwright.Page;

public class HomePage  {
    private Page page;

    //Locators
    private String username_input_field = "//input[@id='user_email']";
    private String password_input_field = "//input[@id='user_password']";
    private String policy_confirmed_checkbox = "//label[@for='policy_confirmed']";
    private String sign_in_button = "//input[@name='commit']";

    private String attend_appointment_title = "//h4[@class='status']";

    public HomePage(Page page){
        this.page = page;
    }

    public String getHomePageTitle(){
        return page.textContent(attend_appointment_title);
    }

    public void sign_in(){
        page.fill(username_input_field, "rajansingh190701@gmail.com");
        page.fill(password_input_field, "Bitoo190");
        page.click(policy_confirmed_checkbox);
        page.click(sign_in_button);
    }
}
