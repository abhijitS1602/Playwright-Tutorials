package com.qa.usvisa.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.qa.usvisa.Constants;

import java.util.ArrayList;
import java.util.List;


public class HomePage {
    private Page page;

    //Locators
    private final String username_input_field = "//input[@id='user_email']";
    private final String password_input_field = "//input[@id='user_password']";
    private final String policy_confirmed_checkbox = "//label[@for='policy_confirmed']";
    private final String sign_in_button = "//input[@name='commit']";
    private final String continue_button = "//a[.='Continue']";
    private final String reschdule_tab = "(//a[@role='tab'])[4]";
    private final String reschdule_appointment_buttton = "//a[.='Reschedule Appointment']";

    private String city_dropdown = "//select[@id='appointments_consulate_appointment_facility_id']";

    private final String date_of_appointment = "//input[@id='appointments_consulate_appointment_date']";
    private final String smonth1 = "(//span[@class='ui-datepicker-month'])[1]";
    private final String smonth2 = "(//span[@class='ui-datepicker-month'])[2]";
    private final String syear1 = "(//span[@class='ui-datepicker-year'])[1]";
    private final String syear2 = "(//span[@class='ui-datepicker-year'])[2]";

    private final String next_button = "//a[@data-handler='next']";

    private final String month_locator ="(//tbody//td//a/ancestor::tbody/ancestor::table/preceding-sibling::div//div//span)[1]";
    private final String year_locator ="(//tbody//td//a/ancestor::tbody/ancestor::table/preceding-sibling::div//div//span)[2]";

    public HomePage(Page page){
        this.page = page;
    }

    public void sign_in() throws InterruptedException {
        page.fill(username_input_field, Constants.USERNAME);
        Thread.sleep(3000);
        page.fill(password_input_field, Constants.PASSWORD);
        Thread.sleep(3000);

        page.click(policy_confirmed_checkbox);
        page.click(sign_in_button);

        Thread.sleep(4000);
        page.click(continue_button);
        page.click(reschdule_tab);
        page.click(reschdule_appointment_buttton);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        if(page.locator("#consulate_date_time_not_available").isVisible()){
            System.out.println("Dates are suspended! Please try again later");
            page.context().browser().close();
            System.exit(0);
        }

        page.click(date_of_appointment);

        String smonth1_string = page.textContent(smonth1);
        String smonth2_string = page.textContent(smonth2);
        String syear1_string = page.textContent(syear1);
        String syear2_string = page.textContent(syear2);

        String smonthyear1 = smonth1_string +" "+syear1_string;
        String smonthyear2 = smonth2_string +" "+syear2_string;

        while(!smonthyear1.contains(Constants.STARTFROM) && !smonthyear2.contains(Constants.STARTFROM)){
            page.click(next_button);
            smonth1_string = page.textContent(smonth1);
            smonth2_string = page.textContent(smonth2);
            syear1_string = page.textContent(syear1);
            syear2_string = page.textContent(syear2);

            smonthyear1 = smonth1_string +" "+syear1_string;
            smonthyear2 = smonth2_string +" "+syear2_string;
        }

        List<Locator> days = new ArrayList<Locator>();

        while(days.isEmpty()){
            days = page.locator("//tbody//td//a").all();

            String month1_string = page.textContent(smonth1);
            String month2_string = page.textContent(smonth2);
            String year1_string = page.textContent(syear1);
            String year2_string = page.textContent(syear2);

            String monthyear1 = month1_string +" "+year1_string;
            String monthyear2 = month2_string +" "+year2_string;

            if(days.isEmpty() && !monthyear1.contains(Constants.FINDTILL) && !monthyear2.contains(Constants.FINDTILL)){
                page.click(next_button);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }else if(!days.isEmpty()) {
                String month, year;
                for(Locator we: days) {
                    month = page.textContent(month_locator);
                    year = page.textContent(year_locator);

                    System.out.println("DATE AVAILABLE: "+we.textContent()+", "+month+", "+year);
                    break;
                }
                }else {
                System.out.println("No Dates are available");
                break;
            } //else end

        } //while end
        page.reload();
    }
}




